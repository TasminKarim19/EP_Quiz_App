package com.example.checkyourenglishproficiency;


import androidx.activity.result.contract.ActivityResultContracts;
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

public class login extends AppCompatActivity {

    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://checkyourenglishproficiency-default-rtdb.firebaseio.com/");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        final   EditText phone = findViewById(R.id.phone);
        final   EditText password = findViewById(R.id.password);
        final Button loginBtn = findViewById(R.id.loginBtn);
        final TextView registerNowBtn = findViewById(R.id.registerNowBtn);


        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String phoneTXT = phone.getText().toString();
                final String passwordTXT = password.getText().toString();

                if (phoneTXT.isEmpty() || passwordTXT.isEmpty()) {
                    Toast.makeText(login.this, "Please enter your mobile or password", Toast.LENGTH_SHORT).show();
                } else {

                    databaseReference.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            // chech if phone number exists in firebase database
                            if(snapshot.hasChild(phoneTXT)){
                                //number exists in firebase
                                final String getPassword = snapshot.child(phoneTXT).child("password").getValue(String.class);
                                if(getPassword.equals(passwordTXT)){
                                    Toast.makeText(login.this, "Successfully Logged in", Toast.LENGTH_SHORT).show();

                                    startActivity(new Intent(login.this, MainActivity.class));
                                }else{
                                    Toast.makeText(login.this, "Wrong Password", Toast.LENGTH_SHORT).show();
                                }

                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });



                }
            }
        });

        registerNowBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
            startActivity(new Intent(login.this,Register.class));
            }
        });


    }
}