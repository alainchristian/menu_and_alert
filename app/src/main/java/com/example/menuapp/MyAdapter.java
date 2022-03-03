package com.example.menuapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    Context context;
    List<String> mList;

    public MyAdapter(Context context, List<String> mList) {
        this.context = context;
        this.mList = mList;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater =LayoutInflater.from(context);
        View view =inflater.inflate(R.layout.row_item,parent,false);
        return new MyViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        String a =mList.get(position);
        holder.tvPhone.setText(a);
    }
    @Override
    public int getItemCount() {
        return mList.size() ;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvPhone;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvPhone=itemView.findViewById(R.id.tvphone);
        }
    }
}
