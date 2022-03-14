package com.example.menuapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StudentRVAdapter extends RecyclerView.Adapter<VH> {
    List<Student> stList;

    StudentRVAdapter(List<Student> studentList){
        this.stList=studentList;
    }


    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.studentrow,parent,false);
        return new VH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        Student st =stList.get(position);
        holder.tvName.setText(st.getStName());
        holder.tvFaculty.setText(st.getStFaculty());
        holder.tvPhone.setText(st.getStPhone());

    }

    @Override
    public int getItemCount() {
        return stList.size();
    }
}
