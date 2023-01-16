package com.rmproduct.intelligentfishdb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;

public class HomePage extends AppCompatActivity {

    private CardView fishCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        getSupportActionBar().setTitle(R.string.app_name);

        fishCard = findViewById(R.id.fishCat);
        fishCard.setOnClickListener(view -> {
            Intent intent = new Intent(HomePage.this, DOPage.class);
            ActivityOptions options = ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.fade_in, R.anim.fade_out);
            startActivity(intent, options.toBundle());
        });
    }

    Activity context = new HomePage();

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.lang, menu);
        MenuItem item = (MenuItem) menu.findItem(R.id.lang);
        item.setActionView(R.layout.show_protected_switch);
        Switch switchAB = item.getActionView().findViewById(R.id.switch_show);
        switchAB.setChecked(false);

        switchAB.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                context = (Activity) LocaleHelper.setLocale(HomePage.this, "en");
                Log.d("Language", "En");
            } else {
                context = (Activity) LocaleHelper.setLocale(HomePage.this, "bn");
                Log.d("Language", "Bn");
            }
        });
        return true;
    }
}