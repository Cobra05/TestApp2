package com.example.testapp2.settings;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.example.testapp2.R;

public class CalendarSettings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences sPref = getSharedPreferences("Global" ,MODE_PRIVATE);
        int theme = sPref.getInt("theme", 0);
        if (theme == 0)
            setTheme(R.style.LightTheme);
        else if(theme == 1)
            setTheme(R.style.NightTheme);
        setContentView(R.layout.calendar_settings_layout);

        Button btn1 = findViewById(R.id.btn1);
        btn1.setOnClickListener((v -> {

            AlertDialog alrt = new AlertDialog
                    .Builder(this, R.style.Dialog)
                    .setTitle("Уведомление")
                    .setMessage("Сбросить календарь?")
                    .setPositiveButton("Да", (dialog, which) -> {
                        clearCalendarDataBase();
                    })
                    .setNegativeButton("Нет", null)
                    .create();
            alrt.show();

        }));
    }

    public void clearCalendarDataBase(){

        SQLiteDatabase db = openOrCreateDatabase("main.db", Context.MODE_PRIVATE, null);

        db.execSQL("DROP TABLE highlited");

        Toast.makeText(this, "Сброшено", Toast.LENGTH_SHORT).show();

    }


}