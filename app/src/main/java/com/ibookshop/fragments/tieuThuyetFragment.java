package com.ibookshop.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
<<<<<<< HEAD
import android.widget.Toast;
=======
>>>>>>> d9258338d0c65c8d937aa1875528a4f9dd93031e

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

<<<<<<< HEAD
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
=======
>>>>>>> d9258338d0c65c8d937aa1875528a4f9dd93031e
import com.ibookshop.R;
import com.ibookshop.data.Book;
import com.ibookshop.data.Category;
import com.ibookshop.data.CategoryAdapter;

import java.util.ArrayList;
import java.util.List;


public class tieuThuyetFragment extends Fragment {
    private RecyclerView rcvCategory;
    private CategoryAdapter categoryAdapter;
<<<<<<< HEAD
    DatabaseReference databaseReference;
    private List<Category> listCategory = new ArrayList<>();
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tieu_thuyet, container, false);
        //Ánh xạ
        rcvCategory = view.findViewById(R.id.rcv_category);
        // Truy vấn Firebase
        databaseReference = FirebaseDatabase.getInstance("https://ibookshoppj-default-rtdb.asia-southeast1.firebasedatabase.app").getReference("category");
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
                for (DataSnapshot dataSnapshot : snapshot.getChildren()){f
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
=======

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tieu_thuyet, container, false);
        rcvCategory = view.findViewById(R.id.rcv_category);
        categoryAdapter = new CategoryAdapter(getActivity());

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false);
        rcvCategory.setLayoutManager(linearLayoutManager);

        categoryAdapter.setData(getListCategory());
        rcvCategory.setAdapter(categoryAdapter);
        return view;
    }

    private List<Category> getListCategory() {
        List<Category> listCategory = new ArrayList<>();

        List<Book> listBook_1 = new ArrayList<>();
        listBook_1.add(new Book("THE GLASS HOTEL", "EMILY ST.JOHN MANDEL", R.drawable.novel5));
        listBook_1.add(new Book("OPEN BLIND EYES", "RACHEL TIMOTHY", R.drawable.novel6));
        listBook_1.add(new Book("TO KILL A MOCKING BIRD", "HARPER LEE", R.drawable.novel1));
        listBook_1.add(new Book("THE FAULT IN OUR START", "JOHN GREEN", R.drawable.novel4));

        List<Book> listBook_2 = new ArrayList<>();
        listBook_2.add(new Book("SHALIMAR THE CLOWN", "SALMAN RUSHDIE", R.drawable.novel3));
        listBook_2.add(new Book("TO KILL A MOCKING BIRD", "HARPER LEE", R.drawable.novel1));
        listBook_2.add(new Book("THE GLASS HOTEL", "EMILY ST.JOHN MANDEL", R.drawable.novel5));
        listBook_2.add(new Book("MIDNIGHTS CHILDREN", "SALMAN RUSHDIE", R.drawable.novel2));

        List<Book> listBook_3 = new ArrayList<>();
        listBook_3.add(new Book("THE TRIALS OF APOLLO", "RICK RIORDAN", R.drawable.book1));
        listBook_3.add(new Book("HARRY POTTER", "J.K ROWLING", R.drawable.book2));
        listBook_3.add(new Book("THE GLASS HOTEL", "EMILY ST.JOHN MANDEL", R.drawable.novel5));
        listBook_3.add(new Book("ROOM", "EMMA DONOGHVE", R.drawable.book4));
        listBook_3.add(new Book("OPEN BLIND EYES", "RACHEL TIMOTHY", R.drawable.novel6));
        listBook_3.add(new Book("TO KILL A MOCKING BIRD", "HARPER LEE", R.drawable.novel1));
        listCategory.add(new Category("Tiểu thuyết thịnh hành", listBook_1));
        listCategory.add(new Category("Tiểu thuyết được đề xuất", listBook_2));
        listCategory.add(new Category("Sách được đánh giá hay nhất", listBook_3));
        return listCategory;
    }
>>>>>>> d9258338d0c65c8d937aa1875528a4f9dd93031e
}