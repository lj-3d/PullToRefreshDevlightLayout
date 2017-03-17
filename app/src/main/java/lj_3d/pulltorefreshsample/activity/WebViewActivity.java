package lj_3d.pulltorefreshsample.activity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

/**
 * Created by liubomyr on 06.10.16.
 */

public class WebViewActivity extends PullToRefreshHeaderActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        initHeaderUI();
        final WebView pullToRefreshGridVieWebView = (WebView) findViewById(R.id.wv_pull_to_refresh);
        final WebSettings webSettings = pullToRefreshGridVieWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        pullToRefreshGridVieWebView.loadUrl("http://rozetka.com.ua");
    }

}
