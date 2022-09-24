package edu.northeastern.numad22fa_amaltharyan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // calling the super
        setContentView(R.layout.activity_main); // inflate the layout

        Button click = (Button) findViewById(R.id.clicky_clicky); // get reference to clicky clicky button
        click.setBackgroundColor(Color.RED); // setting button background color to red

    }

    // Displays a toast message when button is clicked
    public void toastMsg(String msg){
        Toast toast = Toast.makeText(this, msg, Toast.LENGTH_LONG);
        toast.show();
    }

    // Button click listener when button is clicked
    public void displayToastMsg(View v) {
        toastMsg("Hello, my name is Amal and my email is tharyan.a@northeastern.edu");
    }

    // Utilize intent class to navigate to ClickyClicky class
    public void gotoClickyClickyActivity(View v){
        Intent intent = new Intent(MainActivity.this, ClickyClickyActivity.class);
        startActivity(intent);
    }

}