package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText userInput;
    TextView message;
    Button subButton, resetButton;

    int randomNumber = generatingNumber();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userInput = findViewById(R.id.userInput);
        message = findViewById(R.id.txtGuess);
        subButton = findViewById(R.id.subButton);
        resetButton = findViewById(R.id.resetButton);

        subButton.setOnClickListener(this);
        resetButton.setOnClickListener(this);
    }

    @SuppressLint({"SetTextI18n", "NonConstantResourceId"})
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.subButton:
                String input = userInput.getText().toString();
                int convertInput = Integer.parseInt(input);
                if (convertInput > randomNumber) {
                    message.setText("Too high");
                } else if (convertInput < randomNumber) {
                    message.setText("Too low");
                } else {
                    message.setText("Congratulations!!! The correct number was: " + randomNumber);
                }
                break;
            case R.id.resetButton:
                randomNumber = generatingNumber();
                message.setText("");
                userInput.setText("");
                userInput.requestFocus();
                break;
            default:
                break;
        }

    }

    public int generatingNumber(){
        Random rand = new Random();
        return rand.nextInt(20);
    }

}