package com.example.protivo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        makeFullScreen();
        setContentView(R.layout.splash_layout);
        SharedPreferences sprf = getSharedPreferences("Global", MODE_PRIVATE);
        String pin_state = sprf.getString("Pin", "DEFAULT");

        Intent inte = new Intent(this, PinActivity.class);
        new Handler().postDelayed(() -> {

            switch (pin_state){
                case "DEFAULT":
                    sprf.edit().putString("Pin", "OFF");
                    startActivity(new Intent(this, MainActivity.class));
                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                    finish();
                    break;
                case "ON":
                    startActivity(inte);
                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                    finish();
                    break;
                case "OFF":
                    startActivity(new Intent(this, MainActivity.class));
                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                    finish();
                    break;
            }
        },2000);



    }

    private void makeFullScreen() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
        );
    }
}