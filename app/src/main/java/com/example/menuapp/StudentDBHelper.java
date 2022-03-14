package com.example.menuapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class StudentDBHelper extends SQLiteOpenHelper {
    Context context;

    public StudentDBHelper(@Nullable Context context) {
        super(context, "studentDB.db", null, 1);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL("create table stTable(stId INTEGER PRIMARY KEY AUTOINCREMENT, stName TEXT,stFaculty TEXT,stPhone TEXT)");
        } catch (Exception e) {
            Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        try {
            db.execSQL("drop table if exists stTable");
            db.close();
        } catch (Exception e) {
            Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
    public void insertData(Student student){
        try {
            SQLiteDatabase myDB =getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("stName",student.getStName());
            values.put("stFaculty",student.getStFaculty());
            values.put("stPhone",student.getStPhone());
            long l=myDB.insert("stTable",null,values);
            if (l==-1){
                Toast.makeText(context, "Data entry failed", Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(context, "Data entry successful", Toast.LENGTH_SHORT).show();
            }

        }catch (Exception e) {
            Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }
    public List<Student> getData(){
        SQLiteDatabase db=getReadableDatabase();
        List<Student> stList = new ArrayList<>();
        Cursor cursor =db.rawQuery("select * from stTable",null);
        if (cursor.getCount()>0){
            while (cursor.moveToNext()){
                String name=cursor.getString(1);
                String faculty=cursor.getString(2);
                String phone =cursor.getString(3);
                stList.add(new Student(name,faculty,phone));

            }
        }
       return stList;
    }
}
