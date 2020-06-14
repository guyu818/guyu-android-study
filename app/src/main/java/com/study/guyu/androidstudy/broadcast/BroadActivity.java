package com.study.guyu.androidstudy.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.study.guyu.androidstudy.R;

public class BroadActivity extends ActionBarActivity {
    private Button mButton;
    private TextView mTextView;
    private MyBroadcast mMyBroadcast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broad);

        mButton= (Button) findViewById(R.id.btn1);
        mTextView= (TextView) findViewById(R.id.tv_test);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(BroadActivity.this,Broad2Activity.class);
                startActivity(intent);
            }
        });

        mMyBroadcast=new MyBroadcast();
        IntentFilter intentFilter=new IntentFilter();
        intentFilter.addAction("guyu");//根据这个标签过滤接受的广播
        LocalBroadcastManager.getInstance(this).registerReceiver(mMyBroadcast,intentFilter);
    }

    private class MyBroadcast extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            switch (intent.getAction()){
                case "guyu":
                    mTextView.setText("广播完成");
                    break;
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(mMyBroadcast);//取消注册，记住要写
    }
}
