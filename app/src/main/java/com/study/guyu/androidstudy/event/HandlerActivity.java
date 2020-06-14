package com.study.guyu.androidstudy.event;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;

import com.study.guyu.androidstudy.R;
import com.study.guyu.androidstudy.util.ToastUtil;


public class HandlerActivity extends ActionBarActivity {

    private Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);

        //延迟3秒跳转到event activity
//        mHandler=new Handler();
//        mHandler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                Intent intent=new Intent(HandlerActivity.this,EventActivity.class);
//                startActivity(intent);
//            }
//        }, 3000);
        mHandler=new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);

                switch (msg.what){
                    case 1:
                        ToastUtil.showMsg(HandlerActivity.this,"线程通信成功");
                        break;
                }
            }
        };

        new Thread(){
            @Override
            public void run() {
                super.run();

                Message message=new Message();
                message.what=1;
                mHandler.sendMessage(message);

            }
        }.start();
    }
}
