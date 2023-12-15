package com.ibookshop.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

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
import com.ibookshop.adapter.CategoryAdapter;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


public class tieuThuyetFragment extends Fragment {
    private RecyclerView rcvCategory;
    private CategoryAdapter categoryAdapter;
    DatabaseReference databaseReference;
    private List<Category> listCategory = new ArrayList<>();
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tieu_thuyet, container, false);
        //Ánh xạ
        rcvCategory = view.findViewById(R.id.rcv_category);
        // Truy vấn Firebase
        databaseReference = FirebaseDatabase.getInstance().getReference("category");
        DatabaseReference dbRFtieuthuyetTH = databaseReference.child("tieu thuyet").child("thinh hanh");
        DatabaseReference dbRFtieuthuyetDX = databaseReference.child("tieu thuyet").child("de xuat");
        DatabaseReference dbRFsachHN = databaseReference.child("tieu thuyet").child("sach hay nhat");
        //Cấu hinh RecyclerView Adapter
        categoryAdapter = new CategoryAdapter(getActivity());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false);
        rcvCategory.setLayoutManager(linearLayoutManager);
        rcvCategory.setAdapter(categoryAdapter);
        //Truy xuất dữ liệu
        dbRFtieuthuyetTH.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ArrayList<Category> listcategory_2 = new ArrayList<>();
                listcategory_2 = (ArrayList<Category>) listCategory;
                ArrayList<Book> listbook_1 = new ArrayList<>();
                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    String tenSach = dataSnapshot.child("TenSach").getValue(String.class);
                    String tenTacGia = dataSnapshot.child("TenTacGia").getValue(String.class);
                    String imageurl = dataSnapshot.child("surl").getValue(String.class);
                    Book book = new Book(tenSach, tenTacGia,imageurl);
                    listbook_1.add(book);
                }
                listCategory.add(new Category("Tiểu thuyết thịnh hành", listbook_1));
//              categoryAdapter.setData(listcategory_2);
                categoryAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getActivity(), "Error: " + error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        dbRFtieuthuyetDX.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ArrayList<Category> listcategory_1 = new ArrayList<>();
                listcategory_1 = (ArrayList<Category>) listCategory;
                ArrayList<Book> listbook_2 = new ArrayList<>();
                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    String tenSach = dataSnapshot.child("TenSach").getValue(String.class);
                    String tenTacGia = dataSnapshot.child("TenTacGia").getValue(String.class);
                    String imageurl = dataSnapshot.child("surl").getValue(String.class);
                    Book book = new Book(tenSach, tenTacGia,imageurl);
                    listbook_2.add(book);
                }
                listCategory.add(new Category("Tiểu thuyết được đề xuất",listbook_2));
//                categoryAdapter.setData(listcategory_1);
                Picasso.get().cancelTag(rcvCategory);
                categoryAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        dbRFsachHN.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ArrayList<Category> listcategory_3 = new ArrayList<>();
                listcategory_3 = (ArrayList<Category>) listCategory;
                ArrayList<Book> listbook_3 = new ArrayList<>();
                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    String tenSach = dataSnapshot.child("TenSach").getValue(String.class);
                    String tenTacGia = dataSnapshot.child("TenTacGia").getValue(String.class);
                    String imageurl = dataSnapshot.child("surl").getValue(String.class);
                    Book book = new Book(tenSach, tenTacGia,imageurl);
                    listbook_3.add(book);
                }
                listCategory.add(new Category("Sách được đánh giá hay nhất", listbook_3));
//                categoryAdapter.setData(listcategory_3);
                Picasso.get().cancelTag(rcvCategory);
                categoryAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        categoryAdapter.setData(listCategory);
        return view;
    }
//    private void updateRecyclerView() {
//        CategoryAdapter newAdapter = new CategoryAdapter(getActivity());
//        listCategory.add(new Category("Tiểu thuyết thịnh hành", new ArrayList<>(tempBookList)));
//        newAdapter.setData(listCategory);
//        rcvCategory.setAdapter(newAdapter);
//    }
//    @Override
//    public void onDestroy() {
//        super.onDestroy();
//        Glide.get(getContext()).clearDiskCache();
//        Glide.get(getContext()).clearMemory();
//    }
}