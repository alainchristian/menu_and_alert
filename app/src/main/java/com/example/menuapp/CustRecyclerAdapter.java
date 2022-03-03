package com.example.menuapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustRecyclerAdapter extends RecyclerView.Adapter<CustRecyclerAdapter.VH> {
    Context context;
    List<Product> productList;

    public CustRecyclerAdapter(Context context, List<Product> productList) {
        this.context = context;
        this.productList = productList;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view =inflater.inflate(R.layout.curtom_row_item,parent,false);
        return new VH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        Product product =productList.get(position);
       holder.prodImage.setImageResource(product.getProdImage());
       holder.prodName.setText(product.getProdName());
       holder.prodPrice.setText(""+product.getProdPrice());
       holder.prodDescr.setText(product.getProdDescr());
       holder.itemView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Toast.makeText(context, ""+product.getProdName()+"\n"+product.prodPrice, Toast.LENGTH_SHORT).show();
           }
       });
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    class VH extends RecyclerView.ViewHolder {
        ImageView prodImage;
        TextView prodName,prodPrice,prodDescr;
        public VH(@NonNull View itemView) {
            super(itemView);
            prodImage = itemView.findViewById(R.id.prodImage);
            prodName = itemView.findViewById(R.id.prodName);
            prodPrice = itemView.findViewById(R.id.prodPrice);
            prodDescr = itemView.findViewById(R.id.prodDescr);

        }
    }
}
