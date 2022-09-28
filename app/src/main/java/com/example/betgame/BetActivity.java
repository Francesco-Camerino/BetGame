package com.example.betgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class BetActivity extends AppCompatActivity {
    public final String BET_ACTIVITY_LOG = "BET_ACTIVITY_LOG";
    public static final String EXTRA_NEW_AMOUNT_VALUE = "EXTRA_NEW_AMOUNT_VALUE";
    TextView betValueTextView;
    TextView resultTextView;
    Integer newAmountValue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bet);
        Bundle extras = getIntent().getExtras();
        Integer amountValue = ((GlobalAmount) this.getApplication()).getAmountValue();
        Integer betValue = extras.getInt(MainActivity.EXTRA_BET_VALUE);
        Boolean betOddEven =extras.getBoolean(MainActivity.EXTRA_BET_ODD_EVEN);
        Integer numberToBet =  (int) (Math.random() * 100) + 1;
        boolean isOdd;

        betValueTextView = findViewById(R.id.betValueTextView);
        resultTextView = findViewById(R.id.resultTextView);
        if (numberToBet % 2 != 0) {
            isOdd = true;
        } else {
            isOdd = false;
        }
        if(isOdd == betOddEven) {
            resultTextView.setText("You won! ");
            newAmountValue = amountValue + betValue;
        } else {
            resultTextView.setText("You lost. ");
            if (amountValue - betValue > 0) {
                newAmountValue = amountValue - betValue;
            } else {
                newAmountValue = 0;
            }
        }
        ((GlobalAmount) this.getApplication()).setAmountValue(newAmountValue);
        resultTextView.append("The number was " + numberToBet + " your amount is "+ newAmountValue);

        betValueTextView.setText(betValue.toString());
    }
    public void openMainActivity(View view) {
        Intent betToMainIntent = new Intent(this,MainActivity.class);
        startActivity(betToMainIntent);
    }
}