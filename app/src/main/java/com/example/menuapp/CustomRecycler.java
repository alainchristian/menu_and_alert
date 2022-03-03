package com.example.menuapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class CustomRecycler extends AppCompatActivity {
    RecyclerView custRecyclerView;
    RecyclerView.LayoutManager layoutManager;
    List<Product> productList = new ArrayList<>();
    CustRecyclerAdapter custRecyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_recycler);
        custRecyclerView=findViewById(R.id.custRecyclerView);
        layoutManager=new LinearLayoutManager(this);
        custRecyclerView.setLayoutManager(layoutManager);
        productList=MyData.addProduct();
        custRecyclerAdapter=new CustRecyclerAdapter(this,productList);
        custRecyclerView.setAdapter(custRecyclerAdapter);


    }


}