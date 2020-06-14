package com.study.guyu.androidstudy.activity;

import android.content.ComponentName;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.study.guyu.androidstudy.R;

public class AActivity extends ActionBarActivity {

    private Button mButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);

        mButton= (Button) findViewById(R.id.btn_jump);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //显式1
                Intent intent = new Intent(AActivity.this, BActivity.class);

                Bundle bundle=new Bundle();
                bundle.putString("name","谷雨");
                bundle.putInt("number",88);

                intent.putExtras(bundle);

//                startActivity(intent);
                startActivityForResult(intent,0);//这里b页面返回后可携带返回值，0是请求状态吗，用来区分其他的
                //显式2
//                Intent intent=new Intent();
//                intent.setClass(AActivity.this,BActivity.class);
//                startActivity(intent);
                //显式3
//                Intent intent=new Intent();
//                intent.setClassName(AActivity.this,"com.study.guyu.androidstudy.activity.BActivity");
//                startActivity(intent);
//                //显式4
//                Intent intent=new Intent();
//                intent.setComponent(new ComponentName(AActivity.this, "com.study.guyu.androidstudy.activity.BActivity"));
//                startActivity(intent);
                //隐式
//                Intent intent=new Intent();
//                intent.setAction("com.guyu.test.BActivity");
//                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Toast.makeText(AActivity.this,data.getExtras().getString("title"),Toast.LENGTH_LONG).show();
    }
}
