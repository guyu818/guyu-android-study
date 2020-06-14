package com.study.guyu.androidstudy.ui.uiitem.gridview;

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
 * @package com.study.guyu.androidstudy.ui.uiitem.gridview
 * @date 2020/2/6 20:50
 * @describe TODO
 * @project
 */
public class MyGridViewAdapter extends BaseAdapter {

    private Context mContext;
    private LayoutInflater mLayoutInflater;
    public MyGridViewAdapter(Context context) {
        this.mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
    }

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
    static  class ViewHolder{
        public ImageView mImageView;
        public TextView mTextView;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
       ViewHolder viewHolder=null;
        if(view==null){
            view=mLayoutInflater.inflate(R.layout.layout_grid_item,null);
            viewHolder=new ViewHolder();
            viewHolder.mImageView= (ImageView) view.findViewById(R.id.iv_grid);
            viewHolder.mTextView= (TextView) view.findViewById(R.id.tv_title);
            view.setTag(viewHolder);
        }else{
            viewHolder= (ViewHolder) view.getTag();
        }
        //赋值
        viewHolder.mTextView.setText("花");
        Picasso.with(mContext).load("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1581004780107&di=67fdec7181412afdd2a17e7dab5d3365&imgtype=0&src=http%3A%2F%2F5b0988e595225.cdn.sohucs.com%2Fq_70%2Cc_zoom%2Cw_640%2Fimages%2F20180126%2F160e4b1b5433448f959cfd255fc20dbd.jpeg").into(viewHolder.mImageView);
        return view;
    }
}
