package com.ibookshop.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseListAdapter;
import com.firebase.ui.database.FirebaseListOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.ibookshop.R;
import com.ibookshop.adapter.RVMyBookAdapter;
import com.ibookshop.data.Book;
import com.ibookshop.adapter.LibraryAdapter;
import com.ibookshop.data.MyBook;
import com.ibookshop.utils.Utils;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class myBookFragment extends Fragment {
    RecyclerView rvMybook;
    ArrayList<MyBook> arrayMyBook;
    LibraryAdapter adapter;
    ImageButton imgbtn;
    private RVMyBookAdapter rVMyBookAdapter;
    DatabaseReference databaseReference;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_book,container,false);
        AnhXa(view);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 1, GridLayoutManager.VERTICAL, false);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false);
        rvMybook.setLayoutManager(gridLayoutManager);
        rVMyBookAdapter = new RVMyBookAdapter(getActivity().getSupportFragmentManager(),arrayMyBook);
        rvMybook.setAdapter(rVMyBookAdapter);
        databaseReference = FirebaseDatabase.getInstance().getReference("MyBook");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                arrayMyBook = new ArrayList<>();
                int i=0;
                for (DataSnapshot bookSnapshot : snapshot.getChildren()) {
                    String tenSach = bookSnapshot.child("TenSach").getValue(String.class);
                    String tenTacGia = bookSnapshot.child("TenTacGia").getValue(String.class);
                    String user = bookSnapshot.child("User").getValue(String.class);
                    String ngayPhatHanh = bookSnapshot.child("ngayPhatHanh").getValue(String.class);
                    int phanTramDoc = bookSnapshot.child("phanTramDoc").getValue(Integer.class);
                    String readUrl = bookSnapshot.child("readUrl").getValue(String.class);
                    int soTrang = bookSnapshot.child("soTrang").getValue(Integer.class);
                    String surl = bookSnapshot.child("surl").getValue(String.class);
                    if(user.equalsIgnoreCase(Utils.userEmail)) {
                        MyBook myBook = new MyBook( tenSach,  tenTacGia,  surl,  readUrl,  soTrang,  ngayPhatHanh,  phanTramDoc);
                        arrayMyBook.add(myBook);
                    }
                }
                rVMyBookAdapter.setData(arrayMyBook);
                rVMyBookAdapter.notifyDataSetChanged();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });

        imgbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new mainPageFragment()).commit();
            }
        });
        return view;
    }
    private void AnhXa(View view){
        rvMybook = (RecyclerView) view.findViewById(R.id.rvLibrary);
        imgbtn = (ImageButton) view.findViewById(R.id.mdi_arrow_l);
//        arrayBook = new ArrayList<>();
//        arrayBook.add(new Book("OPEN BLIND EYES","RACHEL TIMOTHY",R.drawable.novel6,298,"24/11/2020",75));
//        arrayBook.add(new Book("THE GLASS HOTEL","EMILY ST.JOHN MANDEL",R.drawable.novel5,320,"24/03/2020",90));
//        arrayBook.add(new Book("ROOM","EMMA DONOGHVE",R.drawable.book4,336,"06/08/2020",0));
//        arrayBook.add(new Book("THE NEST","AMY POERLER",R.drawable.fiction2,209,"14/07/2018",40));
    }
}