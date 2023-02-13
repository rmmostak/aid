package com.rmproduct.intelligentfishdb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.ActivityOptions;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.ImageView;

import java.util.Locale;

public class CategorySymp extends AppCompatActivity {

    private CardView symptom, manual, medicine, ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences sharedPreferences = getSharedPreferences("appLanguage", MODE_PRIVATE);
        String appLang = sharedPreferences.getString("lang", Locale.getDefault().getLanguage());

        Locale myLocale = new Locale(appLang);
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        Locale.setDefault(myLocale);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            conf.setLayoutDirection(myLocale);
        }
        res.updateConfiguration(conf, dm);

        setContentView(R.layout.activity_symptoms);

        getSupportActionBar().setTitle(R.string.categories);

        symptom =findViewById(R.id.symptom);
        manual =findViewById(R.id.manual);
        medicine =findViewById(R.id.medicine);
        ref =findViewById(R.id.ref);

        symptom.setOnClickListener(view -> {
            Intent intent = new Intent(CategorySymp.this, Symptoms.class);
            ActivityOptions options = ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.fade_in, R.anim.fade_out);
            startActivity(intent, options.toBundle());
        });
        manual.setOnClickListener(view -> {
            Intent intent = new Intent(CategorySymp.this, Manual.class);
            ActivityOptions options = ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.fade_in, R.anim.fade_out);
            startActivity(intent, options.toBundle());
        });
        medicine.setOnClickListener(view -> {
            Intent intent = new Intent(CategorySymp.this, Medicine.class);
            ActivityOptions options = ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.fade_in, R.anim.fade_out);
            startActivity(intent, options.toBundle());
        });
        ref.setOnClickListener(view -> {
            ImageView image = new ImageView(this);
            image.setImageResource(R.drawable.fish_ref);

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setCancelable(false);
            builder.setPositiveButton(R.string.close, (dialog1, which) -> {
                return;
            }).setView(image);
            builder.show();
        });
    }
}