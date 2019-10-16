package com.example.jecrcapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CardView Student = (CardView) findViewById(R.id.cvStudent);
        CardView Cafe = (CardView) findViewById(R.id.cvCafe);
        CardView Clean = (CardView) findViewById(R.id.cvClean);
        ImageView logo = (ImageView) findViewById(R.id.Logo);
        logo.setImageResource(R.drawable.logo);
        Student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,LoginStudent.class);
                startActivity(intent);
            }
        });

        Clean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ImageCleanActivity.class);
                startActivity(intent);
            }
        });
    }

}
