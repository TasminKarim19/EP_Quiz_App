package com.example.checkyourenglishproficiency;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Result extends AppCompatActivity {
    TextView Result;
    int Totalmarks;


    Button shResult,shAns;
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://checkyourenglishproficiency-default-rtdb.firebaseio.com/");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);


        Intent myIntent = getIntent();
        Totalmarks = myIntent.getIntExtra(MainActivity10.extramarks, 0);
        Result = findViewById(R.id.resultTextView);
        shResult = findViewById(R.id.shResultBtnID);
        shAns = findViewById(R.id.shAnsBtnID);

        shAns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               startActivity(new Intent(Result.this,ShowAnswer.class));
            }
        });



    }
    public void showResult(View view){


        if(Totalmarks >= 18){
            Result.setText("You have scored "+ Totalmarks+ "\nYour proficiency level is independent");
        }else  if(Totalmarks >= 14){
            Result.setText("You have scored "+ Totalmarks+ "\nYour proficiency level is intermidiate");
        }else  if(Totalmarks >= 14){
            Result.setText("You have scored "+ Totalmarks+ "\nYour proficiency level is beginner");
        }else{
            Result.setText("You have scored "+ Totalmarks+ "\nYou are getting started");
        }

    }

}