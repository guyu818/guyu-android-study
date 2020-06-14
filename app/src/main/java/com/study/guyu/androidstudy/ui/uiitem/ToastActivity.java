package com.study.guyu.androidstudy.ui.uiitem;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import com.study.guyu.androidstudy.R;
import com.study.guyu.androidstudy.util.ToastUtil;

/**
 * @author 我的名字
 * @package com.study.guyu.androidstudy.ui.uiitem
 * @date 2020/2/5 21:50
 * @describe TODO
 * @project
 */
public class ToastActivity extends ActionBarActivity {
    private Button mBtnToast1, mBtnToast2, mBtnToast3,mBtnToast4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);
        mBtnToast1 = (Button) findViewById(R.id.toast_1);
        mBtnToast2 = (Button) findViewById(R.id.toast_2);
        mBtnToast3 = (Button) findViewById(R.id.toast_3);
        mBtnToast4= (Button) findViewById(R.id.toast_4);
        setListeners();


    }

    public void setListeners() {
        OnClick onClick = new OnClick();
        mBtnToast1.setOnClickListener(onClick);
        mBtnToast2.setOnClickListener(onClick);
        mBtnToast3.setOnClickListener(onClick);
        mBtnToast4.setOnClickListener(onClick);
    }

    class OnClick implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.toast_1:
                    Toast.makeText(ToastActivity.this, "这是默认的toast", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.toast_2:
                    Toast toastCenter = Toast.makeText(getApplicationContext(), "剧中的toast", Toast.LENGTH_LONG);
                    toastCenter.setGravity(Gravity.CENTER, 0, 0);                 //toast剧中设置
                    toastCenter.show();
                    break;
                case R.id.toast_3:
                    Toast toastCustom = new Toast(getApplicationContext());
                    LayoutInflater inflater = LayoutInflater.from(ToastActivity.this);
                    View view1 = inflater.inflate(R.layout.layout_toast, null);
                    ImageView imageView = (ImageView) view1.findViewById(R.id.iv_toast);
                    TextView textView = (TextView) view1.findViewById(R.id.tv_toast);
                    imageView.setImageResource(R.drawable.smile);
                    textView.setText("自定义的图片加icontoast");
                    toastCustom.setView(view1);
                    toastCustom.setDuration(Toast.LENGTH_LONG);
                    toastCustom.show();
                    break;
                case R.id.toast_4:
                    ToastUtil.showMsg(getApplicationContext(),"包装过的toast，连续点击也不会出现等待很长时间的情况");
                    break;
            }
        }
    }

}
