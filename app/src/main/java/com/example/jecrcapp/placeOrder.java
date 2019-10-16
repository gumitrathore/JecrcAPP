package com.example.jecrcapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

public class placeOrder extends AppCompatActivity {
    String [] cart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent =getIntent();
        cart= intent.getStringArrayExtra("string-array");
        Log.e("blej",cart[0]);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_order);
        fetch();
    }
    public void fetch()
    {

        for(int i=0;i<cart.length&&cart[i]!=null;i++){


            LinearLayout linear=(LinearLayout)findViewById(R.id.mvid);
            LinearLayout.LayoutParams params =
                    new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT);
            CardView cv=new CardView(this);
            cv.setLayoutParams(params);
            cv.setContentPadding(2, 1, 2, 1);
            cv.setMaxCardElevation(5);
            cv.setCardElevation(9);
            TextView tv=new TextView(this);
            tv.setText(""+cart[i]);
            tv.setTextColor(getResources().getColor(R.color.colorAccent));
            tv.setTextSize(23);
            cv.addView(tv);
            linear.addView(cv);


        }

    }
    }

