package com.ibookshop.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.ibookshop.R;
import com.ibookshop.data.Book;
import com.ibookshop.data.LibraryAdapter;

import java.util.ArrayList;


public class myBookFragment extends Fragment {
    ListView lvBook;
    ArrayList<Book> arrayBook;
    LibraryAdapter adapter;
    ImageButton imgbtn;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_book,container,false);
        AnhXa(view);
        adapter = new LibraryAdapter(getActivity(),R.layout.item_library,arrayBook);
        lvBook.setAdapter(adapter);
        imgbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new mainPageFragment()).commit();
            }
        });
        return view;
    }
    private void AnhXa(View view){
        lvBook = (ListView) view.findViewById(R.id.lvLibrary);
        imgbtn = (ImageButton) view.findViewById(R.id.mdi_arrow_l);
        arrayBook = new ArrayList<>();

        arrayBook.add(new Book("OPEN BLIND EYES","RACHEL TIMOTHY",R.drawable.novel6,298,"24/11/2020",75));
        arrayBook.add(new Book("THE GLASS HOTEL","EMILY ST.JOHN MANDEL",R.drawable.novel5,320,"24/03/2020",90));
        arrayBook.add(new Book("ROOM","EMMA DONOGHVE",R.drawable.book4,336,"06/08/2020",0));
        arrayBook.add(new Book("THE NEST","AMY POERLER",R.drawable.fiction2,209,"14/07/2018",40));
    }
}