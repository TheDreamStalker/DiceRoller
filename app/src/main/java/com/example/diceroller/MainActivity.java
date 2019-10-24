package com.example.diceroller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void on_button_click(View view) {
        //Variables for the number output, user's guess and score.
        TextView tv = this.findViewById(R.id.textView) ;
        TextView guess = this.findViewById(R.id.user_guess);
        TextView score = this.findViewById(R.id.scoreID);

        //Random number is generated.
        Random r = new Random();
        int number = r.nextInt (6);

        tv.setText(Integer.toString(number));

        //Handle exceptions in case there is no input.
        try{
            int n = Integer.valueOf(tv.getText().toString());
            int userNumber = Integer.valueOf(guess.getText().toString());

            //Compares if the user's guess is the same as the random no.
            if (userNumber == n) {
                int Score = Integer.valueOf(score.getText().toString());
                int ScoreChecker = Score + 1;

                score.setText(Integer.toString(ScoreChecker));

                //Display congratulations.
                Toast.makeText(getApplicationContext(), "Congratulations, you guessed it!", Toast.LENGTH_SHORT).show();
            }
        }
        catch(Exception e){
            Toast.makeText(getApplicationContext(), "Please input your guess", Toast.LENGTH_SHORT).show();
        }
    }
}