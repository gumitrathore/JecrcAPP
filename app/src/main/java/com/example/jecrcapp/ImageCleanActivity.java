package com.example.jecrcapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ImageCleanActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private CleanAdapter mAdapter;
    private Button btDelete;

    private DatabaseReference mDatabaseRef;
    private List<UploadClean> mUploads;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_clean);

       /* btDelete = findViewById(R.id.btDelete);

        btDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        }); */

        mRecyclerView = findViewById(R.id.rvClean);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mUploads = new ArrayList<>();

        mDatabaseRef = FirebaseDatabase.getInstance().getReference("uploads");

        mDatabaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
             for(DataSnapshot postSnapshot : dataSnapshot.getChildren())
             {
                UploadClean uploadClean = postSnapshot.getValue(UploadClean.class);
                mUploads.add(uploadClean);
             }
             mAdapter = new CleanAdapter(ImageCleanActivity.this,mUploads);
             mRecyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(ImageCleanActivity.this,databaseError.getMessage()
                ,Toast.LENGTH_SHORT).show();
            }
        });
    }
}
