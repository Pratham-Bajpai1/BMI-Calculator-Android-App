package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class bmi_activity extends AppCompatActivity {

    android.widget.Button reCalculatebmi;
    TextView bmiDisplay, bmiGender, bmiCategory;
    Intent intent;
    //ImageView imageView;
    String bmi;
    float intbmi;
    LottieAnimationView animChange;

    String height;
    String weight;
    float intHeight, intWeight;
    RelativeLayout chbackground;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);


        intent = getIntent();
        bmiDisplay = findViewById(R.id.bmiDisplay);
        bmiGender = findViewById(R.id.genderDisplay);
        bmiCategory = findViewById(R.id.bmiCategory);
        chbackground = findViewById(R.id.contentLayout);
        //imageView = findViewById(R.id.imageView);
        animChange = findViewById(R.id.animChange);
        reCalculatebmi = findViewById(R.id.recalculatebmi);

        height = intent.getStringExtra("height");
        weight = intent.getStringExtra("weight");

        intHeight = Float.parseFloat(height);
        intWeight = Float.parseFloat(weight);

        intHeight = intHeight / 100;
        intbmi = intWeight/(intHeight * intHeight);
        bmi = Float.toString(intbmi);

        if(intbmi < 16){
            bmiCategory.setText("Severe Thinness");
            chbackground.setBackgroundColor(getResources().getColor(R.color.light_red));
            //imageView.setImageResource(R.drawable.ic_launcher_background);
            animChange.setAnimation(R.raw.severeanim);
            animChange.playAnimation();
        }
        else if(intbmi < 16.9 && intbmi > 16){
            bmiCategory.setText("Moderate Thinness");
            chbackground.setBackgroundColor(getResources().getColor(R.color.light_yellow));
            //imageView.setImageResource(R.drawable.ic_launcher_background);
            animChange.setAnimation(R.raw.severeanim);
            animChange.playAnimation();
        }
        else if(intbmi < 18.4 && intbmi > 17){
            bmiCategory.setText("Mild Thinness");
            chbackground.setBackgroundColor(getResources().getColor(R.color.moderate_yellow));
            //imageView.setImageResource(R.drawable.ic_launcher_background);
            animChange.setAnimation(R.raw.mildanim);
            animChange.playAnimation();
        }
        else if(intbmi < 25 && intbmi > 18.4){
            bmiCategory.setText("Normal");
            chbackground.setBackgroundColor(getResources().getColor(R.color.green));
            //imageView.setImageResource(R.drawable.ic_launcher_background);
            animChange.setAnimation(R.raw.normalanim);
            animChange.playAnimation();
        }
        else if(intbmi < 29.4 && intbmi > 25){
            bmiCategory.setText("OverWeight");
            chbackground.setBackgroundColor(getResources().getColor(R.color.dark_red));
            //imageView.setImageResource(R.drawable.ic_launcher_background);
            animChange.setAnimation(R.raw.warninganim);
            animChange.playAnimation();
        }
        else{
            bmiCategory.setText("Obese Class I");
            chbackground.setBackgroundColor(getResources().getColor(R.color.light_red));
            //imageView.setImageResource(R.drawable.ic_launcher_background);
            animChange.setAnimation(R.raw.warninganim);
            animChange.playAnimation();
        }

        bmiGender.setText(intent.getStringExtra("gender"));
        bmiDisplay.setText(bmi);



        reCalculatebmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(bmi_activity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}