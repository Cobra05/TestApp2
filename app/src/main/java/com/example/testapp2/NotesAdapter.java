package com.example.testapp2;

import android.content.Context;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.widget.TextView;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.ViewHolder> {

    private final LayoutInflater inflater;
    private final List<Notes> notes;

    NotesAdapter(Context context, List<Notes> notes){
        this.notes = notes;
        this.inflater = LayoutInflater.from(context);
    }


    @NonNull
    @Override
    public NotesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.note_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NotesAdapter.ViewHolder holder, int position) {
        Notes note = notes.get(position);
        holder.note.setText(note.getNote());
        holder.date.setText(note.getDate());
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        final TextView date, note;
        ViewHolder(View view){
            super(view);
            date = view.findViewById(R.id.date_label);
            note = view.findViewById(R.id.notes_label);
        }
    }
}
