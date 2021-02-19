package com.example.testapp2;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class InformationFragment extends Fragment {

    ArrayList<Category> categories = new ArrayList<Category>();
    public void setInitialData(){
        categories.add(new Category(R.drawable.ic_minus, "1"));
        categories.add(new Category(R.drawable.ic_plus, "2"));
        categories.add(new Category(R.drawable.ic_sword, "3"));
        categories.add(new Category(R.drawable.ic_hint, "4"));
        categories.add(new Category(R.drawable.ic_diary, "5"));
        categories.add(new Category(R.drawable.ic_winners_cup, "6"));


    }

    RecyclerView mRecyclerView;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_informaton, container, false);
        setInitialData();

        mRecyclerView = (RecyclerView)view.findViewById(R.id.recycler);
        GridLayoutManager grd = new GridLayoutManager(view.getContext(), 2, LinearLayoutManager.VERTICAL, false);
        CategoryAdapter mCategoryAdapter = new CategoryAdapter(view.getContext(), categories);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(grd);
        mRecyclerView.setAdapter(mCategoryAdapter);





        return view;
    }


}