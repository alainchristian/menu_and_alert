package com.example.menuapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class RecyclerActivity extends AppCompatActivity {
    RecyclerView myRecycler;
    RecyclerView.LayoutManager layoutManager;
    List<String> mList = new ArrayList<>();
    MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        myRecycler=findViewById(R.id.myRecycler);
        layoutManager=new LinearLayoutManager(this);
        myRecycler.setLayoutManager(layoutManager);
        mList.add("iPhone"); mList.add("Sumsung"); mList.add("Tecno"); mList.add("Infinix");
        mList.add("Blackberry");mList.add("iPhone"); mList.add("Sumsung");mList.add("iPhone"); mList.add("Sumsung");mList.add("iPhone"); mList.add("Sumsung");mList.add("iPhone");
        mList.add("Sumsung");mList.add("iPhone"); mList.add("Sumsung");
        myAdapter=new MyAdapter(this,mList);
        myRecycler.setAdapter(myAdapter);
    }
}