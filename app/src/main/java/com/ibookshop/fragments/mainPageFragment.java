package com.ibookshop.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ibookshop.R;
import com.ibookshop.data.Book;
import com.ibookshop.data.Category;
import com.ibookshop.data.CategoryAdapter;

import java.util.ArrayList;
import java.util.List;

public class mainPageFragment extends Fragment {
    private RecyclerView rcvCategory;
    private CategoryAdapter categoryAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        rcvCategory =view.findViewById(R.id.rcv_category);
        categoryAdapter = new CategoryAdapter(getActivity());

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false);
        rcvCategory.setLayoutManager(linearLayoutManager);
        categoryAdapter.setData(getListCategory());
        rcvCategory.setAdapter(categoryAdapter);
        return  view;
    }

    private List<Category> getListCategory() {
        List<Category> listCategory = new ArrayList<>();

        List<Book> listBook_1 = new ArrayList<>();
        listBook_1.add(new Book("THE TRIALS OF APOLLO","RICK RIORDAN",R.drawable.book1));
        listBook_1.add(new Book("HARRY POTTER  &\n"+"SORCERER’S STONE","J.K ROWLING",R.drawable.book2));
        listBook_1.add(new Book("THE GLASS HOTEL","EMILY ST.JOHN MANDEL",R.drawable.book3));
        listBook_1.add(new Book("ROOM","EMMA DONOGHVE",R.drawable.book4));
        listBook_1.add(new Book("OPEN BLIND EYES","RACHEL TIMOTHY",R.drawable.book5));

        listCategory.add(new Category("",listBook_1));
        return listCategory;
    }


}