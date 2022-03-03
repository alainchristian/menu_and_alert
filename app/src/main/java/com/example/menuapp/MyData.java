package com.example.menuapp;

import java.util.ArrayList;
import java.util.List;

public class MyData {
    public static List<Product> addProduct(){
        List<Product> mList = new ArrayList<>();
        mList.add(new Product(R.drawable.apple,"Apple",200,"Red or green apple from South Africa"));
        mList.add(new Product(R.drawable.banana,"Banana",100,"Description of banana"));
        mList.add(new Product(R.drawable.grape,"Grape",100,"Description of grape"));
        mList.add(new Product(R.drawable.cherry,"Cherry",100,"Description of cherry"));
        mList.add(new Product(R.drawable.mango,"Mango",300,"Description of Mango"));

        return mList;
    }
}
