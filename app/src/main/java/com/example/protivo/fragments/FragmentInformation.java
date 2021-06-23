package com.example.protivo.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.protivo.InformActivity;
import com.example.protivo.MethodsActivity;
import com.example.protivo.R;
import com.example.protivo.WebView;
import com.example.protivo.adapters.CategoryAdapter;
import com.example.protivo.list_item.Category;

import java.util.ArrayList;

public class FragmentInformation extends Fragment {

    ArrayList<Category> categories = new ArrayList<Category>();
    public void setInitialData(){
        categories.add(new Category(R.drawable.ic_plus, "Польза Воздержания"));
        categories.add(new Category(R.drawable.ic_minus, "Вред Онанизма"));
        categories.add(new Category(R.drawable.ic_sword, "Методы по борьбе с Онанизмом"));
        categories.add(new Category(R.drawable.ic_hint, "Советы по саморазвитию"));
        categories.add(new Category(R.drawable.ic_diary, "Дневники участников АнтиО"));
        categories.add(new Category(R.drawable.ic_winners_cup, "Дневники Победителей АнтиО"));
    }

    RecyclerView mRecyclerView;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_informaton, container, false);
        setInitialData();

        mRecyclerView = (RecyclerView)view.findViewById(R.id.recycler);
        GridLayoutManager grd = new GridLayoutManager(view.getContext(), 2, LinearLayoutManager.VERTICAL, false);
        CategoryAdapter.OnStateClickListener stateClickListener = (category, position) -> {
            Intent webintent = new Intent(getActivity(), WebView.class);
            Intent methods = new Intent(getActivity(), MethodsActivity.class);
            Intent inform = new Intent(getActivity(), InformActivity.class);

            switch (position){
                case 0:
                    inform.putExtra("category", "polza");
                    startActivity(inform);
                    break;
                case 1:
                    inform.putExtra("category", "vred");
                    startActivity(inform);
                    break;
                case 2:
                    startActivity(methods);
                    break;
                case 3:
                    inform.putExtra("category", "sovet");
                    startActivity(inform);
                    break;
                case 4:
                    webintent.putExtra("position", 4);
                    startActivity(webintent);
                    break;
                case 5:
                    webintent.putExtra("position", 5);
                    startActivity(webintent);
                    break;





            }

        };

        CategoryAdapter mCategoryAdapter = new CategoryAdapter(view.getContext(), categories, stateClickListener);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(grd);
        mRecyclerView.setAdapter(mCategoryAdapter);





        return view;
    }

}