package com.study.guyu.androidstudy.ui.uiitem;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.study.guyu.androidstudy.R;

/**
 * @author 我的名字
 * @package com.study.guyu.androidstudy.ui.uiitem
 * @date 2020/2/5 21:38
 * @describe TODO
 * @project
 */
public class WebViewActivity extends ActionBarActivity {

    private WebView mWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview);

        mWebView= (WebView) findViewById(R.id.wv_1);

        //加载本地的html文件，该文件在assets文件夹下
        //mWebView.loadUrl("file:///android_asset/test.html");

        //加载网络url
        //必须设置js支持才会显示百度页面
        mWebView.getSettings().setJavaScriptEnabled(true);
        //对软件内的一些浏览器进行设置
        mWebView.setWebViewClient(new MyWebViewClient());
        mWebView.setWebChromeClient(new MyWebChromeClient());//这里面可以设置进度条和标题
        //mWebView.addJavascriptInterface();                 //实现了native和js通信
       mWebView.loadUrl("https://m.baidu.com");
    }

    /*
    另一种方式
     */
    class MyWebChromeClient extends WebChromeClient{

        //这里的newproghress从0到100,可以用于进度条处理
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            super.onProgressChanged(view, newProgress);
        }

        //这里获取标题，如百度网址的源码的title标签的标题就是百度一下
        @Override
        public void onReceivedTitle(WebView view, String title) {
            super.onReceivedTitle(view, title);

            //设置最上面的label的标题
            setTitle(title);
        }
    }

    /*
    一种方式
     */
    class MyWebViewClient extends WebViewClient{
//
        //这个函数是防止软件跳转到外部的浏览器,这个函数已经被废弃掉了（但是还是可以用的），新的将参数string url变成了webresourcerequest request
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            //如果是新版的写成这样
           // view.loadUrl(request.geturl.tostring);
            return true;
        }
        //加载页面开始的函数
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            Log.d("WebView", "onPageStarted....");
           // mWebView.loadUrl("javascript:alert('hello')");                  //利用native弹出对话框，这里是用js实现的
            //mWebView.evaluateJavascript("javascript:alert('hello')",null);  //利用native弹出对话框，这里是用js实现的,另一种方式
        }

        //加载页面结束的函数
        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            Log.d("WebView", "onPageFinished....");
        }
    }

    //这里重写是返回上一级，而不是直接退出浏览器
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK && mWebView.canGoBack()){
            mWebView.goBack();
            return  true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
