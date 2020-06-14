package com.study.guyu.androidstudy.storage;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.study.guyu.androidstudy.R;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutActivity extends ActionBarActivity {
    private EditText mEtName;
    private Button mBtnSave,mBtnShow;
    private TextView mTvContent;
    private final String mFilename="test.txt";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_out);

        mEtName= (EditText) findViewById(R.id.et_name);
        mBtnSave= (Button) findViewById(R.id.btn_save);
        mBtnShow= (Button) findViewById(R.id.btn_show);
        mTvContent= (TextView) findViewById(R.id.tv_content);


        mBtnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                save(mEtName.getText().toString());

            }
        });
        mBtnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTvContent.setText(read());
            }
        });
    }

    //存储数据
    private void save(String content){
        FileOutputStream fileOutputStream=null;
        try{
//            fileOutputStream=openFileOutput(mFilename,MODE_PRIVATE);
            File dir=new File(Environment.getExternalStorageDirectory(),"guyu");
            if (!dir.exists()){
                dir.mkdirs();
            }
            File file=new File(dir,mFilename);
            if (!file.exists()){
                file.createNewFile();
            }
            fileOutputStream=new FileOutputStream(file);

            fileOutputStream.write(content.getBytes());
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if (fileOutputStream!=null){
                try{
                    fileOutputStream.close();
                }catch (IOException e){
                    e.printStackTrace();
                }

            }

        }
    }
    //读取数据
    private String read(){
        FileInputStream fileInputStream=null;
        try {
//            fileInputStream=openFileInput(mFilename);

            File file=new File(Environment.getExternalStorageDirectory().getAbsolutePath()+File.separator+"guyu",mFilename);
            fileInputStream=new FileInputStream(file);

            byte[] buff=new byte[1024];
            StringBuffer sb=new StringBuffer("");
            int len=0;
            while((len=fileInputStream.read(buff))>0){
                sb.append(new String(buff,0,len));
            }
            return sb.toString();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if (fileInputStream!=null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
