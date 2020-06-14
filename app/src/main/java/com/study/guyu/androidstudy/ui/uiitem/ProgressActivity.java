package com.study.guyu.androidstudy.ui.uiitem;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.study.guyu.androidstudy.R;
import com.study.guyu.androidstudy.util.ToastUtil;

/**
 * @author 我的名字
 * @package com.study.guyu.androidstudy.ui.uiitem
 * @date 2020/2/5 21:55
 * @describe TODO
 * @project
 */
public class ProgressActivity extends ActionBarActivity {
    private ProgressBar mPb3;
    private Button mButton,mProDialog1,mProDialog2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);

        mPb3= (ProgressBar) findViewById(R.id.pd3);
        //mPb3.setProgress(30); 这里进度为30%
        mButton= (Button) findViewById(R.id.btn_start);
        mProDialog1= (Button) findViewById(R.id.progress_dialog1);
        mProDialog2= (Button) findViewById(R.id.progress_dialog2);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mHandler.sendEmptyMessage(0);
            }
        });

        mProDialog1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProgressDialog progressDialog=new ProgressDialog(ProgressActivity.this);
                progressDialog.setTitle("提示");
                progressDialog.setMessage("正在加载");
                progressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialogInterface) {
                        ToastUtil.showMsg(ProgressActivity.this, "cancel....."); //cancel和dismiss的监听比较常用
                    }
                });
               // progressDialog.setCancelable(false); // 设置加载时点击其他的敌方不会消失
                progressDialog.show();
            }
        });

        mProDialog2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProgressDialog progressDialog=new ProgressDialog(ProgressActivity.this);
                progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);//水平进度条加载
                progressDialog.setTitle("提示");
                progressDialog.setMessage("正在加载》》》");
                progressDialog.setButton(DialogInterface.BUTTON_POSITIVE, "棒", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //这里可以设置一些点击之后处理的动作
                    }
                });
                progressDialog.show();
            }
        });
    }

    Handler mHandler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(mPb3.getProgress()<100){
                mHandler.postDelayed(mRunnable,500);//延迟500ms,发送消息
            }else{
                ToastUtil.showMsg(ProgressActivity.this,"加载完成");
            }
        }
    };

    Runnable mRunnable=new Runnable() {
        @Override
        public void run() {
            mPb3.setProgress(mPb3.getProgress()+5);
            mHandler.sendEmptyMessage(0);
        }
    };
}
