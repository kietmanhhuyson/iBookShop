package com.ibookshop.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ibookshop.R;
import com.ibookshop.data.BookHome;
import com.ibookshop.utils.Utils;
import com.squareup.picasso.Picasso;

public class BookDetailPageFragment extends Fragment {
    private Button btnAddtoCart;
    private ImageView btnBacktoHome;

    private BookHome bookToAdd;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_book_detail_page, container, false);

        // Lấy dữ liệu từ Bundle
        Bundle bundle = getArguments();
        if (bundle != null && bundle.containsKey("detail_tenSach")) {
            String tenSach = bundle.getString("detail_tenSach");
            String tenTacGia = bundle.getString("detail_tenTacGia");
            String urlImage = bundle.getString("detail_urlImage");
            String Gia = bundle.getString("detail_Gia");
            String SoTrang = bundle.getString("detail_SoTrang");
            String ngayPhatHanh = bundle.getString("detail_ngayPhatHanh");
            String ngonNgu = bundle.getString("detail_ngonNgu");
            String theLoai = bundle.getString("detail_theLoai");
            String moTa = bundle.getString("detail_moTa");
            int idBookHome = bundle.getInt("id_bookHome");
            String readUrl = bundle.getString("detail_readUrl");
            bookToAdd = new BookHome(idBookHome,  tenSach,  tenTacGia,  urlImage, Gia, SoTrang,  ngayPhatHanh,  readUrl,  "0");

            //bookToAdd = new BookHome(idBookHome,tenSach,tenTacGia, urlImage, Gia);

            // Hiển thị dữ liệu trên giao diện
            TextView txtTenSach = view.findViewById(R.id.dtenSach);
            TextView txtTacGia = view.findViewById(R.id.dtacgia);
            ImageView imgHinh = view.findViewById(R.id.dhinh);
            TextView txGia = view.findViewById(R.id.dGia);
            TextView txSoTrang = view.findViewById(R.id.dsoTrang);
            TextView txngayPhatHanh = view.findViewById(R.id.dngayPhatHanh);
            TextView txngoNgu = view.findViewById(R.id.dngoNgu);
            TextView txtheLoai = view.findViewById(R.id.dtheLoai);
            TextView txmoTa = view.findViewById(R.id.dmoTa);

            txtTenSach.setText(tenSach);
            txtTacGia.setText(tenTacGia);
            Picasso.get().load(urlImage).into(imgHinh);
            txGia.setText(Gia);
            txSoTrang.setText(SoTrang);
            txngayPhatHanh.setText(ngayPhatHanh);
            txngoNgu.setText(ngonNgu);
            txtheLoai.setText(theLoai);
            txmoTa.setText(moTa);
        }
        btnAddtoCart = view.findViewById(R.id.btn_addToCart);
        btnAddtoCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isFind = false;
                if (Utils.cartBooks.size()>0) {
                    for (int i=0; i<Utils.cartBooks.size();i++) {
                        if(Utils.cartBooks.get(i).getIdBookHome()==bookToAdd.getIdBookHome()) {
                            isFind= true;
                        }
                    }
                    if (isFind) {

                    }
                    else {
                        Utils.cartBooks.add(bookToAdd);
                        Toast.makeText(getContext(), "Thêm thành công", Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Utils.cartBooks.add(bookToAdd);
                    Toast.makeText(getContext(), "Thêm thành công", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnBacktoHome = view.findViewById(R.id.btn_BacktoHome);
        btnBacktoHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new mainPageFragment()).commit();
            }
        });

        return view;
    }


}
