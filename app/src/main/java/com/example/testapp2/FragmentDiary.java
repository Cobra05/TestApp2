package com.example.testapp2;

import android.app.AlertDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Calendar;


public class FragmentDiary extends Fragment {

    ArrayList<Notes> notes = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_diary, container, false);


        RecyclerView rv = v.findViewById(R.id.notes_recycler);
        NotesAdapter nadapter = new NotesAdapter(getActivity(), notes);
        rv.setAdapter(nadapter);
        FloatingActionButton fab = v.findViewById(R.id.floatingactionbutton);
        fab.setOnClickListener(this::addNewNote);

        return v;
    }

    public void addNewNote(View view){

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Новая Заметка");

        final EditText edt = new EditText(getActivity());
        builder.setView(edt);

        builder.setPositiveButton("Добавить", (dialog, which) ->{
            String note = String.valueOf(edt.getText());
            Calendar cal = Calendar.getInstance();
            notes.add(new Notes(String.valueOf(cal.getTime()), note));
        })
                .setNegativeButton("Отмена", null);
        builder.create().show();
    }
}