package com.rmproduct.intelligentfishdb;

import android.app.ActivityOptions;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Handler;

import androidx.appcompat.app.AppCompatDelegate;

import com.rmproduct.intelligentfishdb.databinding.ActivityMainBinding;

import android.util.DisplayMetrics;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private TextView welcome, copy;
    private LinearLayout event_image, just_logo;

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

        setContentView(R.layout.activity_main);

        welcome = findViewById(R.id.welcome);
        copy = findViewById(R.id.copy);
        event_image = findViewById(R.id.event_image);
        just_logo = findViewById(R.id.just_logo);

        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);
        welcome.startAnimation(animation);

        Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);
        copy.startAnimation(animation1);

        Animation animation2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.left2right);
        event_image.startAnimation(animation2);

        Animation animation3 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.right2left);
        just_logo.startAnimation(animation3);

        Handler handler = new Handler();
        handler.postDelayed(r, 4000);
    }

    Runnable r = () -> {
        Intent intent = new Intent(MainActivity.this, HomePage.class);
        ActivityOptions options = ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.fade_in, R.anim.fade_out);
        startActivity(intent, options.toBundle());
        finish();
    };
}