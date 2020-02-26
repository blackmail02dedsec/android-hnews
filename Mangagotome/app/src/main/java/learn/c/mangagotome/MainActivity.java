package learn.c.mangagotome;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Window;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends Activity {
    protected WebView mainView;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        mainView = findViewById(R.id.webPage);
        mainView.getSettings().setJavaScriptEnabled(true);
        setDesktopMode(mainView);

        mainView.setWebViewClient(new WebViewClient(){
            public void onReceivedError(WebView mWebView, int errorCode, String description, String failingUrl) {
                try {
                    mainView.stopLoading();
                } catch (Exception ignored) {
                }

                if(mainView.canGoBack()) {
                    mainView.goBack();
                }

                mWebView.loadUrl("about:blank");
                AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                alertDialog.setTitle("Error");
                alertDialog.setMessage("Check your internet connection and try again");
                alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "Try Again", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        callUrl();
                    }
                });
                alertDialog.show();
                super.onReceivedError(mWebView, errorCode, description, failingUrl);
            }
        });
        callUrl();
    }

    public void setDesktopMode(WebView webView) {
        String newUserAgent = webView.getSettings().getUserAgentString();
        try {
            String ua = webView.getSettings().getUserAgentString();
            String androidOSString = webView.getSettings().getUserAgentString().substring(ua.indexOf("("), ua.indexOf(")") + 1);
            newUserAgent = webView.getSettings().getUserAgentString().replace(androidOSString, "(X11; Linux x86_64)");
        } catch (Exception e) {
            e.printStackTrace();
        }
        webView.getSettings().setUserAgentString(newUserAgent);
        webView.getSettings().setUseWideViewPort(true);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.reload();
    }

    protected void callUrl() {
        mainView.loadUrl("https://mangago.me");
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
