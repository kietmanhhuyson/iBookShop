package com.ibookshop.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.ibookshop.R;
import com.ibookshop.adapter.BookHomeAdapter;
import com.ibookshop.data.BookHome;

public class mainPageFragment extends Fragment {

    private FirebaseRecyclerOptions<BookHome> options;
    private FirebaseRecyclerAdapter<BookHome, BookHomeAdapter.myBook> adapter;
    private RecyclerView recyclerView;
    DatabaseReference database;
    private ImageButton btnmyBook;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        btnmyBook = view.findViewById(R.id.myBookbtn);
        recyclerView = view.findViewById(R.id.rcv_category);
        database = FirebaseDatabase.getInstance().getReference().child("Books");

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        load();

        adapter.startListening();
        recyclerView.setAdapter(adapter);

        btnmyBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new myBookFragment()).commit();
            }
        });

        return view;
    }

    public void load() {
        options = new FirebaseRecyclerOptions.Builder<BookHome>()
                .setQuery(database, BookHome.class)
                .build();

        adapter = new BookHomeAdapter(options, getContext());
    }
}
