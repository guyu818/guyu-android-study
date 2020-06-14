package com.study.guyu.androidstudy.ui.uiitem.recyclerview.pu_recy;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.study.guyu.androidstudy.R;

/**
 * @author 我的名字
 * @package com.study.guyu.androidstudy.ui.uiitem.recyclerview
 * @date 2020/2/7 17:51
 * @describe TODO
 * @project
 */
public class PuGridAdapter extends RecyclerView.Adapter<PuGridAdapter.LinearViewHolder> {

    private Context mContext;
    //这里可以传数据,这里演示的时候用的是一个重复的数据
    //private List<String> mList;
    private OnItemClickListener mListener;

    public PuGridAdapter(Context context, OnItemClickListener listener){
        this.mListener=listener;
        this.mContext=context;
    }


    @Override
    public PuGridAdapter.LinearViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        return new LinearViewHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_pugrid_recycler_item,parent,false));
    }

    //设置内容
    @Override
    public void onBindViewHolder( PuGridAdapter.LinearViewHolder holder, final int position) {
        if(position%2==0){
            holder.mImageView.setImageResource(R.drawable.image1);
        }else {
            holder.mImageView.setImageResource(R.drawable.image2);
        }


        //下面的这一段代码和interface接口OnItemClickListener组合使用才可以让点击事件成功
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onClick(position);
//                Toast.makeText(mContext, "click..." + i, Toast.LENGTH_SHORT).show();
            }
        });

    }

    //列表长度这里写的30
    @Override
    public int getItemCount() {
        return 80;
    }

    class LinearViewHolder extends RecyclerView.ViewHolder{

        private ImageView mImageView;

        public LinearViewHolder( View view)
        {
            super(view);
            mImageView= (ImageView) view.findViewById(R.id.iv);
        }
    }
    public interface OnItemClickListener
    {
        void onClick(int pos);
    }
}
