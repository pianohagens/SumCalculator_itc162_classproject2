package com.example.phhagens.sumcalculator_itc162_classproject2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class itc162_classProject2_2nd_MainActivity extends AppCompatActivity {

    //create an instance variable
    private TextView resultContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itc162_class_project2_2nd__main);

        //get a reference to the text view
        resultContainer = (TextView)findViewById(R.id.resultContainer);

        //get values from the other activity
        Bundle bundle = getIntent().getExtras();
        int num1 = bundle.getInt("num1");
        int num2 = bundle.getInt("num2");

        //add the values
        int sum = num1 + num2;

        //display the result to the result container
        resultContainer.setText(Integer.toString(sum));

    }
}
