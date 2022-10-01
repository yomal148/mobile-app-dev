package edu.northeastern.numad22fa_amaltharyan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

public class AboutMeActivity extends AppCompatActivity {
    private EditText name;
    private EditText email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_me);

        name = (EditText) findViewById(R.id.editTextTextPersonName); // get reference to name text box
        name.setText("Amal Tharyan"); // Setting text to my name

        email = (EditText) findViewById(R.id.editTextTextEmailAddress); // get reference to email text box
        email.setText("tharyan.a@northeastern.edu"); // Setting text to email


    }

}