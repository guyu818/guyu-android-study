package com.study.guyu.androidstudy.ui.uiitem;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;
import com.study.guyu.androidstudy.R;

/**
 * @author 我的名字
 * @package com.study.guyu.androidstudy.ui.uiitem
 * @date 2020/2/5 21:32
 * @describe TODO
 * @project
 */
public class ImageViewActivity extends ActionBarActivity {

    private ImageView mIm,mIm1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imageview);
        mIm= (ImageView) findViewById(R.id.im_4);
        mIm1= (ImageView) findViewById(R.id.im_5);
        //加载网络图片,两中不同的依赖包 Picasso Glide
        Picasso.with(this).load("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1580995471963&di=cfdb848d3d0414b590c5f4d8c1d6e69e&imgtype=0&src=http%3A%2F%2Fcdn2.image.apk.gfan.com%2Fasdf%2FPImages%2F2014%2F12%2F26%2F211610_2d6bc9db3-77eb-4d80-9330-cd5e95fa091f.png").into(mIm);

        Glide.with(this).load("http://a4.att.hudong.com/20/62/01000000000000119086280352820.jpg").into(mIm1);
    }
}
