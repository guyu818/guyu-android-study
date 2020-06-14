package com.study.guyu.androidstudy;

import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.study.guyu.androidstudy.activity.ActActivity;
import com.study.guyu.androidstudy.animation.AnimationActivity;
import com.study.guyu.androidstudy.broadcast.BroadActivity;
import com.study.guyu.androidstudy.event.EventActivity;
import com.study.guyu.androidstudy.fragment.ContainerActivity;
import com.study.guyu.androidstudy.ripple.RippleActivity;
import com.study.guyu.androidstudy.storage.StorageActivity;
import com.study.guyu.androidstudy.ui.UiActivity;

public class MainActivity extends ActionBarActivity {

    private Button mBtnUi;
    private Button mBtnAct;
    private Button mBtnThing;
    private Button mBtnStore;
    private Button mBtnAni;
    private Button mBtnWater;
    private Button mBtnFragment;
    private Button mBroad;
    private Button mYiQing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnUi= (Button) findViewById(R.id.bg_ui);
        mBtnAct= (Button) findViewById(R.id.bg_act);
        mBtnAni= (Button) findViewById(R.id.bg_animation);
        mBtnStore= (Button) findViewById(R.id.bg_store);
        mBtnThing= (Button) findViewById(R.id.bg_thing);
        mBtnWater= (Button) findViewById(R.id.bg_water);
        mBtnFragment= (Button) findViewById(R.id.bg_fragment);
        mBroad= (Button) findViewById(R.id.bg_broad);
        mYiQing= (Button) findViewById(R.id.bg_yiqing);

        //此处的监听事件较多，所以用下面的形式来写
        /*mBtnUi.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //跳转到ui组件教学界面
                Intent intent=new Intent(MainActivity.this, UiActivity.class);
                startActivity(intent);
            }
        });*/
        setListeners();


    }
    private  void setListeners(){
        OnClick onClick=new OnClick();
        mBtnUi.setOnClickListener(onClick);
//        mBtnWater.setOnClickListener(onClick);
        mBtnThing.setOnClickListener(onClick);
        mBtnStore.setOnClickListener(onClick);
        mBtnAct.setOnClickListener(onClick);
        mBtnAni.setOnClickListener(onClick);
        mBtnFragment.setOnClickListener(onClick);
        mBroad.setOnClickListener(onClick);
        mYiQing.setOnClickListener(onClick);
    }
    /*
    自定义点击事件函数来监听点击事件，实现view.onclicklistener
     */
    private class  OnClick implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            Intent intent=null;
            switch (view.getId()){
                case R.id.bg_ui:
                    intent=new Intent(MainActivity.this, UiActivity.class);
                    break;
                case R.id.bg_act:
                    intent=new Intent(MainActivity.this, ActActivity.class);
                    break;
                case R.id.bg_thing:
                    intent=new Intent(MainActivity.this, EventActivity.class);
                    break;
                case R.id.bg_store:
                    intent=new Intent(MainActivity.this, StorageActivity.class);
                    break;
                case R.id.bg_animation:
                    intent=new Intent(MainActivity.this, AnimationActivity.class);
                    break;
//                case R.id.bg_water:
//                    intent=new Intent(MainActivity.this, RippleActivity.class);
//                    break;
                case R.id.bg_fragment:
                    intent=new Intent(MainActivity.this, ContainerActivity.class);
                    break;
                case R.id.bg_broad:
                    intent=new Intent(MainActivity.this, BroadActivity.class);
                    break;
                case R.id.bg_yiqing:
                    intent=new Intent(MainActivity.this,YiQingActivity.class);
                    break;

            }
            startActivity(intent);
        }
    }

}
