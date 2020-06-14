package com.study.guyu.androidstudy.ui.uiitem.recyclerview.hor_recy;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.study.guyu.androidstudy.R;

/**
 * @author 我的名字
 * @package com.study.guyu.androidstudy.ui.uiitem.recyclerview
 * @date 2020/2/7 17:51
 * @describe TODO
 * @project
 */
public class HorAdapter extends RecyclerView.Adapter<HorAdapter.LinearViewHolder> {

    private Context mContext;
    //这里可以传数据,这里演示的时候用的是一个重复的数据
    //private List<String> mList;
    private OnItemClickListener mListener;

    public HorAdapter(Context context,OnItemClickListener listener){
        this.mListener=listener;
        this.mContext=context;
    }


    @Override
    public HorAdapter.LinearViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        return new LinearViewHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_hor_item,parent,false));
    }

    //设置内容
    @Override
    public void onBindViewHolder( HorAdapter.LinearViewHolder holder, final int position) {
        holder.mTextView.setText("hor recyclerview ");

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
        return 30;
    }

    class LinearViewHolder extends RecyclerView.ViewHolder{

        private TextView mTextView;

        public LinearViewHolder( View view)
        {
            super(view);
            mTextView= (TextView) view.findViewById(R.id.tv_title);
        }
    }
    public interface OnItemClickListener
    {
        void onClick(int pos);
    }
}
