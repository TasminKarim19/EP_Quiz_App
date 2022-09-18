package com.example.checkyourenglishproficiency;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.checkyourenglishproficiency.MainActivity;
import com.example.checkyourenglishproficiency.R;

public class MainActivity10 extends AppCompatActivity {
    int Totalmarks;
    RadioGroup myRadioGroup;
    static  final String extramarks="Marks From 10th Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main10);
        Intent myIntent = getIntent();
        Totalmarks = myIntent.getIntExtra(MainActivity9.extramarks, 0);
        myRadioGroup = findViewById(R.id.q10myRadioGroupID);
    }

    public void nextFunction(View view) {
        if (myRadioGroup.getCheckedRadioButtonId() == R.id.q10radioBtn2Id) {
            Totalmarks=Totalmarks+2;
        } else {
            Totalmarks=Totalmarks+0;
        }
        Intent myIntent= new Intent(this,Result.class);
        myIntent.putExtra(extramarks,Totalmarks);
        startActivity(myIntent);
    }
}