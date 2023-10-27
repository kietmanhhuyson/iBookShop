package com.ibookshop.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.ibookshop.R;

public class PaymentPageFragment extends Fragment {
    private TextView txtAddCard;
    private Button btnPayNow;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_payment_page,container,false);
        txtAddCard = view.findViewById(R.id.txt_addcard);
        btnPayNow =view.findViewById(R.id.btn_paynow);

        txtAddCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new AddCardPageFragment()).commit();
                }
        });
        btnPayNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new AddCardPageFragment()).commit();
            }
        });

        return  view;
    }
}