package com.ibookshop.data;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.ibookshop.R;

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

        return convertView;
    }

    static class ViewHolder {
        TextView txtTenSach;
        TextView txtTenTacGia;
        ImageView imgHinh;
        TextView txtSoTrang;
        TextView txtNgayPhatHanh;
        TextView txtPhanTram;
        ProgressBar progressBar;
    }
}
