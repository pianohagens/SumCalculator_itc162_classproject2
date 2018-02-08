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

public class SumCalculator_itc162_classproject2_MainActivity extends AppCompatActivity{

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

    @SuppressLint("WrongConstant")
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

        //set the listener
       //02/07/2018 clickButton.setOnClickListener((View.OnClickListener) this);

        //get SharePreferences object
        saveInputs = getSharedPreferences("saveInputs", MODE_PRIVATE);
    }
    /*02/07/2018
    public void calculateAndShow(){
        //turn string to float
        num1 = Float.parseFloat(inputNumber1.getText().toString());
        num2 = Float.parseFloat(inputNumber2.getText().toString());
        float add = num1 + num2;
        showAnswer.setText(String.valueOf(add));
    }*/

    //02/07/2018@Override
    //02/07/2018public void onClick(View view) {
    //02/07/2018calculateAndShow();
    //02/07/2018}

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
        num1 = saveInputs.getInt("num1",num1);
        num2 = saveInputs.getInt("num2",num2);

    }

    public void sendMessage(View View){
        //set an intent that you are going to invoke the second activity from the first activity 02/07/2018
        Intent intent = new Intent(SumCalculator_itc162_classproject2_MainActivity.this, itc162_classProject2_2nd_MainActivity.class);
        //get values for the numbers to be added
        num1 = Integer.parseInt(inputNumber1.getText().toString());
        num2 = Integer.parseInt(inputNumber2.getText().toString());

        intent.putExtra("num1", num1);
        intent.putExtra("num2", num2);

        startActivity(intent);
    }

    //for the reset Button
    public void Clear(View clear){
        inputNumber1.setText("");
        inputNumber2.setText("");
        showAnswer.setText("");
    }
    //make some change for commit again

}
