package com.study.guyu.androidstudy.storage;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.study.guyu.androidstudy.R;

public class StorageActivity extends ActionBarActivity implements View.OnClickListener{


    private Button mSharedPre,mFile,mFileOut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storage);

        mSharedPre= (Button) findViewById(R.id.btn_sharedpreferences);
        mFile= (Button) findViewById(R.id.btn_file);
        mFileOut= (Button) findViewById(R.id.btn_fileout);

        mSharedPre.setOnClickListener(this);
        mFile.setOnClickListener(this);
        mFileOut.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent=null;
        switch (view.getId()){
            case R.id.btn_sharedpreferences:
                intent=new Intent(StorageActivity.this,SharedPreferenceActivity.class);
                break;
            case R.id.btn_fileout:
                intent=new Intent(StorageActivity.this,FileOutActivity.class);
                break;
            case R.id.btn_file:
                intent=new Intent(StorageActivity.this,FileActivity.class);
                break;
        }

        startActivity(intent);

    }
}
