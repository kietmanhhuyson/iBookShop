package com.ibookshop.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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


public class truyenFragment extends Fragment {
    private RecyclerView rcvCategory;
    private CategoryAdapter categoryAdapter;
<<<<<<< HEAD
    DatabaseReference databaseReference;
    private List<Category> listCategory = new ArrayList<>();
=======
>>>>>>> d9258338d0c65c8d937aa1875528a4f9dd93031e

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_truyen,container,false);
<<<<<<< HEAD
        //Ánh xạ
        rcvCategory = view.findViewById(R.id.rcv_category);
        //Truy vấn Firebase
        databaseReference = FirebaseDatabase.getInstance("https://ibookshoppj-default-rtdb.asia-southeast1.firebasedatabase.app").getReference("category");
        DatabaseReference dbRFtruyenTH = databaseReference.child("truyen").child("thinh hanh");
        DatabaseReference dbRFtruyenDX = databaseReference.child("truyen").child("de xuat");
        DatabaseReference dbRFsachHN = databaseReference.child("truyen").child("sach hay nhat");
        //Cấu hinh RecyclerView Adapter
        categoryAdapter = new CategoryAdapter(getActivity());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false);
        rcvCategory.setLayoutManager(linearLayoutManager);
        rcvCategory.setAdapter(categoryAdapter);
        dbRFtruyenTH.addValueEventListener(new ValueEventListener() {
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
                listCategory.add(new Category("Truyện thịnh hành", listbook_1));
//              categoryAdapter.setData(listcategory_2);
                categoryAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        dbRFtruyenDX.addValueEventListener(new ValueEventListener() {
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
                listCategory.add(new Category("Truyện được đề xuất",listbook_2));
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
=======
        rcvCategory = view.findViewById(R.id.rcv_category);
        categoryAdapter = new CategoryAdapter(getActivity());

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false);
        rcvCategory.setLayoutManager(linearLayoutManager);

        categoryAdapter.setData(getListCategory());
        rcvCategory.setAdapter(categoryAdapter);
        return view;
    }
    private List<Category> getListCategory(){
        List<Category> listCategory = new ArrayList<>();

        List<Book> listBook_1 = new ArrayList<>();
        listBook_1.add(new Book("DOGGER","OLIVIA COLMAN",R.drawable.storybook1));
        listBook_1.add(new Book("THE SNOWMAN","RAYMOND BRIGGS",R.drawable.storybook2));
        listBook_1.add(new Book("BURGLAR BILL","ALLAN ABLBERG",R.drawable.storybook3));
        listBook_1.add(new Book("HARRY POTTER\n" +
                " &\n" +
                "SORCERER’S STONE","J.K ROWLING",R.drawable.book2));
        List<Book> listBook_2 = new ArrayList<>();
        listBook_2.add(new Book("BURGLAR BILL","ALLAN ABLBERG",R.drawable.storybook3));
        listBook_2.add(new Book("HARRY POTTER\n" +
                " &\n" +
                "SORCERER’S STONE","J.K ROWLING",R.drawable.book2));
        listBook_2.add(new Book("DOGGER","OLIVIA COLMAN",R.drawable.storybook1));
        listBook_2.add(new Book("THE SNOWMAN","RAYMOND BRIGGS",R.drawable.storybook2));

        List<Book> listBook_3 = new ArrayList<>();
        listBook_3.add(new Book("THE TRIALS OF APOLLO","RICK RIORDAN",R.drawable.book1));
        listBook_3.add(new Book("HARRY POTTER","J.K ROWLING",R.drawable.book2));
        listBook_3.add(new Book("THE GLASS HOTEL","EMILY ST.JOHN MANDEL",R.drawable.novel5));
        listBook_3.add(new Book("ROOM","EMMA DONOGHVE",R.drawable.book4));
        listBook_3.add(new Book("OPEN BLIND EYES","RACHEL TIMOTHY",R.drawable.novel6));
        listBook_3.add(new Book("TO KILL A MOCKING BIRD","HARPER LEE",R.drawable.novel1));
        listCategory.add(new Category("Truyện thịnh hành",listBook_1));
        listCategory.add(new Category("Truyện được đề xuất",listBook_2));
        listCategory.add(new Category("Sách được đánh giá hay nhất",listBook_3));
        return listCategory;
    }
>>>>>>> d9258338d0c65c8d937aa1875528a4f9dd93031e
}