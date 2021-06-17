package com.example.testapp2.settings;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;

import com.example.testapp2.R;

import org.jetbrains.annotations.NotNull;

import io.ghyeok.stickyswitch.widget.StickySwitch;

public class SecirutySettings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.seciruty_settings_layout);
        SharedPreferences sprf = getSharedPreferences("Global", MODE_PRIVATE);
        String directionn = sprf.getString("Pin", "DEFAULT");
        StickySwitch stck = findViewById(R.id.pin_switch);
        if(directionn.equals("DEFAULT") || directionn.equals("OFF")){
            stck.setDirection(StickySwitch.Direction.LEFT);
        }else {
            stck.setDirection(StickySwitch.Direction.RIGHT);
        }
        stck.setOnSelectedChangeListener((direction, s) -> {
            if (direction == StickySwitch.Direction.LEFT){
                sprf.edit().putString("Pin", "OFF").apply();
            }else if (direction == StickySwitch.Direction.RIGHT){
                sprf.edit().putString("Pin", "ON").apply();
                AlertDialog.Builder alrt = new AlertDialog.Builder(this, R.style.Dialog);
                alrt.setTitle("Установить PIN");

            }
        });

    }
}