package com.study.guyu.androidstudy.util;

import android.content.Context;
import android.widget.Toast;

/**
 * @author 我的名字
 * @package com.study.guyu.androidstudy.util
 * @date 2020/2/7 13:42
 * @describe TODO
 * @project
 */
public class ToastUtil {
    public static Toast mToast;
    public static void showMsg(Context context,String msg){
        if(mToast==null){
            mToast=Toast.makeText(context,msg,Toast.LENGTH_LONG);
        }else{
            mToast.setText(msg);
        }
        mToast.show();
    }
}
