package com.example.guessnumber;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int count = 0;
    private int r1, r2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NewRandom();
    }

    private void NewRandom() {

        if (count == 5) {
            count = 0;
            Toast.makeText(this, "Jheeez You won the game", Toast.LENGTH_SHORT).show();
        } else {
            Random rand = new Random();
            r1 = rand.nextInt(10);
            while (true) {
                r2 = rand.nextInt(10);
                if (r1 != r2) break;
            }

            Button b = findViewById(R.id.buttonLeft);
            b.setText(Integer.toString(r1));

            Button b1 = findViewById(R.id.buttonRight);
            b1.setText(Integer.toString(r2));

        }
    }

        public void onClickLeft (View view){
            if (r1 > r2)
                count++;
            else
                count--;

            TextView txt = findViewById(R.id.textViewResults);
            txt.setText("Points: " + count);
            NewRandom();
        }


        public void onClickRight (View view){
            if (r1 < r2)
                count++;
            else
                count--;

            TextView txt = findViewById(R.id.textViewResults);
            txt.setText("Points: " + count);
            NewRandom();
        }
    }


