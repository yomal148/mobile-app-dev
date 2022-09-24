package edu.northeastern.numad22fa_amaltharyan;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // calling the super
        setContentView(R.layout.activity_main); // inflate the layout

        Button click = (Button) findViewById(R.id.button2); //get reference to clicky clicky button
        click.setBackgroundColor(Color.RED);
    }

    public void toastMsg(String msg){
        Toast toast = Toast.makeText(this, msg, Toast.LENGTH_LONG);
        toast.show();
    }


    public void displayToastMsg(View v) {
        toastMsg("Hello, my name is Amal and my email is tharyan.a@northeastern.edu");
    }
}