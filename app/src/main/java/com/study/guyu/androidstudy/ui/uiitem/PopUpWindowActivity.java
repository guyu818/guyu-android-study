package com.study.guyu.androidstudy.ui.uiitem;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.study.guyu.androidstudy.R;
import com.study.guyu.androidstudy.util.ToastUtil;

/**
 * @author 我的名字
 * @package com.study.guyu.androidstudy.ui.uiitem
 * @date 2020/2/5 21:57
 * @describe TODO
 * @project
 */
public class PopUpWindowActivity extends ActionBarActivity {
    private Button mPop;
    private PopupWindow mPopupWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popupwindow);

        mPop= (Button) findViewById(R.id.btn_pop);
        mPop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View view1=getLayoutInflater().inflate(R.layout.layout_pop,null);
                TextView textView= (TextView) view1.findViewById(R.id.tv_good);
                textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mPopupWindow.dismiss();
                        //做一些处理
                        ToastUtil.showMsg(PopUpWindowActivity.this,"好");
                    }
                });
                mPopupWindow=new PopupWindow(view1,mPop.getWidth(), ViewGroup.LayoutParams.WRAP_CONTENT);
                mPopupWindow.setOutsideTouchable(true);//此设置实现了点击其他地方，pop便可消失的效果
                mPopupWindow.setFocusable(true);        //此设置实现了再次点击收回的效果
                mPopupWindow.showAsDropDown(mPop);
            }
        });
    }
}
