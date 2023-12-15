package com.ibookshop.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.ibookshop.R;

import java.io.IOException;
import java.io.InputStream;

public class ShowXML extends AppCompatActivity {

    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_xml);

        Intent intent = getIntent();
        String xmlContent = intent.getStringExtra("key_xmlContent");
        webView = findViewById(R.id.webView);

        displayXmlInWebView(xmlContent);
    }


    private void displayXmlInWebView(String xmlContent) {
        // Kích hoạt JavaScript trong WebView (nếu cần thiết)
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        // Đặt WebViewClient để xử lý các sự kiện khi người dùng click các liên kết
        webView.setWebViewClient(new WebViewClient());

        // Hiển thị nội dung XML trong WebView
        webView.loadDataWithBaseURL(null, xmlContent, "text/xml", "UTF-8", null);
    }
}