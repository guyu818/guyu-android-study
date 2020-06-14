package com.study.guyu.androidstudy.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.study.guyu.androidstudy.R;

/**
 * @author 我的名字
 * @package com.study.guyu.androidstudy.activity
 * @date 2020/2/5 16:58
 * @describe TODO
 * @project
 */
public class ActActivity extends ActionBarActivity {
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act);

        Log.d("lifecycle", "----oncreate---");

        mButton= (Button) findViewById(R.id.btn_act);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActActivity.this, AActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("lifecycle", "----onStart---");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("lifecycle", "----onResume---");
        //电话接完了重新回来做事
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("lifecycle", "----onPause---");
        //突然来了个电话，会执行这个
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("lifecycle", "----onStop---");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("lifecycle", "----onRestart---");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("lifecycle", "----onDestroy---");
    }
}
