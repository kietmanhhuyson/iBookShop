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


public class tieuThuyetFragment extends Fragment {
    private RecyclerView rcvCategory;
    private CategoryAdapter categoryAdapter;

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
}