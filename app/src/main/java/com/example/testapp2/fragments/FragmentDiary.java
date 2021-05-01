package com.example.testapp2.fragments;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import android.widget.EditText;
import android.widget.Toast;

import com.example.testapp2.R;
import com.example.testapp2.adapters.NotesAdapter;
import com.example.testapp2.list_item.Notes;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Objects;


public class FragmentDiary extends Fragment {

    ArrayList<Notes> notes = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_diary, container, false);
        SQLiteDatabase db = getActivity().openOrCreateDatabase("main.db", Context.MODE_PRIVATE, null);

        db.execSQL("CREATE TABLE IF NOT EXISTS notes(date TEXT, note TEXT)");
        loadnotes(db, v);
        RecyclerView rv = v.findViewById(R.id.notes_recycler);
        NotesAdapter nadapter = new NotesAdapter(getActivity(), notes);
        rv.setAdapter(nadapter);
        FloatingActionButton fab = v.findViewById(R.id.floatingactionbutton);
        fab.setOnClickListener(this::addNewNote);

        return v;
    }

    public void addNewNote(View view){
        SQLiteDatabase db = getActivity().openOrCreateDatabase("main.db", Context.MODE_PRIVATE, null);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.Dialog);
        builder.setTitle("Новая Заметка");

        final EditText edt = new EditText(getActivity());
        builder.setView(edt);

        builder.setPositiveButton("Добавить", (dialog, which) ->{
            String note = String.valueOf(edt.getText());
            if (Objects.equals(note, ""))
                Toast.makeText(getActivity(), "Вы ничего не ввели!", Toast.LENGTH_SHORT).show();
            else {
                Calendar cal = Calendar.getInstance();
                notes.add(new Notes(String.valueOf(cal.getTime()), note));
                ContentValues cv = new ContentValues();
                cv.put("date", String.valueOf(cal.getTime()));
                cv.put("note", note);
                db.insert("notes", null, cv); }
        })
                .setNegativeButton("Отмена", null);
        builder.create().show();
    }

    public void loadnotes(SQLiteDatabase db, View v){
        Cursor user = db.rawQuery("SELECT * FROM notes", null);
        while (user.moveToNext()){
            String date =  user.getString(0);
            String note = user.getString(1);
            notes.add(new Notes(date, note));

        }
        RecyclerView recyclerView = v.findViewById(R.id.notes_recycler);
        recyclerView.scrollToPosition(notes.size() - 1);
    };
}