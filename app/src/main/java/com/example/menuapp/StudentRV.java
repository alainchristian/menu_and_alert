package com.example.menuapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

public class StudentRV extends AppCompatActivity {
    RecyclerView studentRV;
    List<Student> stList;
    StudentDBHelper studentDBHelper;
    StudentRVAdapter studentRVAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_rv);
        studentRV = findViewById(R.id.studentRV);
        studentRV.setLayoutManager(new LinearLayoutManager(this));
        studentDBHelper=new StudentDBHelper(this);
        stList=studentDBHelper.getData();
        studentRVAdapter=new StudentRVAdapter(stList);
        studentRV.setAdapter(studentRVAdapter);


    }
}