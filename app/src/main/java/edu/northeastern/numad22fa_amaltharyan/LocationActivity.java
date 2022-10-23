package edu.northeastern.numad22fa_amaltharyan;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts.RequestMultiplePermissions;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.Priority;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.TimeUnit;

public class LocationActivity extends AppCompatActivity{
    private TextView locationText;
    private TextView distanceTravelled;
    private Button resetDistance;

    private float distance;

    private FusedLocationProviderClient fusedLocationClient;

    // LocationRequest - Requirements for the location updates, i.e.,
    // how often you should receive updates, the priority, etc.
    private LocationRequest locationRequest;

    // LocationCallback - Called when FusedLocationProviderClient
    // has a new Location
    private LocationCallback locationCallback;

    // This will store current location info
    private Location currentLocation = null;

    // This will store current location info
    private Location initialLocation = null;

    private final ActivityResultLauncher<String[]> requestPermissionLauncher =
            registerForActivityResult(new RequestMultiplePermissions(), permissions -> {

                Boolean fineLocationGranted = permissions.getOrDefault(
                        Manifest.permission.ACCESS_FINE_LOCATION, false);
                Boolean coarseLocationGranted = permissions.getOrDefault(
                        Manifest.permission.ACCESS_COARSE_LOCATION, false);
                if ((fineLocationGranted != null && fineLocationGranted) && (coarseLocationGranted != null && coarseLocationGranted)) {
                    // Precise location access granted.
                    initializeFuseLocation();
                } else {
                    // No location access granted.
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setMessage(R.string.locationPermissionRejected)
                            .setTitle(R.string.locationRejectedTitle);
                    builder.setNeutralButton(R.string.ok, (dialog, id) -> dialog.dismiss());
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                }
            });


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);

        locationText = (TextView) findViewById(R.id.location_text);

        distanceTravelled = (TextView) findViewById(R.id.distance_travelled);
        resetDistance = (Button) findViewById(R.id.btn_reset_distance);
        resetDistance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initialLocation = null;
                setDistance();
            }
        });
        createLocationRequest();
        createLocationCallback();

        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) ==
                PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this,
                android.Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            initializeFuseLocation();
        } else if (shouldShowRequestPermissionRationale(android.Manifest.permission.ACCESS_FINE_LOCATION)) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(R.string.showReasonMessage)
                    .setTitle(R.string.showReasonTitle);
            builder.setPositiveButton(R.string.requestPermission, (dialog, id) -> dialog.dismiss());
            builder.setNegativeButton(R.string.cancel, (dialog, id) -> dialog.dismiss());
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        } else {
            requestPermissionLauncher.launch(new String[]{
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION
            });
        }

    }

    @SuppressLint("MissingPermission")
    private void initializeFuseLocation() {
        resetDistance.setVisibility(View.VISIBLE);
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(LocationActivity.this);
        fusedLocationClient.requestLocationUpdates(locationRequest, locationCallback, Looper.myLooper());

        fusedLocationClient.getLastLocation()
                .addOnSuccessListener(this, new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {
                        // Got last known location. In some rare situations this can be null.
                        if (location != null) {
                            currentLocation = location;
                            setLocation();
                        }
                    }
                });
    }

    private void setLocation() {
        if (currentLocation != null) {
            // Logic to handle location object
            double longitude = currentLocation.getLongitude();
            double latitude = currentLocation.getLatitude();

            if (initialLocation == null) {
                initialLocation = currentLocation;
            }

            setDistance();
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    locationText.setText(getString(R.string.current_location, latitude, longitude));
                    locationText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 22f);
                }
            });
        }
    }

    private void setDistance() {
        if(currentLocation == null || initialLocation ==null){
            distance = 0;
        }else{
            if(initialLocation.getLatitude() != currentLocation.getLatitude() || initialLocation.getLongitude() != currentLocation.getLongitude()){
                distance += currentLocation.distanceTo(initialLocation);
            }
        }
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                distanceTravelled.setText(getString(R.string.totalDistance, distance));
                distanceTravelled.setTextSize(TypedValue.COMPLEX_UNIT_SP, 22f);
            }
        });
    }

    @Override
    protected void onStop() {
        removeTask();
        super.onStop();
    }

    private void removeTask(){
        fusedLocationClient.removeLocationUpdates(locationCallback).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    // Log.d(TAG, "Location Callback removed.")
                } else {
                    //Log.d(TAG, "Failed to remove Location Callback.")
                }
            }
        });
    }

    protected void createLocationRequest() {
        LocationRequest.Builder locationRequestBuilder = new LocationRequest.Builder(TimeUnit.SECONDS.toMillis(1))
                .setMinUpdateIntervalMillis(TimeUnit.SECONDS.toMillis(1))
                .setPriority(Priority.PRIORITY_HIGH_ACCURACY);
        locationRequest = locationRequestBuilder.build();
    }

    protected void createLocationCallback() {
        locationCallback = new LocationCallback() {
            @Override
            public void onLocationAvailability(@NonNull LocationAvailability locationAvailability) {
                super.onLocationAvailability(locationAvailability);

            }

            @Override
            public void onLocationResult(@NonNull LocationResult locationResult) {
                super.onLocationResult(locationResult);
                if (locationResult.getLastLocation() != null) {
                    currentLocation = locationResult.getLastLocation();
                    setLocation();
                }

            }
        };
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(R.string.back_pressed_alert)
                .setTitle(R.string.alert);
        builder.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                LocationActivity.this.finish();
            }
        });
        builder.setNegativeButton(R.string.cancel, (dialog, id) -> dialog.dismiss());

        AlertDialog alertDialog = builder.create();
        alertDialog.show();


    }
}
