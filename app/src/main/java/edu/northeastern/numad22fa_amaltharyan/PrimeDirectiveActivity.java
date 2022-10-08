package edu.northeastern.numad22fa_amaltharyan;

import androidx.appcompat.app.AppCompatActivity;

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

    private boolean running = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prime_directive);

        Handler textHandler = new Handler();
        findPrimes = (Button) findViewById(R.id.find_primes);
        terminateSearch = (Button) findViewById(R.id.terminate_search);

        text1 = findViewById(R.id.currentNumber);
        text2 = findViewById(R.id.currentNumber2);


        final Thread th = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!running) {
                    for (int i = 3; ; i += 2) {
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
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });


        findPrimes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                th.start();
            }
        });

        terminateSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                running = true;
                Toast.makeText(PrimeDirectiveActivity.this, "Terminated", Toast.LENGTH_LONG).show();
            }
        });

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

