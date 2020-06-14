package com.study.guyu.androidstudy.ui.uiitem;

import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Html;
import android.widget.Button;
import android.widget.TextView;

import com.study.guyu.androidstudy.R;

/**
 * @author 我的名字
 * @package com.study.guyu.androidstudy.ui.uiitem
 * @date 2020/2/5 20:58
 * @describe TODO
 * @project
 */
public class TextViewActivity extends ActionBarActivity {

    private TextView mTv4;
    private TextView mTv5;
    private TextView mTv7;
    private TextView mTv8;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_textview);
        mTv4= (TextView) findViewById(R.id.tv_4);
        mTv5= (TextView) findViewById(R.id.tv_5);
        mTv7= (TextView) findViewById(R.id.tv_7);
        mTv8= (TextView) findViewById(R.id.tv_8);

        mTv4.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);//设置中划线
        mTv4.getPaint().setAntiAlias(true);//去除锯齿

        //这个显示不了，所以在drawable下面建了一个text_underline.xml来实现
        mTv5.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG ); //下划线
        mTv4.getPaint().setAntiAlias(true);//去除锯齿

        mTv7.setText("哈哈哈哈");
        mTv8.setText(Html.fromHtml("<u>html设置text内容</u>"));

    }
}
