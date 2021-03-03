package com.example.testapp2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class WebView extends AppCompatActivity {

    android.webkit.WebView webView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        webView  = findViewById(R.id.webview);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        webView.setWebViewClient(new MyWebViewClient());

        Bundle extras = getIntent().getExtras();
        int position = extras.getInt("position");


        switch(position){
            case 4:
                webView.loadUrl("https://antio.ru/index.php?showforum=300");
                break;
            case 5:
                webView.loadUrl("https://antio.ru/index.php?showforum=542");
                break;
        }
        @Nullable String method = extras.getString("method");
        if (method != null){
            switch (method){
                case "m00":
                    webView.loadUrl("file:///android_asset/methods/m00.html");
                    break;
                case "m01":
                    webView.loadUrl("file:///android_asset/methods/m01.html");
                    break;
                case "m10":
                    webView.loadUrl("file:///android_asset/methods/m10.html");
                    break;
                case "m11":
                    webView.loadUrl("file:///android_asset/methods/m11.html");
                    break;
                case "m12":
                    webView.loadUrl("file:///android_asset/methods/m12.html");
                    break;
                case "m13":
                    webView.loadUrl("file:///android_asset/methods/m13.html");
                    break;
                case "m14":
                    webView.loadUrl("file:///android_asset/methods/m14.html");
                    break;
                case "m15":
                    webView.loadUrl("file:///android_asset/methods/m15.html");
                    break;
                case "m16":
                    webView.loadUrl("file:///android_asset/methods/m16.html");
                    break;
                case "m17":
                    webView.loadUrl("file:///android_asset/methods/m17.html");
                    break;
                case "m18":
                    webView.loadUrl("file:///android_asset/methods/m18.html");
                    break;
                case "m19":
                    webView.loadUrl("file:///android_asset/methods/m19.html");
                    break;
                case "m20":
                    webView.loadUrl("file:///android_asset/methods/m20.html");
                    break;
                case "m21":
                    webView.loadUrl("file:///android_asset/methods/m21.html");
                    break;
                case "m22":
                    webView.loadUrl("file:///android_asset/methods/m22.html");
                    break;
                case "m23":
                    webView.loadUrl("file:///android_asset/methods/m23.html");
                    break;
                case "m24":
                    webView.loadUrl("file:///android_asset/methods/m24.html");
                    break;
                case "m25":
                    webView.loadUrl("file:///android_asset/methods/m25.html");
                    break;
                case "m26":
                    webView.loadUrl("file:///android_asset/methods/m26.html");
                    break;

            }

        }







    }
    @Override
    public void onBackPressed() {
        if(webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }

    private class MyWebViewClient extends WebViewClient {

        @TargetApi(Build.VERSION_CODES.N)
        @Override
        public boolean shouldOverrideUrlLoading(android.webkit.WebView view, WebResourceRequest request) {
            view.loadUrl(request.getUrl().toString());
            return true;
        }

        // Для старых устройств
        @Override
        public boolean shouldOverrideUrlLoading(android.webkit.WebView view, String url) {
            view.loadUrl(url);
            return true;
        }


}}