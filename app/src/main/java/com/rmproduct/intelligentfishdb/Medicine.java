package com.rmproduct.intelligentfishdb;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class Medicine extends AppCompatActivity {

    private CardView doc, prob, lime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine);

        doc = findViewById(R.id.catA);
        prob = findViewById(R.id.catB);
        lime = findViewById(R.id.catC);

        doc.setOnClickListener(view -> {
            Intent intent = new Intent(Medicine.this, CategoryA.class);
            ActivityOptions options = ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.fade_in, R.anim.fade_out);
            startActivity(intent, options.toBundle());
        });
        prob.setOnClickListener(view -> {
            Intent intent = new Intent(Medicine.this, CategoryB.class);
            ActivityOptions options = ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.fade_in, R.anim.fade_out);
            startActivity(intent, options.toBundle());
        });
        lime.setOnClickListener(view -> {
            Intent intent = new Intent(Medicine.this, CategoryC.class);
            ActivityOptions options = ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.fade_in, R.anim.fade_out);
            startActivity(intent, options.toBundle());
        });
    }
}