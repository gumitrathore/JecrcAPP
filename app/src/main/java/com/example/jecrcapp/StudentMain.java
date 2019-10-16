package com.example.jecrcapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class StudentMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_main);
        CardView Cafe = (CardView) findViewById(R.id.cvCafeSt);
        CardView Lost = (CardView) findViewById(R.id.cvLost);
        CardView Clean = (CardView) findViewById(R.id.cvCleanSt);
        CardView Event = (CardView) findViewById(R.id.cvEvent);


        Cafe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StudentMain.this,CafeActivity.class);
                startActivity(intent);

            }
        });

        Lost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        Clean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StudentMain.this,CleanActivity.class);
                startActivity(intent);
            }
        });

        Event.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


    }
}
