package com.example.testapp2.fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.testapp2.R;
import com.example.testapp2.settings.CalendarSettings;
import com.example.testapp2.settings.CounterSettings;
import com.example.testapp2.settings.DiarySettings;
import com.example.testapp2.settings.SecirutySettings;
import com.example.testapp2.settings.ThemesSettings;


public class FragmentSettings extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings, container, false);

        Toolbar themeLabel = view.findViewById(R.id.toolbar1);
        Toolbar counterLabel = view.findViewById(R.id.toolbar2);
        Toolbar calendarLabel = view.findViewById(R.id.toolbar3);
        Toolbar diaryLabel = view.findViewById(R.id.toolbar4);
        Toolbar securityLabel = view.findViewById(R.id.toolbar5);

        themeLabel.setOnClickListener(v -> {
            themes();
        });
        counterLabel.setOnClickListener(v -> {
            counter();
        });
        calendarLabel.setOnClickListener((v -> {
            calendar();
        }));
        diaryLabel.setOnClickListener((v -> {
            diary();
        }));
        securityLabel.setOnClickListener((v -> {
            security();
        }));

        return view;
    }

    public void themes(){
        Intent intent = new Intent(getActivity(), ThemesSettings.class);
        startActivity(intent);
        getActivity().finish();
    }
    public void counter(){
        Intent intent = new Intent(getActivity(), CounterSettings.class);
        startActivity(intent);
    }
    public void calendar(){
        Intent intent = new Intent(getActivity(), CalendarSettings.class);
        startActivity(intent);
    }

    public void diary(){
        Intent intent = new Intent(getActivity(), DiarySettings.class);
        startActivity(intent);
    }
    public void security(){
        Intent intent = new Intent(getActivity(), SecirutySettings.class);
        startActivity(intent);
    }
}