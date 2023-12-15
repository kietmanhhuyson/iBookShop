package com.ibookshop.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;
import com.ibookshop.R;
import com.ibookshop.data.BookHome;
import com.ibookshop.utils.Utils;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PaySuccessPageFragment extends Fragment {

    private Button btnBackHome, btnMyHome;
    private ArrayList<BookHome> arrBooks;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_pay_success_page,container,false);
        btnBackHome =view.findViewById(R.id.btn_backHome);
        btnMyHome = view.findViewById(R.id.btn_myHome);

        btnBackHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new mainPageFragment()).commit();
            }
        });

        btnMyHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new myBookFragment()).commit();
            }
        });
        arrBooks = new ArrayList<>();
        if(Utils.cartBooks.size()!=0) {
            for(int i=0;i<Utils.cartBooks.size();i++) {
                if(Utils.cartBooks.get(i).isShouldbeRemove()){
                    arrBooks.add(Utils.cartBooks.get(i));
                }
            }
        }
        insertData();
        return view;
    }

    public void insertData() {
        Map<String,Object> map = new HashMap<>();
        if(arrBooks.size()!=0) {
            for(int i=0;i<arrBooks.size();i++) {
                map.put("TenSach", arrBooks.get(i).getTenSach().toString());
                map.put("TenTacGia", arrBooks.get(i).getTenTacGia().toString());
                map.put("User", Utils.userEmail.toString());
                map.put("ngayPhatHanh", arrBooks.get(i).getNgayPhatHanh().toString());
                map.put("phanTramDoc",Integer.parseInt(arrBooks.get(i).getPhanTramDoc()));
                map.put("readUrl", arrBooks.get(i).getReadUrl().toString());
                String soTrang = arrBooks.get(i).getSoTrang().replaceAll("[^0-9+-]", "");
                map.put("soTrang",Integer.parseInt(soTrang));
                map.put("surl", arrBooks.get(i).getUrlImage().toString());

                FirebaseDatabase.getInstance().getReference().child("MyBook").push()
                        .setValue(map)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                Toast.makeText(getActivity(), "Đã thêm vào sách của tôi", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(getActivity(), "Gặp lỗi", Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        }


    }
}