package com.ibookshop.adapter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.ibookshop.fragments.BookDetailPageFragment;
import com.squareup.picasso.Picasso;
import com.ibookshop.R;
import com.ibookshop.data.BookHome;

public class BookHomeAdapter extends FirebaseRecyclerAdapter<BookHome, BookHomeAdapter.myBook> {

    private final Context context;

    public BookHomeAdapter(@NonNull FirebaseRecyclerOptions<BookHome> options, Context context) {
        super(options);
        this.context = context;
    }

    @NonNull
    @Override
    public myBook onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_books, parent, false);
        return new myBook(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull myBook holder, int position, @NonNull BookHome model) {
        holder.txtenSach.setText(model.getTenSach());
        holder.txtacGia.setText(model.getTenTacGia());
        Picasso.get().load(model.getUrlImage()).into(holder.imgHinh);

        holder.setItemClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Tạo một Bundle để truyền dữ liệu
                Bundle bundle = new Bundle();
                bundle.putString("detail_tenSach", model.getTenSach());
                bundle.putString("detail_tenTacGia", model.getTenTacGia());
                bundle.putString("detail_urlImage", model.getUrlImage());
                bundle.putString("detail_Gia", model.getGia());
                bundle.putString("detail_SoTrang", model.getSoTrang());
                bundle.putString("detail_ngayPhatHanh", model.getNgayPhatHanh());
                bundle.putString("detail_ngonNgu", model.getNgonNgu());
                bundle.putString("detail_theLoai", model.getTheLoai());
                bundle.putString("detail_moTa", model.getMoTa());
                bundle.putInt("id_bookHome", Integer.parseInt(getRef(position).getKey()));
                bundle.putString("detail_readUrl", model.getReadUrl());

                BookDetailPageFragment bookDetailPageFragment = new BookDetailPageFragment();
                bookDetailPageFragment.setArguments(bundle);

                FragmentActivity activity = (FragmentActivity) context;
                activity.getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container, bookDetailPageFragment)
                        .addToBackStack(null)
                        .commit();
            }
        });
    }

    public class myBook extends RecyclerView.ViewHolder {
        public TextView txtenSach, txtacGia;
        public ImageView imgHinh;

        public myBook(@NonNull View itemView) {
            super(itemView);
            txtenSach = itemView.findViewById(R.id.TenSach);
            txtacGia = itemView.findViewById(R.id.TenTacGia);
            imgHinh = itemView.findViewById(R.id.imgSach);
        }

        public void setItemClickListener(View.OnClickListener listener) {
            itemView.setOnClickListener(listener);
        }
    }
}
