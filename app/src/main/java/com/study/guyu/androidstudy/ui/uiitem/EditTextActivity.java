package com.study.guyu.androidstudy.ui.uiitem;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.study.guyu.androidstudy.R;

/**
 * @author 我的名字
 * @package com.study.guyu.androidstudy.ui.uiitem
 * @date 2020/2/5 21:24
 * @describe TODO
 * @project
 */
public class EditTextActivity extends ActionBarActivity {

    private Button mBt_login;
    private EditText mEd_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edittext);
        mBt_login= (Button) findViewById(R.id.bt_login);
        mEd_1= (EditText) findViewById(R.id.ed_1);
        mBt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(EditTextActivity.this,"登陆成功",Toast.LENGTH_SHORT).show();
            }
        });
        mEd_1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Log.d("edittext",charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
}
