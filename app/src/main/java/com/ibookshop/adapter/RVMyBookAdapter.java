package com.ibookshop.adapter;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ibookshop.R;
import com.ibookshop.data.BookHome;
import com.ibookshop.data.Category;
import com.ibookshop.data.MyBook;
import com.ibookshop.fragments.ReadFragment;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class RVMyBookAdapter extends RecyclerView.Adapter<RVMyBookAdapter.ViewHolder> {

    private ArrayList<MyBook> localDataSet;
    private FragmentManager fragmentManager;

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtTenSach;
        TextView txtTenTacGia;
        ImageView imgHinh;
        TextView txtSoTrang;
        TextView txtNgayPhatHanh;
        TextView txtPhanTram;
        Button button;
        ProgressBar progressBar;

        public ViewHolder(View view) {
            super(view);
             txtTenSach = itemView.findViewById(R.id.BookName);
             txtTenTacGia = itemView.findViewById(R.id.TacGiaName);
             imgHinh = itemView.findViewById(R.id.Hinh);
             txtSoTrang = itemView.findViewById(R.id.soTrang);
             txtNgayPhatHanh = itemView.findViewById(R.id.ngayPhatHanh);
             txtPhanTram = itemView.findViewById(R.id.phanTram);
             button = itemView.findViewById(R.id.button);
             progressBar = itemView.findViewById(R.id.customProgressBar);
        }

        public TextView getTxtTenSach() {
            return txtTenSach;
        }

        public TextView getTxtTenTacGia() {
            return txtTenTacGia;
        }

        public ImageView getImgHinh() {
            return imgHinh;
        }

        public TextView getTxtSoTrang() {
            return txtSoTrang;
        }

        public TextView getTxtNgayPhatHanh() {
            return txtNgayPhatHanh;
        }

        public TextView getTxtPhanTram() {
            return txtPhanTram;
        }

        public Button getButton() {
            return button;
        }

        public ProgressBar getProgressBar() {
            return progressBar;
        }
    }

    /**
     * Initialize the dataset of the Adapter.
     *
     * @param dataSet String[] containing the data to populate views to be used
     * by RecyclerView.
     */
    public RVMyBookAdapter(FragmentManager fragmentManager, ArrayList<MyBook> dataSet) {
        this.fragmentManager = fragmentManager;
        localDataSet = dataSet;
    }
    public void setData(ArrayList<MyBook> list) {
        this.localDataSet = list;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_library, viewGroup, false);

        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        viewHolder.txtTenSach.setText(localDataSet.get(position).getTenSach());
        viewHolder.txtTenTacGia.setText(localDataSet.get(position).getTenTacGia());
        viewHolder.txtSoTrang.setText(String.valueOf(localDataSet.get(position).getSoTrang()));
        Picasso.get().load(localDataSet.get(position).getSurl()).into(viewHolder.imgHinh);
        viewHolder.txtNgayPhatHanh.setText(localDataSet.get(position).getNgayPhatHanh());
        viewHolder.txtPhanTram.setText(String.valueOf(localDataSet.get(position).getPhanTramDoc()));
        viewHolder.progressBar.setProgress(localDataSet.get(position).getPhanTramDoc());
        viewHolder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("url", localDataSet.get(position).getReadUrl()); // Giả sử có một phương thức getUrl để lấy URL từ model

                // Tạo một Fragment mới và đặt dữ liệu cho nó
                ReadFragment readFragment = new ReadFragment();
                readFragment.setArguments(bundle);
                // Chuyển đổi Fragment
                fragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, readFragment)
                        .addToBackStack(null) // Để có thể quay lại Fragment trước đó
                        .commit();
            }
        });
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        if(localDataSet!=null) {
            return localDataSet.size();
        }
        return 0;
    }
}

