package com.solarexsoft.scrollviewwebviewdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

/**
 * Created by houruhou on 2018/4/25.
 */

public class TestActivity extends AppCompatActivity {
    String imgsrc = "http://pub-1251962406.file.myqcloud" +
            ".com/skylight/resources/4c0475ed-0816-449b-8569-d7e02164307a.png";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test4);
        final ImageView iv = findViewById(R.id.iv);
        WebView webView = findViewById(R.id.webview);
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return super.shouldOverrideUrlLoading(view, url);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                String js = "var appendDiv = document.createElement('div');document.body.prepend(appendDiv);appendDiv.innerHTML='<div><img src=\"http://pub-1251962406.file.myqcloud.com/skylight/resources/4c0475ed-0816-449b-8569-d7e02164307a.png\" width=\"100%%\" height=\"auto\"></div>';";
//                String js = "var appenddiv = document.createElement('div');appenddiv.innerHTML='<div style=\"width:100px; height:100px; background-color:#666; z-index:1\"></div>'; document.body.prepend(appenddiv);";
                view.loadUrl("javascript:" + js);
                iv.animate().alpha(0).setStartDelay(2000).setDuration(200).start();
            }
        });
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setAllowFileAccess(true);
        webSettings.setSupportZoom(false);
        webSettings.setBuiltInZoomControls(false);
        webSettings.setUseWideViewPort(true);
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setBlockNetworkImage(false);
//        webView.loadUrl("https://main.icarbonx.com/mallMicro/2000126");
        webView.loadUrl("http://www.baidu.com");
    }
}
