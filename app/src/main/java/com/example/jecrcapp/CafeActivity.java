package com.example.jecrcapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CafeActivity extends AppCompatActivity {
    private Button viewcart;
    private Button add1,add2,add3;
    private Button sub1,sub2,sub3;
    int x[] = new int[]{0,0,0,0,0,0,0,0,0,0};
    String[] cart = new String[10];
    int count=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cafe);
        viewcart = findViewById(R.id.ViewCart);
        add1 = findViewById(R.id.add1);
        add2 = findViewById(R.id.add2);
        add3 = findViewById(R.id.add3);
        sub1 = findViewById(R.id.sub1);
        sub2 = findViewById(R.id.sub2);
        sub3 = findViewById(R.id.sub3);

        add1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                x[0]+=1;
                TextView tv = (TextView)findViewById(R.id.quantity1);
                tv.setText("Items="+x[0]);

            }
        });

        add2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                x[1]+=1;
                TextView tv = (TextView)findViewById(R.id.quantity2);
                tv.setText("Items="+x[1]);
            }
        });

        add3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                x[2]+=1;
                TextView tv = (TextView)findViewById(R.id.quantity3);
                tv.setText("Items="+x[2]);
            }
        });

        sub1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (x[0]>1) {
                    x[0]-=1;
                    TextView tv = (TextView)findViewById(R.id.quantity1);
                    tv.setText("Items="+x[0]);
                }else if (x[0]==1){
                    x[0]-=1;
                    TextView tv = (TextView)findViewById(R.id.quantity1);
                    tv.setText("");
                }
            }
        });

        sub2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (x[1]>1) {
                    x[1]-=1;
                    TextView tv = (TextView)findViewById(R.id.quantity2);
                    tv.setText("Items="+x[1]);
                }else if (x[1]==1){
                    x[1]-=1;
                    TextView tv = (TextView)findViewById(R.id.quantity2);
                    tv.setText("");
                }
            }
        });

        sub3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (x[2]>1) {
                    x[2]-=1;
                    TextView tv = (TextView)findViewById(R.id.quantity3);
                    tv.setText("Items="+x[2]);
                }else if (x[2]==1){
                    x[2]-=1;
                    TextView tv = (TextView)findViewById(R.id.quantity3);
                    tv.setText("");
                }
            }
        });

        viewcart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int sum =0;
//        if (x[0]==0&&x[1]==0&&x[2]==0){
//            Toast.makeText(MainActivity.this,"Enter an item in cart to proceed",Toast.LENGTH_LONG);
//
//        }else{
                if (x[0] > 0) {
                    String s = new String("Samosa : 10 X " + x[0] + "=" + (10 * x[0]));
                    sum += 10 * x[0];
                    cart[0] = s;

                }
                if (x[1] > 0) {
                    String s = new String("Kachori : 15 X " + x[1] + "=" + (15 * x[1]));
                    sum += 15 * x[1];
                    cart[1] = s;
                }
                if (x[2] > 0) {
                    String s = new String("Maggie : 30 x " + x[2] + "=" + (30 * x[2]));
                    sum += 30 * x[2];
                    cart[2] = s;
                }
                String totalSum = new String("Total Cart Value = " + sum);
                cart[3] = totalSum;

                Intent intent = new Intent(CafeActivity.this, placeOrder.class);
                Bundle b = new Bundle();
                b.putStringArray("string-array", cart);
                intent.putExtras(b);

                startActivity(intent);
            }
        });
    }

}
