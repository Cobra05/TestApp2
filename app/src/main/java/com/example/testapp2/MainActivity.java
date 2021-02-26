package com.example.testapp2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import android.view.View;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView.OnNavigationItemSelectedListener mlistener = item -> {
        Fragment selectedFragment = null;
        switch (item.getItemId()){
            case R.id.main:
                selectedFragment = new FragmentCounter();
                break;
            case R.id.inform:
                selectedFragment = new InformationFragment();
                break;
            case R.id.calendar:
                selectedFragment = new CalendarFragment();
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
        setContentView(R.layout.activity_main);

       if(savedInstanceState == null)
           getSupportFragmentManager().beginTransaction().replace(R.id.fragment, new FragmentCounter()).commit();

       BottomNavigationView navigation = findViewById(R.id.navbar);
       navigation.setOnNavigationItemSelectedListener(mlistener);
    }
}