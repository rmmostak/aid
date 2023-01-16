package com.rmproduct.intelligentfishdb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;

public class FishPage extends AppCompatActivity {

    private CardView carp, tilapia, cat, mixed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fish_page);

        carp = findViewById(R.id.carpFish);
        tilapia = findViewById(R.id.tilapia);
        cat = findViewById(R.id.catFish);
        mixed = findViewById(R.id.fishMix);

        carp.setOnClickListener(view -> {
            Intent intent = new Intent(FishPage.this, Symptoms.class);
            ActivityOptions options = ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.fade_in, R.anim.fade_out);
            startActivity(intent, options.toBundle());
        });
        tilapia.setOnClickListener(view -> {
            Intent intent = new Intent(FishPage.this, Symptoms.class);
            ActivityOptions options = ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.fade_in, R.anim.fade_out);
            startActivity(intent, options.toBundle());
        });
        cat.setOnClickListener(view -> {
            Intent intent = new Intent(FishPage.this, Symptoms.class);
            ActivityOptions options = ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.fade_in, R.anim.fade_out);
            startActivity(intent, options.toBundle());
        });
        mixed.setOnClickListener(view -> {
            Intent intent = new Intent(FishPage.this, Symptoms.class);
            ActivityOptions options = ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.fade_in, R.anim.fade_out);
            startActivity(intent, options.toBundle());
        });
    }
}