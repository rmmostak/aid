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

import java.util.Locale;

public class DOPage extends AppCompatActivity {

    private CardView doLow, doOptimum;

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

        setContentView(R.layout.activity_dopage);
        getSupportActionBar().setTitle(R.string.do_level);

        doLow = findViewById(R.id.doLow);
        doOptimum = findViewById(R.id.doOptimum);

        doLow.setOnClickListener(view -> {
            Intent intent = new Intent(DOPage.this, FishPage.class);
            ActivityOptions options = ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.fade_in, R.anim.fade_out);
            startActivity(intent, options.toBundle());
        });

        doOptimum.setOnClickListener(view -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(R.string.result);
            builder.setIcon(R.mipmap.ic_launcher_round);
            builder.setMessage(R.string.optimum_msg);
            builder.setCancelable(false);
            builder.setPositiveButton(R.string.thank_you, (dialog1, which) -> {
                return;
            });
            builder.show();
        });
    }
}