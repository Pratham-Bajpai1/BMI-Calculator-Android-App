package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    android.widget.Button calculateBMI;
    TextView currentHeight, currentWeight, currentAge;
    ImageView decrementWeight, incrementWeight, decrementAge, incrementAge;
    SeekBar seekbarHeight;
    RelativeLayout male, female;


    int weight = 55;
    int age = 19;
    int currentProgress;
    String intprogress = "150";
    String typeofUser = "0";
    String weight2 = "55";
    String age2 = "19";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calculateBMI = findViewById(R.id.calculatebmi);
        currentAge = findViewById(R.id.currentAge);
        currentWeight = findViewById(R.id.currentWeight);
        currentHeight = findViewById(R.id.currentHeight);
        incrementAge = findViewById(R.id.incrementAge);
        decrementAge = findViewById(R.id.decrementAge);
        incrementWeight = findViewById(R.id.incrementWeight);
        decrementWeight = findViewById(R.id.decrementWeight);
        seekbarHeight = findViewById(R.id.seekbarHeight);
        male = findViewById(R.id.male);
        female = findViewById(R.id.female);



        male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                male.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.malefemalefocus));
                female.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.malefemalenotfocus));
                typeofUser = "Male";
            }
        });

        female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                female.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.malefemalefocus));
                male.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.malefemalenotfocus));
                typeofUser = "Female";
            }
        });


        seekbarHeight.setMax(350);
        seekbarHeight.setProgress(150);
        seekbarHeight.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                currentProgress = progress;
                intprogress = String.valueOf(currentProgress);
                currentHeight.setText(intprogress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        incrementAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                age = age + 1;
                age2 = String.valueOf(age);
                currentAge.setText(age2);
            }
        });

        decrementAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                age = age - 1;
                age2 = String.valueOf(age);
                currentAge.setText(age2);
            }
        });

        incrementWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                weight = weight + 1;
                weight2 = String.valueOf(weight);
                currentWeight.setText(weight2);
            }
        });

        decrementWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                weight = weight - 1;
                weight2 = String.valueOf(weight);
                currentWeight.setText(weight2);
            }
        });



        calculateBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(typeofUser.equals("0")){
                    Toast.makeText(getApplicationContext(), "Please Select Gender.", Toast.LENGTH_SHORT).show();
                }
                else if(intprogress.equals("0")){
                    Toast.makeText(getApplicationContext(), "Please Select Height.", Toast.LENGTH_SHORT).show();
                }
                else if(age == 0 || age < 0){
                    Toast.makeText(getApplicationContext(), "Incorrect Age!", Toast.LENGTH_SHORT).show();
                }
                else if(weight == 0 || weight < 0){
                    Toast.makeText(getApplicationContext(), "Incorrect Weight!", Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent intent = new Intent(MainActivity.this, bmi_activity.class);
                    intent.putExtra("gender", typeofUser);
                    intent.putExtra("height", intprogress);
                    intent.putExtra("weight", weight2);
                    intent.putExtra("age", age2);

                    startActivity(intent);
                }

            }
        });
    }
}