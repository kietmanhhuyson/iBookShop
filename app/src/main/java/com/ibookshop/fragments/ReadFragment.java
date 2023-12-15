package com.ibookshop.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageButton;

import com.ibookshop.R;

public class ReadFragment extends Fragment {
    ImageButton imgbtn;
    WebView webView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_read, container, false);
        imgbtn = (ImageButton) view.findViewById(R.id.mdi_arrow_l);
        webView = (WebView) view.findViewById(R.id.webview_read);
        // Lấy dữ liệu từ Bundle
        Bundle bundle = getArguments();
        if (bundle != null) {
            String url = bundle.getString("url", "");
            loadUrl(url);
        }
        imgbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new myBookFragment()).commit();
            }
        });
        return view;
    }
    private void loadUrl(String url) {
        // Cấu hình WebView và load URL
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.loadUrl(url);
    }
}