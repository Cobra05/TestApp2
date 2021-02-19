package com.example.testapp2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView.OnNavigationItemSelectedListener mlistener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;
            switch (item.getItemId()){
                case R.id.main:
                    selectedFragment = new FragmentCounter();
                    break;
                case R.id.inform:
                    selectedFragment = new InformationFragment();
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
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       if(savedInstanceState == null)
           getSupportFragmentManager().beginTransaction().replace(R.id.fragment, new FragmentCounter()).commit();

       BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navbar);
       navigation.setOnNavigationItemSelectedListener(mlistener);
    }
}