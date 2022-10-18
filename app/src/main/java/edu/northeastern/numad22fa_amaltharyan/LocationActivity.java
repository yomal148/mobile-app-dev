package edu.northeastern.numad22fa_amaltharyan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LocationActivity extends AppCompatActivity implements LocationListener {
    private TextView locationText;
    private TextView distanceTravelled;
    private LocationManager locationManager;
    private Location last;
    private float distance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);

        locationText = (TextView)findViewById(R.id.location_text);
        locationManager = (LocationManager) getSystemService( Context.LOCATION_SERVICE );

        distanceTravelled = (TextView)findViewById(R.id.distance_travelled);
        if (ActivityCompat.checkSelfPermission( this, android.Manifest.permission.ACCESS_FINE_LOCATION ) !=
                PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission( this,
                android.Manifest.permission.ACCESS_COARSE_LOCATION ) != PackageManager.PERMISSION_GRANTED) {
            return;
        }

        Location location = locationManager.getLastKnownLocation(locationManager.GPS_PROVIDER);
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 5, this );
        onLocationChanged(location);

    }



    @Override
    public void onLocationChanged(@NonNull Location location) {
        double longitude = location.getLongitude();
        double latitude = location.getLatitude();

        locationText.setText("Current Location" + "\n\n" + "Latitude: " + latitude + "\n" + "Longitude: " + longitude);
        locationText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 22f);

        if(last != null){
            distance += location.distanceTo(last);
        }

        last = new Location(location);

        distanceTravelled.setText("Total distance: " + distance + " meters");
    }


}
