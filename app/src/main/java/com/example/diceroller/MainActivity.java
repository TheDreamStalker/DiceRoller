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

        TextView tv = this.findViewById(R.id.textView);
        TextView guess = this.findViewById(R.id.user_guess);
        


        Random r = new Random();
        int number = r.nextInt (6);


        tv.setText(Integer.toString(number));

    }
}