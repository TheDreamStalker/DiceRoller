package com.example.diceroller;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;

import android.os.Bundle;
import android.text.InputType;
import android.view.View;

import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private String m_Text;

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
        int number = r.nextInt (7);

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

    public void on_dicebreaker_click(View view){
        String[] questions = {
                "If you could go anywhere in the world, where would you go?",
                "If you were stranded on a desert island, what three things would you want to take with you?",
                "If you could eat only one food for the rest of your life, what would that be?",
                "If you won a million dollars, what is the first thing you would buy?",
                "If you could spend the day with one fictional character, who would it be?",
                "If you found a magic lantern and a genie gave you three wishes, what would you wish?",
        };

        //Random number used to pick a question from the array.
        Random z = new Random();
        int y = z.nextInt(questions.length);

        //Create an alert dialog for the question.
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        //Set the questions as the message of the alert.
        builder.setTitle("Dicebreakers");
        builder.setMessage(questions[y]);
        //Creates the EditText so that the user can type their answer.
        final EditText input = new EditText(this);
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        builder.setView(input);

        //Sets up the ok button and later shows the builder so that the dialog appears.
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                m_Text = input.getText().toString();
            }
        });
        builder.show();
    }
}