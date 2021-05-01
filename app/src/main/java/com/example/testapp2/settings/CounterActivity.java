package com.example.testapp2.settings;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.testapp2.R;

import java.util.Calendar;


public class CounterActivity extends AppCompatActivity {

    SharedPreferences sPref;
    final String START_DATE = "Start date";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_counter);

        Button btn1 = findViewById(R.id.btn1);
        Button btn2 = findViewById(R.id.btn2);
        btn1.setOnClickListener(v -> {
            setStartDate();
        });
        btn2.setOnClickListener(v -> {
            AlertDialog alrt = new AlertDialog.Builder(this)
                    .setTitle("Уведомление")
                    .setMessage("Сросить счётчик?")
                    .setPositiveButton("Да", (dialog, which) -> currentDate())
                    .setNegativeButton("Нет", null)
                    .create();
            alrt.show();
        });


    }

    public void setStartDate(){
        Calendar dateAndTime = Calendar.getInstance();

        DatePickerDialog.OnDateSetListener d = (view, year, monthOfYear, dayOfMonth) -> {
            dateAndTime.set(Calendar.YEAR, year);
            dateAndTime.set(Calendar.MONTH, monthOfYear);
            dateAndTime.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            long dateAndTimeinLong = dateAndTime.getTimeInMillis();

            sPref = getSharedPreferences("Global", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sPref.edit();
            editor.putLong(START_DATE, dateAndTimeinLong);
            editor.apply();
        };
        new DatePickerDialog(this, R.style.Dialog, d,
                dateAndTime.get(Calendar.YEAR),
                dateAndTime.get(Calendar.MONTH),
                dateAndTime.get(Calendar.DAY_OF_MONTH))
                .show();
}
    public void currentDate(){
        long starttimeinmills = Calendar.getInstance().getTimeInMillis();
        sPref = getSharedPreferences("Global", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sPref.edit();
        editor.putLong(START_DATE, starttimeinmills);
        editor.apply();
        editor.commit();
    }


}