package edu.northeastern.numad22fa_amaltharyan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    private Button aboutMe;
    private Button click;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // calling the super
        setContentView(R.layout.activity_main); // inflate the layout

        click = (Button) findViewById(R.id.clicky_clicky); // get reference to clicky clicky button
        click.setBackgroundColor(Color.RED); // setting button background color to red

        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoClickyClickyActivity(view);
            }
        });

        aboutMe = (Button) findViewById(R.id.about_me); // get reference to about me button
        aboutMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoAboutMeActivity(view);
            }
        });
    }


    // navigate to About me activity
    public void gotoAboutMeActivity(View v){
        Intent intent = new Intent(MainActivity.this, AboutMeActivity.class);
        startActivity(intent);
    }

    // Utilize intent class to navigate to ClickyClicky class
    public void gotoClickyClickyActivity(View v){
        Intent intent = new Intent(MainActivity.this, ClickyClickyActivity.class);
        startActivity(intent);
    }

}