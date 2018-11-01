package com.project.tank.outmove.activity;

import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.project.tank.outmove.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * @description: 启动页
 * @auther linweijie
 * @time 2018/10/31 14:24
 */

public class LaunchActivity extends BaseActivity{

    @Bind(R.id.wbText)
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_luancher);
        ButterKnife.bind(this);
        initWebView();

    }

    private void initWebView(){
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webView.getSettings().setSupportMultipleWindows(true);
        webView.setWebViewClient(new WebViewClient());
        webView.setWebChromeClient(new WebChromeClient());
        webView.loadUrl("http://www.baidu.com");
    }
}
