package com.example.simplebridlecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void buttonClicked(View v){
        EditText length1_input = findViewById(R.id.length1Box);
        EditText length2_input = findViewById(R.id.length2Box);
        EditText length3_input = findViewById(R.id.length3Box);
        EditText mass_input = findViewById(R.id.massBox);

        double length1 = Double.parseDouble(length1_input.getText().toString());
        double length2 = Double.parseDouble(length2_input.getText().toString());
        double length3 = Double.parseDouble(length3_input.getText().toString());
        double mass = Double.parseDouble(mass_input.getText().toString());

        BridleCalculator calc1 = new BridleCalculator(length1, length2, length3, mass);
        calc1.calcTension();
        @SuppressLint("DefaultLocale") String tension1ans = "Tension 1(Newtons):" + String.format("%.2f" ,calc1.getTension1());
        @SuppressLint("DefaultLocale") String tension2ans = "Tension 2(Newtons):" + String.format("%.2f", calc1.getTension2());
        ((TextView) findViewById(R.id.tension1Result)).setText(tension1ans);
        ((TextView) findViewById(R.id.tension2Result)).setText(tension2ans);
    }
}
