package com.study.guyu.androidstudy.ui.uiitem.widget;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.study.guyu.androidstudy.R;

/**
 * @author 我的名字
 * @package com.study.guyu.androidstudy.ui.uiitem.widget
 * @date 2020/2/9 19:56
 * @describe TODO
 * @project
 */
public class CustomDialog extends Dialog implements View.OnClickListener{
    private TextView mTvtitle,mTvMessage,mTvCancel,mTvConfirm;
    private String title,message,cancel,confirm;

    private IOnCancelListener mIOnCancelListener;
    private IOnConfirmListener mIOnConfirmListener;

    public CustomDialog(Context context){
        super(context);
    }
    public CustomDialog(Context context,int themeId){
        super(context,themeId);
    }

    //这里返回值为custom dialog是为了可以携程一连串的set形式
    public CustomDialog setTitle(String title) {
        this.title = title;
        return  this;
    }

    public CustomDialog setMessage(String message) {
        this.message = message;
        return this;
    }

    public CustomDialog setCancel(String cancel,IOnCancelListener listener) {
        this.cancel = cancel;
        this.mIOnCancelListener=listener;
        return this;
    }

    public CustomDialog setConfirm(String confirm,IOnConfirmListener listener) {
        this.confirm = confirm;
        this.mIOnConfirmListener=listener;
        return this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_custom_dialog);

        // 设置宽度
        WindowManager manager = getWindow().getWindowManager();
        Display display = manager.getDefaultDisplay();
        WindowManager.LayoutParams params = getWindow().getAttributes();
        Point size = new Point();
        display.getSize(size);
        // 宽度为当前屏幕的80%
        params.width = (int)(size.x * 0.8);
        getWindow().setAttributes(params);

        mTvtitle= (TextView) findViewById(R.id.tv_title);
        mTvMessage= (TextView) findViewById(R.id.tv_message);
        mTvCancel= (TextView) findViewById(R.id.tv_cancel);
        mTvConfirm= (TextView) findViewById(R.id.tv_confirm);

        if(!TextUtils.isEmpty(title)){
            mTvtitle.setText(title);
        }
        if(!TextUtils.isEmpty(message)){
            mTvMessage.setText(message);
        }
        if(!TextUtils.isEmpty(cancel)){
            mTvCancel.setText(cancel);
        }
        if(!TextUtils.isEmpty(confirm)){
            mTvConfirm.setText(confirm);
        }
        mTvCancel.setOnClickListener(this);
        mTvConfirm.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_cancel:
                if(mIOnCancelListener!=null)
                {
                    mIOnCancelListener.onCancel(this);
                }
                dismiss();
                break;
            case R.id.tv_confirm:
                if(mIOnConfirmListener!=null)
                {
                    mIOnConfirmListener.onConfirm(this);
                }
                dismiss();
                break;
        }
    }

    public interface IOnCancelListener{
        void onCancel(CustomDialog dialog);
    }

    public interface IOnConfirmListener{
        void onConfirm(CustomDialog dialog);
    }
}
