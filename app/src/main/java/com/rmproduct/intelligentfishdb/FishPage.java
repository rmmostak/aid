package com.rmproduct.intelligentfishdb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.ActivityOptions;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;

import java.util.Locale;

public class FishPage extends AppCompatActivity {

    private CardView carp, tilapia, cat, mixed;

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

        setContentView(R.layout.activity_fish_page);

        getSupportActionBar().setTitle(R.string.fish_type);

        carp = findViewById(R.id.carpFish);
        tilapia = findViewById(R.id.tilapia);
        cat = findViewById(R.id.catFish);
        mixed = findViewById(R.id.fishMix);

        carp.setOnClickListener(view -> {
            Intent intent = new Intent(FishPage.this, CategorySymp.class);
            ActivityOptions options = ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.fade_in, R.anim.fade_out);
            startActivity(intent, options.toBundle());
        });
        tilapia.setOnClickListener(view -> {
            Intent intent = new Intent(FishPage.this, CategorySymp.class);
            ActivityOptions options = ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.fade_in, R.anim.fade_out);
            startActivity(intent, options.toBundle());
        });
        cat.setOnClickListener(view -> {
            Intent intent = new Intent(FishPage.this, CategorySymp.class);
            ActivityOptions options = ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.fade_in, R.anim.fade_out);
            startActivity(intent, options.toBundle());
        });
        mixed.setOnClickListener(view -> {
            Intent intent = new Intent(FishPage.this, CategorySymp.class);
            ActivityOptions options = ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.fade_in, R.anim.fade_out);
            startActivity(intent, options.toBundle());
        });
    }
}