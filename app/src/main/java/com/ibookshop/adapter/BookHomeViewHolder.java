package com.ibookshop.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.ibookshop.R;


public class BookHomeViewHolder extends RecyclerView.ViewHolder {
    public TextView txtenSach,txtacGia;
    public ImageView imgHinh;
    public BookHomeViewHolder(@NonNull View itemView) {

        super(itemView);
        txtenSach = itemView.findViewById(R.id.TenSach);
        txtacGia = itemView.findViewById(R.id.TenTacGia);
        imgHinh = itemView.findViewById(R.id.imgSach);



    }
    public void setItemClickListener(View.OnClickListener listener) {
        itemView.setOnClickListener(listener);
    }
}
