package com.study.guyu.androidstudy.ui.uiitem.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.study.guyu.androidstudy.R;

/**
 * @author 我的名字
 * @package com.study.guyu.androidstudy.ui.uiitem.listview
 * @date 2020/2/6 19:43
 * @describe TODO
 * @project
 */
//adapter适配器告诉哦你view长什么样子
public class MyListAdapter extends BaseAdapter {

    private Context mContext;
    private LayoutInflater mLayoutInflater;

    public MyListAdapter(Context context){
        this.mContext=context;
        mLayoutInflater=LayoutInflater.from(context);
    }

    /*
    这个函数是list view里面的数目
     */
    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    //这里的方法比较好
    static class ViewHolder{
        public ImageView mImageView;
        public TextView mTvTitle,mTvTime,mTvContent;
    }

    //告诉你每一行是什么样子
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder=null;
        if(view==null){
            view=mLayoutInflater.inflate(R.layout.layout_list_item,null);
            viewHolder=new ViewHolder();
            viewHolder.mImageView= (ImageView) view.findViewById(R.id.iv);
            viewHolder.mTvTitle= (TextView) view.findViewById(R.id.tv_title);
            viewHolder.mTvTime= (TextView) view.findViewById(R.id.tv_time);
            viewHolder.mTvContent= (TextView) view.findViewById(R.id.tv_content);
            view.setTag(viewHolder);
        }else{
            viewHolder= (ViewHolder) view.getTag();
        }
        //给控件赋值，这里赋的值将覆盖控件上的text
        viewHolder.mTvTitle.setText("这是标题");
        viewHolder.mTvTime.setText("这是时间");
        viewHolder.mTvContent.setText("这是内容");
        Picasso.with(mContext).load("http://i1.sinaimg.cn/ent/d/2008-06-04/U105P28T3D2048907F326DT20080604225106.jpg").into(viewHolder.mImageView);
        return view;
    }
}
