package com.example.checkyourenglishproficiency;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity7 extends AppCompatActivity {
    int Totalmarks;
    RadioGroup myRadioGroup;
    static  final String extramarks="Marks From 7th Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        Intent myIntent = getIntent();
        Totalmarks = myIntent.getIntExtra(MainActivity6.extramarks, 0);
        myRadioGroup = findViewById(R.id.q7myRadioGroupID);
    }

    public void nextFunction(View view) {
        if (myRadioGroup.getCheckedRadioButtonId() == R.id.q7radioBtn4Id) {
            Totalmarks=Totalmarks+2;
        } else {
            Totalmarks=Totalmarks+0;
        }
        Intent myIntent= new Intent(this,MainActivity8.class);
        myIntent.putExtra(extramarks,Totalmarks);
        startActivity(myIntent);
    }
}