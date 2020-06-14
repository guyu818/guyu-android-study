package com.study.guyu.androidstudy.ui.uiitem;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.study.guyu.androidstudy.R;

/**
 * @author 我的名字
 * @package com.study.guyu.androidstudy.ui.uiitem
 * @date 2020/2/5 21:17
 * @describe TODO
 * @project
 */
public class ButtonActivity extends ActionBarActivity {

    private Button mBt_3;
    private TextView mTv_1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);
        mBt_3= (Button) findViewById(R.id.bt_3);
        mTv_1= (TextView) findViewById(R.id.tv_1);
        mBt_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ButtonActivity.this,"button3被点击了",Toast.LENGTH_SHORT).show();
            }
        });
        mTv_1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Toast.makeText(ButtonActivity.this,"textview也被点击了",Toast.LENGTH_SHORT).show();
            }
        });
    }
    //这里不可以设置成private类型的，不然会闪退，这个点击事件的函数时在xml文件的控件中声明的
    public  void showToast(View view){
        Toast.makeText(this,"button4被点击了",Toast.LENGTH_SHORT).show();
    }
}
