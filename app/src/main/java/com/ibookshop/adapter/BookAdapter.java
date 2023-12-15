package com.ibookshop.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ibookshop.R;
import com.ibookshop.data.Book;
import com.squareup.picasso.Picasso;

import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder> {
    private List<Book> mBooks;
    public void setData(List<Book> list){
        this.mBooks=list;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(com.ibookshop.R.layout.item_sach,parent,false);
        return new BookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {
        Book book =mBooks.get(position);
        if (book == null){
            return;
        }
        String imageUrl = book.getUrlImage();
        Picasso.get().invalidate(imageUrl);
        Picasso.get().load(imageUrl).into(holder.imgBook);
        holder.imgBook.setImageResource(book.getHinh());
        holder.txtTacGia.setText(book.getTenTacGia());
        holder.txtSach.setText(book.getTenSach());
    }

    @Override
    public int getItemCount() {
        if(mBooks != null) {
            return mBooks.size();
        }
        return 0;
    }

    public class BookViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgBook;
        private TextView txtSach;
        private TextView txtTacGia;
        public BookViewHolder(@NonNull View itemView) {
            super(itemView);
            imgBook = itemView.findViewById(R.id.imgSach);
            txtSach =  itemView.findViewById(R.id.TenSach);
            txtTacGia = itemView.findViewById(R.id.TenTacGia);

        }
    }
}
