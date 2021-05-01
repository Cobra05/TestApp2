package com.example.testapp2.fragments;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.content.SharedPreferences;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextClock;
import android.widget.TextView;
import android.view.View;

import com.example.testapp2.R;
import com.example.testapp2.list_item.Notes;
import com.mikhaellopez.circularprogressbar.CircularProgressBar;
import java.util.Calendar;
import java.util.Objects;
import java.util.Random;
import java.util.zip.Inflater;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import org.w3c.dom.Text;


public class FragmentCounter extends Fragment {

    SharedPreferences sPref;
    CircularProgressBar targetDays;
    CircularProgressBar maximumDays;
    TextView days;
    TextClock clock;
    Calendar currentDate = Calendar.getInstance();
    float daysCount;
    private int tDaysCount;
    final String MAX_DATE = "record";
    final String START_DATE = "Start date";
    final Random random = new Random();



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
        updateDays();
        updateTarget();
        updateCitate();
        updateTargetPB();
        updateRecordPB();





    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_counter, container, false);
        clock = view.findViewById(R.id.textClock);

        TextView citlab = view.findViewById(R.id.citateslab);
        citlab.setOnClickListener(this::updateCitate);

        TextView record = view.findViewById(R.id.recDays);
        record.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.Dialog);
            builder.setTitle("Установите рекорд");
            View vi = inflater.inflate(R.layout.record_dialog_view, container, false);
            builder.setView(vi);
            EditText edt = vi.findViewById(R.id.rec_edit_dialog);
            builder.setPositiveButton("Добавить", (dialog, which) ->{
                SharedPreferences.Editor edt1 = sPref.edit();
                String edta = String.valueOf(edt.getText());
                if (Objects.equals(edta, ""))
                    edta = "30";
                int rec = Integer.parseInt(edta);
                edt1.putInt(MAX_DATE, rec);
                edt1.apply();
                record.setText(String.format("Рекорд: %d дней", rec));
                updateRecordPB();

            })
                    .setNegativeButton("Отмена", null);
            builder.create().show();
        });


        return view;
    }

    public void currentDate(){
        long starttimeinmills = Calendar.getInstance().getTimeInMillis();
        sPref = getActivity().getSharedPreferences("Global", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sPref.edit();
        editor.putLong(START_DATE, starttimeinmills);
        editor.apply();
        editor.commit();
    }
    public void setStartDate(){
        Calendar dateAndTime = Calendar.getInstance();

        DatePickerDialog.OnDateSetListener d = (view, year, monthOfYear, dayOfMonth) -> {
            dateAndTime.set(Calendar.YEAR, year);
            dateAndTime.set(Calendar.MONTH, monthOfYear);
            dateAndTime.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            long dateAndTimeinLong = dateAndTime.getTimeInMillis();

            sPref = getActivity().getSharedPreferences("Global", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sPref.edit();
            editor.putLong(START_DATE, dateAndTimeinLong);
            editor.apply();
        };


        new DatePickerDialog(getActivity(), R.style.Dialog, d,
                dateAndTime.get(Calendar.YEAR),
                dateAndTime.get(Calendar.MONTH),
                dateAndTime.get(Calendar.DAY_OF_MONTH))
                .show();
    }

    void createDialog(){
            AlertDialog alrt = new AlertDialog.Builder(getActivity(), R.style.Dialog)
                    .setTitle("Установка даты начала")
                    .setMessage("Установите дату начала воздержания.")
                    .setPositiveButton("Установить", (dialog, which) -> setStartDate())
                    .setNeutralButton("Установить сегодняшний день", (dialog, which) -> currentDate())
                    .setCancelable(false)
                    .create();
            alrt.show();




    }

    public void updateDays(){
        sPref = getActivity().getSharedPreferences("Global",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sPref.edit();
        long starttimeinmills = sPref.getLong(START_DATE, 0);

        if(starttimeinmills == 0){
            daysCount = 0.1f;
            editor.putLong(START_DATE, 1);
            createDialog();


        }else{
            long diff = currentDate.getTimeInMillis() - starttimeinmills;
            daysCount = (float) diff / (24 * 60 * 60 * 1000);
        }

        days = getActivity().findViewById(R.id.dayscounter);
        days.setText("Дней: " + (int) daysCount);
    }
    public void updateTarget(){
        TextView target = getActivity().findViewById(R.id.targetlab);
        tDaysCount = (int) daysCount;
        if(tDaysCount <= 7){
            target.setText("Цель: 7 дней");
        }else if(tDaysCount <= 14){
            target.setText("Цель: 14 дней");
        }else if(tDaysCount <= 30){
            target.setText("Цель: 30 дней");
        }else if(tDaysCount <= 90){
            target.setText("Цель: 90 дней");
        }else if(tDaysCount <= 180){
            target.setText("Цель: 180 дней");
        }else if(tDaysCount <= 365){
            target.setText("Цель: 365 дней");
        }else if(tDaysCount > 365){
            target.setText("Вы Победитель!");
        }

    }
    public void updateCitate(){
        TextView citate = getActivity().findViewById(R.id.citateslab);
        int randcit = random.nextInt(11) +1;
        switch (randcit){
            case 1:citate.setText(R.string.cit1);break;
            case 2:citate.setText(R.string.cit2);break;
            case 3:citate.setText(R.string.cit3);break;
            case 4:citate.setText(R.string.cit4);break;
            case 5:citate.setText(R.string.cit5);break;
            case 6:citate.setText(R.string.cit6);break;
            case 7:citate.setText(R.string.cit7);break;
            case 8:citate.setText(R.string.cit8);break;
            case 9:citate.setText(R.string.cit9);break;
            case 10:citate.setText(R.string.cit10);break;
            default:citate.setText(R.string.cit3);
        }
    }
    public void updateCitate(View v){
        TextView citate = getActivity().findViewById(R.id.citateslab);
        int randcit = random.nextInt(11) +1;
        switch (randcit){
            case 1:citate.setText(R.string.cit1);break;
            case 2:citate.setText(R.string.cit2);break;
            case 3:citate.setText(R.string.cit3);break;
            case 4:citate.setText(R.string.cit4);break;
            case 5:citate.setText(R.string.cit5);break;
            case 6:citate.setText(R.string.cit6);break;
            case 7:citate.setText(R.string.cit7);break;
            case 8:citate.setText(R.string.cit8);break;
            case 9:citate.setText(R.string.cit9);break;
            case 10:citate.setText(R.string.cit10);break;
            default:citate.setText(R.string.cit3);
        }
    }
    public void updateTargetPB(){
        targetDays = getActivity().findViewById(R.id.circularProgressBar);

        if(tDaysCount <= 7){
            targetDays.setProgressMax(7f);
        }else if(tDaysCount <= 14){
            targetDays.setProgressMax(14f);
        }else if(tDaysCount <= 30){
            targetDays.setProgressMax(30f);
        }else if(tDaysCount <= 90){
            targetDays.setProgressMax(90f);
        }else if(tDaysCount <= 180){
            targetDays.setProgressMax(180f);
        }else if(tDaysCount <= 365){
            targetDays.setProgressMax(365f);
        }else if(tDaysCount > 365){
            targetDays.setProgressMax(1000f);
        }
        targetDays.setProgress((int) daysCount);



    }
    public void updateRecordPB(){
        maximumDays = getActivity().findViewById(R.id.circularProgressBar2);
        sPref = getActivity().getPreferences(Context.MODE_PRIVATE);
        int savedRecdate = sPref.getInt(MAX_DATE, -1);
        maximumDays.setProgressMax(savedRecdate);
        maximumDays.setProgress(daysCount);
        TextView record = getActivity().findViewById(R.id.recDays);
        if (savedRecdate != -1){
            record.setText(String.format("Рекорд: %d дней", savedRecdate));
        }

    }



}

