package com.example.checkyourenglishproficiency;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class ShowAnswer extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    String[] question ={"Select","Question1","Question2","Question3","Question4","Question5","Question6","Question7","Question8","Question9","Question10"};

    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_answer);
        spinner = findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);

        ArrayAdapter array = new ArrayAdapter(this, android.R.layout.simple_spinner_item,question);

        array.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner.setAdapter(array);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        String text  = parent.getItemAtPosition(position).toString();

       Fragment myFragment ;
        if(text.equals("Question1")){
            myFragment = new Q1fragment();
        }else if(text.equals("Question2")){
            myFragment = new Q2fragment();
        }
        else if(text.equals("Question3")){
            myFragment = new Q3fragment();
        }  else if(text.equals("Question4")){
            myFragment = new Q4fragment();
        }  else if(text.equals("Question5")){
            myFragment = new Q5fragment();
        } else if(text.equals("Question6")){
            myFragment = new Q6fragment();
        } else if(text.equals("Question7")){
            myFragment = new Q7fragment();
        } else if(text.equals("Question8")){
            myFragment = new Q8fragment();
        } else if(text.equals("Question9")){
            myFragment = new Q9fragment();
        } else if(text.equals("Question10")){
            myFragment = new Q10fragment();
        }
        else{
            myFragment = new BlankFragment();
        }
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.myFragment,myFragment);
        ft.commit();


    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}