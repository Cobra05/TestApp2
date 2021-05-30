package com.example.testapp2.settings;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import com.example.testapp2.MainActivity;
import com.example.testapp2.R;

import org.jetbrains.annotations.NotNull;

import io.ghyeok.stickyswitch.widget.StickySwitch;

public class ThemesSettings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences sPref = getSharedPreferences("Global" ,MODE_PRIVATE);
        int theme = sPref.getInt("theme", 0);
        if (theme == 0)
            setTheme(R.style.LightTheme);
        else if(theme == 1)
            setTheme(R.style.NightTheme);
        setContentView(R.layout.theme_select_layout);


        StickySwitch switcher = findViewById(R.id.sticky_switch);
        if (theme == 1)
            switcher.setDirection(StickySwitch.Direction.RIGHT);
        if(theme == 0){
            switcher.setDirection(StickySwitch.Direction.LEFT);
        }
        switcher.setOnSelectedChangeListener((direction, s) -> {
            if (direction == StickySwitch.Direction.LEFT){
                sPref.edit().putInt("theme", 0).apply();
                finish();
                startActivity(getIntent());
            }else if(direction == StickySwitch.Direction.RIGHT){
                sPref.edit().putInt("theme", 1).apply();
                finish();
                startActivity(getIntent());
            }

        });


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent inte = new Intent(this, MainActivity.class);
        startActivity(inte);
    }
}