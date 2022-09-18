package com.example.checkyourenglishproficiency;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioGroup myRadioGroup;
    int marks;
    static  final String extramarks="Marks From First Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myRadioGroup=findViewById(R.id.myRadioGroupID);
    }

    public void nextFunction(View view) {
        if(myRadioGroup.getCheckedRadioButtonId()==R.id.radioBtn1Id){
            marks=2;
        }
        else {
            marks=0;
        }
        Intent myIntent= new Intent(this,MainActivity2.class);
        myIntent.putExtra(extramarks,marks);
        startActivity(myIntent);

    }
}