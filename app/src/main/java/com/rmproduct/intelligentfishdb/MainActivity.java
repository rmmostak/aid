package com.rmproduct.intelligentfishdb;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Handler;

import androidx.appcompat.app.AppCompatDelegate;

import com.rmproduct.intelligentfishdb.databinding.ActivityMainBinding;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView welcome, copy;
    private LinearLayout event_image, just_logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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