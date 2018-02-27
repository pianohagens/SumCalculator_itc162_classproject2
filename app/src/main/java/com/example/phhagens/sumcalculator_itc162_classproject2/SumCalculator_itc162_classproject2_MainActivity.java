package com.example.phhagens.sumcalculator_itc162_classproject2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

public class SumCalculator_itc162_classproject2_MainActivity extends AppCompatActivity
        implements View.OnClickListener {

    //define variable for the widgets
    private EditText inputNumber1;
    private EditText inputNumber2;
    private TextView showAnswer;
    private Button clickButton;
    private Button resetBtn;

    //define the shared pref object
    private SharedPreferences saveInputs;

    //define variables to be saved
    private int num1 = 0;
    private int num2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sum_calculator_itc162_classproject2__main);

        //get reference to the widgets
        inputNumber1 = (EditText)findViewById(R.id.inputNumber1);
        inputNumber2 = (EditText)findViewById(R.id.inputNumber2);
        clickButton = (Button)findViewById(R.id.clickButton);
        showAnswer = (TextView)findViewById(R.id.showAnswer);
        resetBtn = (Button)findViewById(R.id.resetBtn);

        //set the listener //02/07/2018 common this when handle it to event
       clickButton.setOnClickListener((View.OnClickListener) this);

        //get SharePreferences object
        saveInputs = getSharedPreferences("saveInputs", MODE_PRIVATE);
    }

    public void calculateAndShow(){
        //turn string to float
        num1 = Integer.parseInt(inputNumber1.getText().toString());
        num2 = Integer.parseInt(inputNumber2.getText().toString());
        float add = num1 + num2;
        showAnswer.setText(String.valueOf(add));
    }

    @Override
    public void onClick(View view){
        calculateAndShow();
    }

    @Override
    public void onPause(){
        super.onPause();
        //save the instance variable
        SharedPreferences.Editor editor = saveInputs.edit();
        editor.putInt("num1", num1);
        editor.putInt("num2", num2);
        editor.commit();
    }
    @Override
    public void onResume(){
        super.onResume();
        //get the instance variable
        num1 = saveInputs.getInt("num1", num1);
        num2 = saveInputs.getInt("num2", num2);

    }

    //for the reset Button
    public void Clear(View clear){
        inputNumber1.setText("");
        inputNumber2.setText("");
        showAnswer.setText("");
    }
}
