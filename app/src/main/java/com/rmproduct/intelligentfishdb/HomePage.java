package com.rmproduct.intelligentfishdb;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.Locale;

public class HomePage extends AppCompatActivity {

    private CardView fishCard, preCaution;

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

        setContentView(R.layout.activity_home_page);

        getSupportActionBar().setTitle(R.string.app_name);

        fishCard = findViewById(R.id.fishCat);
        fishCard.setOnClickListener(view -> {
            Intent intent = new Intent(HomePage.this, DOPage.class);
            ActivityOptions options = ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.fade_in, R.anim.fade_out);
            startActivity(intent, options.toBundle());
        });

        preCaution = findViewById(R.id.preCaution);
        preCaution.setOnClickListener(view -> {
            Intent intent = new Intent(HomePage.this, PreCaution.class);
            ActivityOptions options = ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.fade_in, R.anim.fade_out);
            startActivity(intent, options.toBundle());
        });
    }

    Context context; // = new HomePage();

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.lang, menu);
        MenuItem item = (MenuItem) menu.findItem(R.id.lang);

        item.setActionView(R.layout.show_protected_switch);
        Switch switchAB = item.getActionView().findViewById(R.id.switch_show);

        //switchAB.setChecked(false);

        SharedPreferences sharedPreferences = getSharedPreferences("appLanguage", MODE_PRIVATE);
        String lang = sharedPreferences.getString("lang", Locale.getDefault().getLanguage());
        if (lang.equals("bn")) {
            switchAB.setChecked(true);
        } else {
            switchAB.setChecked(false);
        }

        switchAB.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("lang", "bn");
                editor.apply();
                Intent intent = new Intent(HomePage.this, HomePage.class);
                ActivityOptions options = ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.fade_in, R.anim.fade_out);
                startActivity(intent, options.toBundle());
            } else {

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("lang", "en");
                editor.apply();
                Intent intent = new Intent(HomePage.this, HomePage.class);
                ActivityOptions options = ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.fade_in, R.anim.fade_out);
                startActivity(intent, options.toBundle());
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.feedback) {
            Intent intent = new Intent(HomePage.this, Feedback.class);
            ActivityOptions options = ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.fade_in, R.anim.fade_out);
            startActivity(intent, options.toBundle());
        }
        return super.onOptionsItemSelected(item);
    }
}