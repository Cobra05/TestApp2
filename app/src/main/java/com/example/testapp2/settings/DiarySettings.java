package com.example.testapp2.settings;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.example.testapp2.R;

public class DiarySettings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diary_settings_layout);



        Button btn = findViewById(R.id.btn1);
         btn.setOnClickListener((v -> {
             clearDiary();
         }));
    }

    public void clearDiary(){

        SQLiteDatabase db = openOrCreateDatabase("main.db", Context.MODE_PRIVATE, null);

        db.execSQL("DROP TABLE notes");

        Toast.makeText(this, "Очищено", Toast.LENGTH_SHORT).show();

    }
}