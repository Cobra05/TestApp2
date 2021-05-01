package com.example.testapp2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebViewClient;


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
                case "m30":
                    webView.loadUrl("file:///android_asset/methods/m30.html");
                    break;
                case "m31":
                    webView.loadUrl("file:///android_asset/methods/m31.html");
                    break;
                case "m32":
                    webView.loadUrl("file:///android_asset/methods/m32.html");
                    break;
                case "m33":
                    webView.loadUrl("file:///android_asset/methods/m33.html");
                    break;
                case "m34":
                    webView.loadUrl("file:///android_asset/methods/m34.html");
                    break;
                case "m35":
                    webView.loadUrl("file:///android_asset/methods/m35.html");
                    break;
                case "m40":
                    webView.loadUrl("file:///android_asset/methods/m40.html");
                    break;
                case "m41":
                    webView.loadUrl("file:///android_asset/methods/m41.html");
                    break;
                case "m42":
                    webView.loadUrl("file:///android_asset/methods/m42.html");
                    break;
                case "m43":
                    webView.loadUrl("file:///android_asset/methods/m43.html");
                    break;
                case "m44":
                    webView.loadUrl("file:///android_asset/methods/m44.html");
                    break;
                case "m50":
                    webView.loadUrl("file:///android_asset/methods/m50.html");
                    break;
                case "m51":
                    webView.loadUrl("file:///android_asset/methods/m51.html");
                    break;
                case "m52":
                    webView.loadUrl("file:///android_asset/methods/m52.html");
                    break;
                case "m53":
                    webView.loadUrl("file:///android_asset/methods/m53.html");
                    break;
                case "m54":
                    webView.loadUrl("file:///android_asset/methods/m54.html");
                    break;
                case "m60":
                    webView.loadUrl("file:///android_asset/methods/m60.html");
                    break;
                case "m61":
                    webView.loadUrl("file:///android_asset/methods/m61.html");
                    break;
                case "m62":
                    webView.loadUrl("file:///android_asset/methods/m62.html");
                    break;
                case "m63":
                    webView.loadUrl("file:///android_asset/methods/m63.html");
                    break;
                case "m64":
                    webView.loadUrl("file:///android_asset/methods/m64.html");
                    break;
                case "m65":
                    webView.loadUrl("file:///android_asset/methods/m65.html");
                    break;
                case "m66":
                    webView.loadUrl("file:///android_asset/methods/m66.html");
                    break;
                case "m70":
                    webView.loadUrl("file:///android_asset/methods/m70.html");
                    break;
                case "m71":
                    webView.loadUrl("file:///android_asset/methods/m71.html");
                    break;
                case "m72":
                    webView.loadUrl("file:///android_asset/methods/m72.html");
                    break;

            }
        }

        @Nullable String type = extras.getString("type");
        if (type != null) {
            int id = extras.getInt("id");
            if (type.equals("vred")){
                switch (id) {
                    case 0:
                        webView.loadUrl("file:///android_asset/information/vred/v0.html");
                        break;
                    case 1:
                        webView.loadUrl("file:///android_asset/information/vred/v1.html");
                        break;
                    case 2:
                        webView.loadUrl("file:///android_asset/information/vred/v2.html");
                        break;
                    case 3:
                        webView.loadUrl("file:///android_asset/information/vred/v3.html");
                        break;
                    case 4:
                        webView.loadUrl("file:///android_asset/information/vred/v4.html");
                        break;
                    case 5:
                        webView.loadUrl("file:///android_asset/information/vred/v5.html");
                        break;
                    case 6:
                        webView.loadUrl("file:///android_asset/information/vred/v6.html");
                        break;
                    case 7:
                        webView.loadUrl("file:///android_asset/information/vred/v7.html");
                        break;
                    case 8:
                        webView.loadUrl("file:///android_asset/information/vred/v8.html");
                        break;
                    case 9:
                        webView.loadUrl("file:///android_asset/information/vred/v9.html");
                        break;
                }
            }else if(type.equals("polza")){
                switch (id) {
                    case 0:
                        webView.loadUrl("file:///android_asset/information/polza/p0.html");
                        break;
                    case 1:
                        webView.loadUrl("file:///android_asset/information/polza/p1.html");
                        break;
                    case 2:
                        webView.loadUrl("file:///android_asset/information/polza/p2.html");
                        break;
                    case 3:
                        webView.loadUrl("file:///android_asset/information/polza/p3.html");
                        break;
                    case 4:
                        webView.loadUrl("file:///android_asset/information/polza/p4.html");
                        break;
                    case 5:
                        webView.loadUrl("file:///android_asset/information/polza/p5.html");
                        break;
                    case 6:
                        webView.loadUrl("file:///android_asset/information/polza/p6.html");
                        break;
                    case 7:
                        webView.loadUrl("file:///android_asset/information/polza/p7.html");
                        break;
                }
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