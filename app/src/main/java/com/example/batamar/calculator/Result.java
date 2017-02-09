package com.example.batamar.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Result extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        String firstNumber = getIntent().getStringExtra(MainActivity.EXTRA_FIRST_NUMBER);
        String secondNumber = getIntent().getStringExtra(MainActivity.EXTRA_SECOND_NUMBER);

        TextView textView = (TextView) findViewById(R.id.text_result);
        textView.setText(generateCalculatedString(firstNumber,secondNumber));
    }

    private StringBuilder generateCalculatedString(String firstNumber, String secondNumber){
        StringBuilder string = new StringBuilder(firstNumber + " + ");
        if(secondNumber.matches("^-\\d+$")) string.append("( " + secondNumber + " )");
        else string.append(secondNumber);
        string.append(" = " + (Integer.valueOf(firstNumber) + Integer.valueOf(secondNumber)));
        return string;
    }
}
