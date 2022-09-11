package edu.northeastern.numad22fa_amaltharyan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void toastMsg(String msg){
        Toast toast = Toast.makeText(this, msg, Toast.LENGTH_LONG);
        toast.show();
    }

    public void displayToastMsg(View v) {
        toastMsg("Hello how are you today, my name is Amal and my email is tharyan.a@northeastern.edu");
    }
}