package com.study.guyu.androidstudy.activity;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.study.guyu.androidstudy.R;

public class BActivity extends ActionBarActivity {

    private  TextView mTextView;
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);

        mTextView= (TextView) findViewById(R.id.tv_title);
        mButton= (Button) findViewById(R.id.btn_finish);

        Bundle bundle=getIntent().getExtras();
        String name=bundle.getString("name");
        int number=bundle.getInt("number");

        mTextView.setText(name+","+number);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                Bundle bundle1=new Bundle();
                bundle1.putString("title","我回来啦");
                intent.putExtras(bundle1);
                setResult(RESULT_OK,intent);
                finish();

            }
        });

    }
}
