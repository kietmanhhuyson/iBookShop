package com.ibookshop.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.ibookshop.R;
import com.ibookshop.adapter.RVCartAdapter;
import com.ibookshop.utils.Utils;

import java.text.DecimalFormat;

public class CartPageFragment extends Fragment implements RVCartAdapter.OnCheckedChangeListener{
    private RecyclerView recyclerView;
    private Button btnPayNow;
    private TextView txtTotalPrice, txtRemoveCart;
    private CheckBox cbCheckAll;

    private boolean shouldBeIgnore=false;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cart_page, container, false);

        txtTotalPrice = view.findViewById(R.id.Txt_totalPrice);
        txtRemoveCart = view.findViewById(R.id.remove_cart);

        RVCartAdapter rVCartAdapter;
        recyclerView = view.findViewById(R.id.rcv_category);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        rVCartAdapter = new RVCartAdapter(getActivity(),Utils.cartBooks,this);
        recyclerView.setAdapter(rVCartAdapter);


        btnPayNow =view.findViewById(R.id.btn_paynow);
        btnPayNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String totalPrice = txtTotalPrice.getText().toString();
                Bundle bundle = new Bundle();
                bundle.putString("cart_totalPrice",totalPrice);
                PaymentPageWithCardFragment paymentPageWithCardFragment = new PaymentPageWithCardFragment();
                paymentPageWithCardFragment.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,paymentPageWithCardFragment).commit();
            }
        });

        cbCheckAll = view.findViewById(R.id.cbCheckAll);
        cbCheckAll.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(!shouldBeIgnore) {
                    rVCartAdapter.setCartPageCheckBoxChecked(isChecked);
                }
                else {
                    shouldBeIgnore = false;
                }
            }
        });

        txtRemoveCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i=0; i<Utils.cartBooks.size();i++) {
                    if(Utils.cartBooks.get(i).isShouldbeRemove()){
                        txtTotalPrice.setText("0 VNĐ");
                        if(Utils.cartBooks.size()>1) {
                            updateTotalPrice(Utils.cartBooks.get(i+1).getGia());
                        }
                        else {
                            Utils.dem--;
                        }
                        Utils.cartBooks.remove(i);
                        i--;
                    }
                }
                rVCartAdapter.updateListPrice(true);
                rVCartAdapter.setIsRemove(false);
            }
        });
        return  view;
    }

    public void onCheckedChanged(boolean isChecked, int position, String gia, int dem) {
        if(Utils.cartBooks.size()>0) {
            updateTotalPrice(gia);
            if(isChecked) {
                Utils.cartBooks.get(position).setShouldbeRemove(true);
            }
            else  {
                Utils.cartBooks.get(position).setShouldbeRemove(false);
                if(cbCheckAll.isChecked()) {
                    shouldBeIgnore = true;
                    cbCheckAll.setChecked(false);
                }
            }
        }


    }

    public void updateTotalPrice(String gia) {
        String numericValue = txtTotalPrice.getText().toString().replaceAll("[^0-9+-]", "");
        int currentPrice = Integer.parseInt(numericValue);
        String numericValue1 = gia.replaceAll("[^0-9+-]", "");
        int giaInt = Integer.parseInt(numericValue1);
        int newPrice = currentPrice +giaInt;
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        String formattedNumber = decimalFormat.format(newPrice);
        txtTotalPrice.setText(formattedNumber+" VNĐ");
    }

}