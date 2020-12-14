package com.example.bank;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<String> titles;
    List<Integer> images;
    Adapter adapter;

    //boolean insertData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycleView);

        titles = new ArrayList<>();
        images = new ArrayList<>();

        titles.add("ADD ACCOUNT");
        titles.add("CUSTOMER DETAILS");
        titles.add("TRANSFER MONEY");

        images.add(R.drawable.ic_baseline_person_add_24);
        images.add(R.drawable.ic_baseline_account_balance_24);
        images.add(R.drawable.ic_baseline_transfer_within_a_station_24);

        adapter = new Adapter(this,titles,images);


        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,1,GridLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter((RecyclerView.Adapter) adapter);
    }
}