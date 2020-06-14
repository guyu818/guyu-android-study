package com.study.guyu.androidstudy.ui.uiitem;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.study.guyu.androidstudy.R;
import com.study.guyu.androidstudy.util.ToastUtil;

/**
 * @author 我的名字
 * @package com.study.guyu.androidstudy.ui.uiitem
 * @date 2020/2/5 21:52
 * @describe TODO
 * @project
 */
public class AlertDialogActivity extends ActionBarActivity {

    private Button mBtnDialog1,mBtnDialog2,mBtnDialog4,mBtnDialog3,mBtnDialog5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alertdialog);

        mBtnDialog1= (Button) findViewById(R.id.btn_dialog1);
        mBtnDialog2= (Button) findViewById(R.id.btn_dialog2);
        mBtnDialog3= (Button) findViewById(R.id.btn_dialog3);
        mBtnDialog4= (Button) findViewById(R.id.btn_dialog4);
        mBtnDialog5= (Button) findViewById(R.id.btn_dialog5);
        setListeners();
    }

    public void setListeners(){
        OnClick onClick=new OnClick();
        mBtnDialog1.setOnClickListener(onClick);
        mBtnDialog2.setOnClickListener(onClick);
        mBtnDialog3.setOnClickListener(onClick);
        mBtnDialog4.setOnClickListener(onClick);
        mBtnDialog5.setOnClickListener(onClick);
    }
    class OnClick implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.btn_dialog1:
                    AlertDialog.Builder builder=new AlertDialog.Builder(AlertDialogActivity.this);
                    builder.setTitle("请回答：").setMessage("你觉得课程怎么样")
                            .setIcon(R.drawable.username)
                            .setPositiveButton("棒", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    ToastUtil.showMsg(AlertDialogActivity.this, "你很诚实");
                                }
                            }).setNeutralButton("还行", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            ToastUtil.showMsg(AlertDialogActivity.this,"你再瞅瞅");
                        }
                    }).setNegativeButton("差", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            ToastUtil.showMsg(AlertDialogActivity.this,"睁眼说瞎话");
                        }
                    }).show();
                    break;
                case R.id.btn_dialog2:
                    final String[] array2=new String[]{"男","女"};
                    AlertDialog.Builder builder1=new AlertDialog.Builder(AlertDialogActivity.this);
                    builder1.setTitle("请选择性别").setItems(array2, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            ToastUtil.showMsg(AlertDialogActivity.this,array2[i]);
                        }
                    }).show();
                    break;
                case R.id.btn_dialog3:
                    final String[] array3=new String[]{"男","女"};
                    AlertDialog.Builder builder2=new AlertDialog.Builder(AlertDialogActivity.this);//下面的数字1，代表女被默认选择
                    builder2.setTitle("请选择性别").setSingleChoiceItems(array3, 1, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            ToastUtil.showMsg(AlertDialogActivity.this,array3[i]);
                            dialogInterface.dismiss(); //点击完之后会消失，不设置的话，点击选择后不会消失
                        }
                    }).setCancelable(false).show();//setCancelable(false)点击旁边dialog不会消失，不设置的话点旁边会消失
                    break;
                case R.id.btn_dialog4:
                    final String[] array4=new String[]{"唱歌","跳舞","写代码'"};
                    boolean[] isSelected=new boolean[]{false,false,true};
                    AlertDialog.Builder builder3=new AlertDialog.Builder(AlertDialogActivity.this);
                    builder3.setTitle("选择兴趣").setMultiChoiceItems(array4, isSelected, new DialogInterface.OnMultiChoiceClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                            ToastUtil.showMsg(AlertDialogActivity.this,array4[i]+":"+b);
                        }
                    }).setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            //
                        }
                    }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    }).show();
                    break;
                case R.id.btn_dialog5:
                    AlertDialog.Builder builder4=new AlertDialog.Builder(AlertDialogActivity.this);
                    View view1=LayoutInflater.from(AlertDialogActivity.this).inflate(R.layout.layout_dialog,null);
                    EditText editText= (EditText) view1.findViewById(R.id.et_username);
                    EditText editText1= (EditText) view1.findViewById(R.id.et_password);
                    Button button= (Button) view1.findViewById(R.id.bt_login);
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            //写一些点击事件需要处理的请求
                        }
                    });
                    builder4.setTitle("请先登录").setView(view1).show();

                    break;
            }
        }
    }
}
