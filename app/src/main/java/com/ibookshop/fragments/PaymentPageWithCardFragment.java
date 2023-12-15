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

public class PaymentPageWithCardFragment extends Fragment {

    private Button btnPayNow;
    private TextView txtTotalPrice;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_payment_page_with_card,container,false);
        txtTotalPrice = view.findViewById(R.id.txt_totalPrice);
        Bundle bundle = getArguments();
        if (bundle != null && bundle.containsKey("cart_totalPrice")) {
            String totalPrice = bundle.getString("cart_totalPrice");
            txtTotalPrice.setText(totalPrice);
        }

        btnPayNow =view.findViewById(R.id.btn_paynow);

        btnPayNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new PaySuccessPageFragment()).commit();
            }
        });


        return view;
    }
}