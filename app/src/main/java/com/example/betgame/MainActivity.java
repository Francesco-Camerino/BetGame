package com.example.betgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    //even = false odd = true


    public static final String EXTRA_AMOUNT_VALUE = "EXTRA_AMOUNT_VALUE";
    public static final String EXTRA_BET_VALUE = "EXTRA_BET_VALUE";
    public static final String EXTRA_BET_ODD_EVEN = "EXTRA_BET_ODD_EVEN";

    TextView amountTextView;
    EditText betTextNumber;
    ToggleButton evenOddToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Integer amount = ((GlobalAmount) this.getApplication()).getAmountValue();
        amountTextView = findViewById(R.id.amountTextView);
        amountTextView.setText(amount.toString());
    }
    public void openBetActivity(View view) {

        betTextNumber = findViewById(R.id.betTextNumber);
        evenOddToggle = findViewById(R.id.evenOddToggle);
        Integer amountValue = ((GlobalAmount) this.getApplication()).getAmountValue();
        if (amountValue == -1) {
            amountValue = Integer.parseInt(amountTextView.getText().toString());
        }
        Integer betValue = Integer.parseInt(betTextNumber.getText().toString());
        Boolean evenOddValue = evenOddToggle.isChecked();
       Intent mainToBetIntent = new Intent(this,BetActivity.class);
       mainToBetIntent.putExtra("EXTRA_BET_VALUE",betValue);
       mainToBetIntent.putExtra("EXTRA_BET_ODD_EVEN",evenOddValue);
       startActivity(mainToBetIntent);
    }

}