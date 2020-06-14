package com.study.guyu.androidstudy.storage;

import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.study.guyu.androidstudy.R;

public class SharedPreferenceActivity extends ActionBarActivity {
    private EditText mEtName;
    private Button mBtnSave,mBtnShow;
    private TextView mTvContent;
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preference);

        mEtName= (EditText) findViewById(R.id.et_name);
        mBtnSave= (Button) findViewById(R.id.btn_save);
        mBtnShow= (Button) findViewById(R.id.btn_show);
        mTvContent= (TextView) findViewById(R.id.tv_content);

        mSharedPreferences=getSharedPreferences("data",MODE_PRIVATE);//这里设置的私有的权限，一般都这么设置
        mEditor=mSharedPreferences.edit();

        mBtnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mEditor.putString("name",mEtName.getText().toString());
                mEditor.apply();//这是异步提交
//                mEditor.commit();这是同步提交
            }
        });
        mBtnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTvContent.setText(mSharedPreferences.getString("name",""));
            }
        });
    }
}
