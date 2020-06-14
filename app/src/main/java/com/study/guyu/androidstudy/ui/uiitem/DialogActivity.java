package com.study.guyu.androidstudy.ui.uiitem;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.study.guyu.androidstudy.R;
import com.study.guyu.androidstudy.ui.uiitem.widget.CustomDialog;

/**
 * @author 我的名字
 * @package com.study.guyu.androidstudy.ui.uiitem
 * @date 2020/2/5 21:54
 * @describe TODO
 * @project
 */
public class DialogActivity extends ActionBarActivity {

    private Button mButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog);

        mButton= (Button) findViewById(R.id.btn_custom_dialog);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CustomDialog customDialog=new CustomDialog(DialogActivity.this,R.style.CustomDialog);
                customDialog.setTitle("提示").setMessage("确认删除此项")
                        .setCancel("取消", new CustomDialog.IOnCancelListener() {
                            @Override
                            public void onCancel(CustomDialog dialog) {

                            }
                        }).setConfirm("确定", new CustomDialog.IOnConfirmListener() {
                    @Override
                    public void onConfirm(CustomDialog dialog) {

                    }
                }).show();

                //Toast.makeText(DialogActivity.this,"dajduahdhau",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
