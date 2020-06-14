package com.study.guyu.androidstudy.fragment;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.study.guyu.androidstudy.R;
import com.study.guyu.androidstudy.util.ToastUtil;

public class ContainerActivity extends ActionBarActivity implements AFragment.IOnMessageClick{
    private AFragment aFragment;
    private TextView mTextView;
   // private BFragment bFragment;
  //  private Button mBtnChange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);

        mTextView= (TextView) findViewById(R.id.tv_title);

//        mBtnChange= (Button) findViewById(R.id.btn_change);
//        mBtnChange.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                ToastUtil.showMsg(ContainerActivity.this,"hshahhshha");
//                if (bFragment == null) {
//                    bFragment = new BFragment();
//                }
//                getFragmentManager().beginTransaction().replace(R.id.fl_container,bFragment).commitAllowingStateLoss();
//            }
//        });
        //实例化Afragment
//        aFragment=new AFragment();
        //传参方式实例化AFragment
        aFragment=AFragment.newInstance("我是参数");

        //把Afragment添加到activity中，记得调用commit,不然报错
        getFragmentManager().beginTransaction().add(R.id.fl_container, aFragment, "A").commitAllowingStateLoss();
    }

    @Override
    public void onClick(String text) {
        mTextView.setText(text);
    }

    //fragment向activity传递消息的第一种方式
//    public void setData(String text){
//        mTextView.setText(text);
//    }
}
