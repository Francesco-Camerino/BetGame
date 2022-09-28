package com.example.betgame;

import android.app.Application;

public class GlobalAmount extends Application {
   private Integer amountValue = 100;

    public void setAmountValue(Integer amountValue) {
        this.amountValue = amountValue;
    }

    public Integer getAmountValue() {
        return amountValue;
    }


}
