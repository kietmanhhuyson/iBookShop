package com.ibookshop.data;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.ibookshop.R;
import com.ibookshop.fragments.ReadFragment;

import java.util.List;

public class LibraryAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Book> BookList;

    public LibraryAdapter(Context context, int layout, List<Book> bookList) {
        this.context = context;
        this.layout = layout;
        BookList = bookList;
    }

    @Override
    public int getCount() {
        return BookList.size();
    }

    @Override
    public Object getItem(int position) {
        return BookList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout, null);

            viewHolder = new ViewHolder();
            viewHolder.txtTenSach = convertView.findViewById(R.id.BookName);
            viewHolder.txtTenTacGia = convertView.findViewById(R.id.TacGiaName);
            viewHolder.imgHinh = convertView.findViewById(R.id.Hinh);
            viewHolder.txtSoTrang = convertView.findViewById(R.id.soTrang);
            viewHolder.txtNgayPhatHanh = convertView.findViewById(R.id.ngayPhatHanh);
            viewHolder.txtPhanTram = convertView.findViewById(R.id.phanTram);
            viewHolder.progressBar = convertView.findViewById(R.id.customProgressBar);
            viewHolder.button = convertView.findViewById(R.id.button);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Book book = BookList.get(position);
        viewHolder.txtTenSach.setText(book.getTenSach());
        viewHolder.txtTenTacGia.setText(book.getTenTacGia());
        viewHolder.imgHinh.setImageResource(book.getHinh());
        viewHolder.txtSoTrang.setText(String.valueOf(book.getSoTrang()));
        viewHolder.txtNgayPhatHanh.setText(String.valueOf(book.getNgayPhatHanh()));
        viewHolder.txtPhanTram.setText(String.valueOf(book.getPhantramDoc()));
        viewHolder.progressBar.setProgress(book.getPhantramDoc());
        viewHolder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (book.getTenSach().equals("OPEN BLIND EYES")){
                    ReadFragment readFragment = new ReadFragment();
                    FragmentManager fragmentManager = ((AppCompatActivity) context).getSupportFragmentManager();
                    fragmentManager.beginTransaction()
                            .replace(R.id.fragment_container, readFragment) // Thay "R.id.fragment_container" bằng ID của container fragment của bạn.
                            .addToBackStack(null) // Thêm fragment hiện tại vào back stack để có thể quay lại sau này.
                            .commit();
                }
            }
        });
        return convertView;
    }

    static class ViewHolder {
        TextView txtTenSach;
        TextView txtTenTacGia;
        ImageView imgHinh;
        TextView txtSoTrang;
        TextView txtNgayPhatHanh;
        TextView txtPhanTram;
        Button button;
        ProgressBar progressBar;
    }
}
