package edu.northeastern.numad22fa_amaltharyan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.view.View;
import android.widget.Toast;

public class ClickyClickyActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // calling the super
        setContentView(R.layout.activity_clicky_clicky); // inflate the layout
        TextView textView = (TextView)findViewById(R.id.pressed); // get reference to text view
        textView.setText("Pressed:-"); // Set initial text to Pressed
    }

    // Adding event handling methods for each button
    public void onClickButtonA (View view){
        TextView textView = (TextView)findViewById(R.id.pressed); // get reference to text view
        int theId = view.getId();
        if(theId == R.id.A){
            textView.setText("Pressed:-A");
        }else{
            textView.setText("Pressed:");
        }
    }

    public void onClickButtonB (View view){
        TextView textView = (TextView)findViewById(R.id.pressed); // get reference to text view
        int theId = view.getId();
        if(theId == R.id.B){
            textView.setText("Pressed:-B");
        }else{
            textView.setText("Pressed:");
        }
    }

    public void onClickButtonC (View view){
        TextView textView = (TextView)findViewById(R.id.pressed); // get reference to text view
        int theId = view.getId();
        if(theId == R.id.C){
            textView.setText("Pressed:-C");
        }else{
            textView.setText("Pressed:");
        }
    }

    public void onClickButtonD (View view){
        TextView textView = (TextView)findViewById(R.id.pressed); // get reference to text view
        int theId = view.getId();
        if(theId == R.id.D){
            textView.setText("Pressed:-D");
        }else{
            textView.setText("Pressed:");
        }
    }

    public void onClickButtonE (View view){
        TextView textView = (TextView)findViewById(R.id.pressed); // get reference to text view
        int theId = view.getId();
        if(theId == R.id.E){
            textView.setText("Pressed:-E");
        }else{
            textView.setText("Pressed:");
        }
    }

    public void onClickButtonF (View view){
        TextView textView = (TextView)findViewById(R.id.pressed); // get reference to text view
        int theId = view.getId();
        if(theId == R.id.F){
            textView.setText("Pressed:-F");
        }else{
            textView.setText("Pressed:");
        }
    }
}