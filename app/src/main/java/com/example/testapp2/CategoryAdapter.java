package com.example.testapp2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    private final LayoutInflater inflater;
    private final List<Category> categories;

    CategoryAdapter(Context context, List<Category> categories){
        this.categories = categories;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public CategoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CategoryAdapter.ViewHolder holder, int position) {
        Category category = categories.get(position);
        holder.iconView.setImageResource(category.getIcon());
        holder.textView.setText(category.getText());
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        final TextView textView;
        final ImageView iconView;

        ViewHolder(View view){
            super(view);
            textView = (TextView)view.findViewById(R.id.item_text);
            iconView = (ImageView)view.findViewById(R.id.item_icon);

        }

    }
}
