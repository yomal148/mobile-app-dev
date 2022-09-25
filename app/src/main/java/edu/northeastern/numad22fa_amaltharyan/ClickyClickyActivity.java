package edu.northeastern.numad22fa_amaltharyan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ClickyClickyActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // calling the super
        setContentView(R.layout.activity_clicky_clicky); // inflate the layout

        TextView textView = (TextView)findViewById(R.id.pressed); // get reference to text view
        textView.setText("Pressed:-"); // set initial text to Pressed:-
    }
}