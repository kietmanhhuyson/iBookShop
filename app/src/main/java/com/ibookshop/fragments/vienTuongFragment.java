package com.ibookshop.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.ibookshop.R;
import com.ibookshop.data.Book;
import com.ibookshop.data.Category;
import com.ibookshop.data.CategoryAdapter;

import java.util.ArrayList;
import java.util.List;

public class vienTuongFragment extends Fragment {

    private RecyclerView rcvCategory;
    private CategoryAdapter categoryAdapter;

    DatabaseReference databaseReference;
    private List<Category> listCategory = new ArrayList<>();
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_vien_tuong, container, false);
        //Ánh xạ
        rcvCategory = view.findViewById(R.id.rcv_category);
        // Truy vấn Firebase
        databaseReference = FirebaseDatabase.getInstance("https://ibookshoppj-default-rtdb.asia-southeast1.firebasedatabase.app").getReference("category");
        DatabaseReference dbRFvientuongTH = databaseReference.child("vien tuong").child("thinh hanh");
        DatabaseReference dbRFvientuongDX = databaseReference.child("vien tuong").child("de xuat");
        DatabaseReference dbRFsachHN = databaseReference.child("vien tuong").child("sach hay nhat");
        //Cấu hinh RecyclerView Adapter
        categoryAdapter = new CategoryAdapter(getActivity());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false);
        rcvCategory.setLayoutManager(linearLayoutManager);
        rcvCategory.setAdapter(categoryAdapter);
        //Truy xuất dữ liệu từ Firebase
        dbRFvientuongTH.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ArrayList<Book> listbook_1 = new ArrayList<>();
                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    String tenSach = dataSnapshot.child("TenSach").getValue(String.class);
                    String tenTacGia = dataSnapshot.child("TenTacGia").getValue(String.class);
                    String imageurl = dataSnapshot.child("surl").getValue(String.class);
                    Book book = new Book(tenSach, tenTacGia,imageurl);
                    listbook_1.add(book);
                }
                listCategory.add(new Category("Viễn tưởng thịnh hành", listbook_1));
//              categoryAdapter.setData(listcategory_2);
                categoryAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        dbRFvientuongDX.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ArrayList<Book> listbook_2 = new ArrayList<>();
                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    String tenSach = dataSnapshot.child("TenSach").getValue(String.class);
                    String tenTacGia = dataSnapshot.child("TenTacGia").getValue(String.class);
                    String imageurl = dataSnapshot.child("surl").getValue(String.class);
                    Book book = new Book(tenSach, tenTacGia,imageurl);
                    listbook_2.add(book);
                }
                listCategory.add(new Category("Viễn tưởng được đề xuất",listbook_2));
                categoryAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        dbRFsachHN.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ArrayList<Book> listbook_3 = new ArrayList<>();
                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    String tenSach = dataSnapshot.child("TenSach").getValue(String.class);
                    String tenTacGia = dataSnapshot.child("TenTacGia").getValue(String.class);
                    String imageurl = dataSnapshot.child("surl").getValue(String.class);
                    Book book = new Book(tenSach, tenTacGia,imageurl);
                    listbook_3.add(book);
                }
                listCategory.add(new Category("Sách được đánh giá hay nhất", listbook_3));
                categoryAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        categoryAdapter.setData(listCategory);
        return view;
    }
}