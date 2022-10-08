package edu.northeastern.numad22fa_amaltharyan;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.os.Handler;
import android.widget.Toast;

public class PrimeDirectiveActivity extends AppCompatActivity {
    private Button findPrimes;
    private Button terminateSearch;
    private TextView text1;
    private TextView text2;
    private Handler textHandler = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prime_directive);

        findPrimes = (Button) findViewById(R.id.find_primes);
        terminateSearch = (Button) findViewById(R.id.terminate_search);

        text1 = findViewById(R.id.currentNumber);
        text2 = findViewById(R.id.currentNumber2);

        final myThread th = new myThread();

        findPrimes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                th.start();
            }
        });


        terminateSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               th.terminate();
            }
        });

    }

    class myThread extends Thread{

        private volatile boolean running = true;
        //private volatile boolean infiniteRun = true;
        public void terminate(){
            running = false;
        }

        @Override
        public void run() {
            while(running) {
                for (int i = 3; ; i += 2) {
                    if(running == false){
                        break;
                    }
                    final int finalI = i;
                    textHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            text1.setText("Current number: " + finalI);
                            if (isPrime(finalI)) {
                                text2.setText("Latest prime found: " + finalI);
                            }
                        }
                    });
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        public boolean isPrime(int n) {
            if (n == 1) {
                return false;
            }

            // looping from 2 to half of the number and checking if its divisible by those numbers
            for (int i = 2; i <= n / 2; i++) {
                if (n % i == 0) {
                    return false;
                }
            }
            return true;
        }

    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("User Verification")
                .setMessage("Do you want to close this activity?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }

                })
                .setNegativeButton("No", null)
                .show();
    }

}

