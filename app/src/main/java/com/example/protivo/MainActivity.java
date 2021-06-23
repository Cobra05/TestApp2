package com.example.protivo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.SharedPreferences;
import android.os.Bundle;

import com.example.protivo.fragments.FragmentCalendar;
import com.example.protivo.fragments.FragmentCounter;
import com.example.protivo.fragments.FragmentDiary;
import com.example.protivo.fragments.FragmentSettings;
import com.example.protivo.fragments.FragmentInformation;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {



    private BottomNavigationView.OnNavigationItemSelectedListener mlistener = item -> {
        Fragment selectedFragment = null;
        switch (item.getItemId()){
            case R.id.main:
                selectedFragment = new FragmentCounter();
                break;
            case R.id.inform:
                selectedFragment = new FragmentInformation();
                break;
            case R.id.calendar:
                selectedFragment = new FragmentCalendar();
                break;
            case R.id.settings:
                selectedFragment = new FragmentSettings();
                break;
            case R.id.diary:
                selectedFragment = new FragmentDiary();
                break;
        }
        FragmentTransaction transaction = getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment, selectedFragment);
        transaction.commit();
        return true;
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences sPref = getSharedPreferences("Global", MODE_PRIVATE);
        int theme = sPref.getInt("theme", 0);
        if (theme == 0)
            setTheme(R.style.LightTheme);
        else if(theme == 1)
            setTheme(R.style.NightTheme);

        setContentView(R.layout.activity_main);

        if(savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment, new FragmentCounter()).commit();
        }

        BottomNavigationView navigation = findViewById(R.id.navbar);
        navigation.setOnNavigationItemSelectedListener(mlistener);
    }
}