package com.study.guyu.androidstudy.event;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.study.guyu.androidstudy.R;
import com.study.guyu.androidstudy.util.ToastUtil;

public class EventActivity extends ActionBarActivity implements View.OnClickListener{
    private Button mBtnEvent;
    private Button mBtnMy,mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        mBtnEvent= (Button) findViewById(R.id.btn_event);
        mBtnMy= (Button) findViewById(R.id.btn_my);
        mHandler= (Button) findViewById(R.id.btn_handler);
        //监听事件，多个监听同时声明的话则，最后一个有效

        //一、内部类实现
//        mBtnEvent.setOnClickListener(new OnClick());
        //二、匿名内部类
//        mBtnEvent.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                ToastUtil.showMsg(EventActivity.this,"匿名类click.....");
//            }
//        });
        //三、通过事件源所在的类实现
//        mBtnEvent.setOnClickListener(EventActivity.this);
        //四、通过外部类实现,最不常用
        mBtnEvent.setOnClickListener(new MyClickListener(EventActivity.this));
        //五、通过点击按钮设置事件，来实现

        //监听优先于回调
        mBtnMy.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        Log.d("listener", "-----onTouchEvent------");
                }
                return false;
            }
        });
        mHandler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(EventActivity.this,HandlerActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_event:
                ToastUtil.showMsg(EventActivity.this,"通过事件所在原的类实现click.....");
                break;
        }
    }

    //基于点击事件的实现，一、内部类实现
    class OnClick implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.btn_event:
                    ToastUtil.showMsg(EventActivity.this,"内部类click.....");
                    break;
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        super.onTouchEvent(event);
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                Log.d("eventactivity", "-----onTouchEvent------");
                break;
        }

        return false;
    }
}
