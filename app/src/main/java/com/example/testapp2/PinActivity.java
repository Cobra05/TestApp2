package com.example.testapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import com.andrognito.pinlockview.IndicatorDots;
import com.andrognito.pinlockview.PinLockListener;
import com.andrognito.pinlockview.PinLockView;

public class PinActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences sPref = getSharedPreferences("Global", MODE_PRIVATE);
        int theme = sPref.getInt("theme", 0);
        if (theme == 0)
            setTheme(R.style.LightTheme);
        else if(theme == 1)
            setTheme(R.style.NightTheme);
        setContentView(R.layout.pin_layout);
        String pin_code = sPref.getString("Pin-code", "1111");

        PinLockView mPinLockView = (PinLockView) findViewById(R.id.pin_lock_view);
        PinLockListener mPinLockListener = new PinLockListener() {
            @Override
            public void onComplete(String pin) {
                if (pin.equals(pin_code)){
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    finish();
                    startActivity(intent);
                }else {
                    Toast.makeText(PinActivity.this, "Неверный PIN", Toast.LENGTH_SHORT).show();
                    mPinLockView.resetPinLockView();
                }}
            @Override
            public void onEmpty() {}
            @Override
            public void onPinChange(int pinLength, String intermediatePin) {}};

        IndicatorDots mIndicatorDots = findViewById(R.id.indicator_dots);

        mPinLockView.attachIndicatorDots(mIndicatorDots);
        mPinLockView.setPinLockListener(mPinLockListener);


    }

    @Override
    public void onBackPressed() {}
}