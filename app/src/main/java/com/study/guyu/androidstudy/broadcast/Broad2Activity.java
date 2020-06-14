package com.study.guyu.androidstudy.broadcast;

import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.study.guyu.androidstudy.R;

public class Broad2Activity extends ActionBarActivity {

    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broad2);

        mButton= (Button) findViewById(R.id.btn_click);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent("guyu");
                LocalBroadcastManager.getInstance(Broad2Activity.this).sendBroadcast(intent);
            }
        });
    }
}
