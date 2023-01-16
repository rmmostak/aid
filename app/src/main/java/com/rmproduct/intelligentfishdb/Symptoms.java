package com.rmproduct.intelligentfishdb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;

public class Symptoms extends AppCompatActivity {

    private CardView catA, catB, catC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_symptoms);

        catA =findViewById(R.id.catA);
        catB =findViewById(R.id.catB);
        catC =findViewById(R.id.catC);

        catA.setOnClickListener(view -> {
            Intent intent = new Intent(Symptoms.this, CategoryA.class);
            ActivityOptions options = ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.fade_in, R.anim.fade_out);
            startActivity(intent, options.toBundle());
        });
        catB.setOnClickListener(view -> {
            Intent intent = new Intent(Symptoms.this, CategoryB.class);
            ActivityOptions options = ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.fade_in, R.anim.fade_out);
            startActivity(intent, options.toBundle());
        });
        catC.setOnClickListener(view -> {
            Intent intent = new Intent(Symptoms.this, CategoryC.class);
            ActivityOptions options = ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.fade_in, R.anim.fade_out);
            startActivity(intent, options.toBundle());
        });
    }
}