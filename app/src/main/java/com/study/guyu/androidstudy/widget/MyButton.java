package com.study.guyu.androidstudy.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Button;

/**
 * @author 我的名字
 * @package com.study.guyu.androidstudy.widget
 * @date 2020/2/11 16:13
 * @describe TODO
 * @project
 */
public class MyButton extends Button {
    public MyButton(Context context){
        super(context);
    }

    public MyButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MyButton(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        super.onTouchEvent(event);
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                Log.d("MyButton","-----onTouchEvent------");
                break;
        }

        return false;
    }

}
