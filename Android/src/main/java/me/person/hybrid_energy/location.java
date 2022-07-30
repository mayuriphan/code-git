package me.person.hybrid_energy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class location extends AppCompatActivity {
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        webView= (WebView) findViewById(R.id.wv);
        webView.setWebViewClient(new WebViewClient());

        webView.getSettings().setJavaScriptEnabled(true);

        webView.loadUrl("https://www.google.com/maps/place/Charles+W.+Davidson+College+of+Engineering/@37.3363948,-121.8831946,18z/data=!4m8!1m2!2m1!1sengineering+building+sjsu!3m4!1s0x808fccbf9c49ae69:0x33714fc7762af269!8m2!3d37.3370744!4d-121.8815886");


    }

}
