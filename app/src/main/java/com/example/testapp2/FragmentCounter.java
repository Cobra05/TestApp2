package com.example.testapp2;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.content.SharedPreferences;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextClock;
import android.widget.TextView;
import android.view.View;
import com.mikhaellopez.circularprogressbar.CircularProgressBar;
import java.util.Calendar;
import java.util.Random;
import android.view.LayoutInflater;
import android.view.ViewGroup;


public class FragmentCounter extends Fragment {

    SharedPreferences sPref;
    CircularProgressBar targetDays;
    CircularProgressBar maximumDays;
    TextView days;
    TextClock clock;
    Calendar currentDate = Calendar.getInstance();
    float daysCount;
    float recdays;
    private int tDaysCount;
    final String START_DATE = "Start date";
    final String MAX_DATE = "Maximum date";
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
        createDialog(1);



    }

    public void currentDate(){
        long starttimeinmills = Calendar.getInstance().getTimeInMillis();
        sPref = getActivity().getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sPref.edit();
        editor.putLong(START_DATE, starttimeinmills);
        editor.apply();
        editor.commit();
        updateDays();
    }

    public void setStartDate(){
        Calendar dateAndTime = Calendar.getInstance();

        DatePickerDialog.OnDateSetListener d = (view, year, monthOfYear, dayOfMonth) -> {
            dateAndTime.set(Calendar.YEAR, year);
            dateAndTime.set(Calendar.MONTH, monthOfYear);
            dateAndTime.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            long dateAndTimeinLong = dateAndTime.getTimeInMillis();

            sPref = getActivity().getPreferences(Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sPref.edit();
            editor.putLong(START_DATE, dateAndTimeinLong);
            editor.apply();
            editor.commit();
            updateDays();
        };


        new DatePickerDialog(getActivity(), d,
                dateAndTime.get(Calendar.YEAR),
                dateAndTime.get(Calendar.MONTH),
                dateAndTime.get(Calendar.DAY_OF_MONTH))
                .show();


    }

    void createDialog(int id){
        if(id == 1){
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder
                    .setTitle("Установка даты начала")
                    .setMessage("Установите дату начала воздержания.")
                    .setPositiveButton("Установить", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            setStartDate();
                        }
                    })
                    .setNeutralButton("Установить сегодняшний день", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            currentDate();
                        }
                    })
                    .setCancelable(false)
                    .create();

        }else{
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder
                    .setTitle("Установка даты начала")
                    .setMessage("Установите дату начала воздержания.")
                    .setPositiveButton("Установить", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            setStartDate();
                        }
                    })
                    .setNeutralButton("Установить сегодняшний день", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            currentDate();
                        }
                    })
                    .setCancelable(false)
                    .create().show();

        }


    }

    public void updateDays(){
        sPref = getActivity().getPreferences(Context.MODE_PRIVATE);
        long starttimeinmills = sPref.getLong(START_DATE, (long) 0.1);

        if(starttimeinmills == 0.0){
            daysCount = 0.1f;
            createDialog(3);


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
        float savedRecdate = sPref.getFloat(MAX_DATE, 30f);
        EditText recCount = getActivity().findViewById(R.id.editTextNumber);
        String sv = String.valueOf((int) savedRecdate);
        recCount.setText(sv);
        maximumDays.setProgressMax(savedRecdate);
        maximumDays.setProgress(daysCount);















}




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_counter, container, false);

        EditText recCount = view.findViewById(R.id.editTextNumber);
        clock = view.findViewById(R.id.textClock);
        recCount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                maximumDays = view.findViewById(R.id.circularProgressBar2);

                try {
                    recdays = Float.parseFloat(recCount.getText().toString());
                    maximumDays.setProgressMax(recdays);
                    maximumDays.setProgress(daysCount);


                }catch (NumberFormatException e){
                    maximumDays.setProgressMax(30);
                    maximumDays.setProgress(daysCount);
                }
                sPref = getActivity().getPreferences(Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sPref.edit();
                editor.putFloat(MAX_DATE, recdays);
                editor.apply();
                editor.commit();



            }
            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        TextView citlab = view.findViewById(R.id.citateslab);
        citlab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateCitate(v);
            }
        });




        return view;
    }


}

