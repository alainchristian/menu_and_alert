package com.example.menuapp;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class VH extends RecyclerView.ViewHolder {
    TextView tvName,tvFaculty,tvPhone;
    public VH(@NonNull View itemView) {
        super(itemView);
        tvName=itemView.findViewById(R.id.stNameTV);
        tvFaculty=itemView.findViewById(R.id.stFacultyTV);
        tvPhone=itemView.findViewById(R.id.stPhoneTV);
    }
}
