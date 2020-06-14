package com.study.guyu.androidstudy.ui.uiitem;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.study.guyu.androidstudy.R;

/**
 * @author 我的名字
 * @package com.study.guyu.androidstudy.ui.uiitem
 * @date 2020/2/5 21:27
 * @describe TODO
 * @project
 */
public class RadioButtonActivity extends ActionBarActivity{
    private RadioGroup mRg_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radiobutton);
        mRg_1= (RadioGroup) findViewById(R.id.rg_1);
        mRg_1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){

            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton radioButton= (RadioButton) radioGroup.findViewById(i);
                Toast.makeText(RadioButtonActivity.this,radioButton.getText(),Toast.LENGTH_SHORT).show();

            }
        });
    }
}
