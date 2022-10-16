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
    private Button linkCollector;
    private Button primeDirective;
    private Button location;

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

        linkCollector = (Button) findViewById(R.id.link_collector); // get reference to link collector button
        linkCollector.setBackgroundColor(Color.BLACK);

        linkCollector.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {gotoLinkCollectorActivity(view);}
        });

        primeDirective = (Button) findViewById(R.id.prime_directive);
        primeDirective.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {gotoPrimeDirectiveActivity(view);}
        });

        location = (Button) findViewById(R.id.location); // get reference to location button
        location.setBackgroundColor(Color.MAGENTA);
        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoLocationActivity(view);
            }
        });
    }


    // navigate to About me activity
    public void gotoAboutMeActivity(View v){
        Intent intent = new Intent(this, AboutMeActivity.class);
        startActivity(intent);
    }

    // navigate to ClickyClicky activity
    public void gotoClickyClickyActivity(View v){
        Intent intent = new Intent(this, ClickyClickyActivity.class);
        startActivity(intent);
    }

    // navigate to LinkCollector activity
    public void gotoLinkCollectorActivity(View v){
        Intent intent = new Intent(this, LinkCollectorActivity.class);
        startActivity(intent);
    }

    // navigate to Prime Directive activity
    public void gotoPrimeDirectiveActivity(View v){
        Intent intent = new Intent(this, PrimeDirectiveActivity.class);
        startActivity(intent);
    }

    // navigate to Location activity
    public void gotoLocationActivity(View v){
        Intent intent = new Intent(this, LocationActivity.class);
        startActivity(intent);
    }
}