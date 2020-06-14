package com.study.guyu.androidstudy.ui.uiitem;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.study.guyu.androidstudy.R;

/**
 * @author 我的名字
 * @package com.study.guyu.androidstudy.ui.uiitem
 * @date 2020/2/5 21:29
 * @describe TODO
 * @project
 */
public class CheckBoxActivity extends ActionBarActivity {
    private CheckBox mCb4,mCb5,mCb6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkbox);
        mCb4= (CheckBox) findViewById(R.id.cb_4);
        mCb5= (CheckBox) findViewById(R.id.cb_5);
        mCb6= (CheckBox) findViewById(R.id.cb_6);

        mCb4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Toast.makeText(CheckBoxActivity.this,b?"篮球被选中":"篮球未选中",Toast.LENGTH_SHORT).show();
            }
        });
        mCb5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Toast.makeText(CheckBoxActivity.this,b?"做饭被选中":"做饭未选中",Toast.LENGTH_SHORT).show();
            }
        });
        mCb6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Toast.makeText(CheckBoxActivity.this,b?"学习被选中":"学习未选中",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
