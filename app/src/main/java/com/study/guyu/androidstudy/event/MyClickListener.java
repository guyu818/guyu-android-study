package com.study.guyu.androidstudy.event;

import android.app.Activity;
import android.view.View;

import com.study.guyu.androidstudy.util.ToastUtil;

/**
 * @author 我的名字
 * @package com.study.guyu.androidstudy.event
 * @date 2020/2/11 15:38
 * @describe TODO
 * @project
 */
public class MyClickListener implements View.OnClickListener {

    private Activity mActivity;

    public MyClickListener(Activity activity){
        this.mActivity=activity;
    }

    @Override
    public void onClick(View view) {
        ToastUtil.showMsg(mActivity,"外部类click.....");
    }
}
