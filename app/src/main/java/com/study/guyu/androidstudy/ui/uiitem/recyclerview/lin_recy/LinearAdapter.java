package com.study.guyu.androidstudy.ui.uiitem.recyclerview.lin_recy;

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
public class LinearAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    //这里可以传数据,这里演示的时候用的是一个重复的数据
    //private List<String> mList;
     private OnItemClickListener mListener;

    public LinearAdapter(Context context,OnItemClickListener onItemClickListener){

        this.mContext=context;
        this.mListener=onItemClickListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType==0){
            return new LinearViewHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_linear_item,parent,false));
        }else {
            return new LinearViewHolder2(LayoutInflater.from(mContext).inflate(R.layout.layout_linear_item_2,parent,false));
        }

    }

    //设置内容
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        //int a=position;
        if(getItemViewType(position)==0){
            ((LinearViewHolder)holder).mTextView.setText("linear viewtype ");
        }else {
            ((LinearViewHolder2)holder).mTextView.setText("linear viewtype2");
            ((LinearViewHolder2)holder).mImageView.setImageResource(R.drawable.smile);
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

    //不同的viewtype区分对待

    @Override
    public int getItemViewType(int position) {
        if (position%2==0){
            return 0;
        }else {
            return 1;
        }
    }

    //列表长度这里写的30
    @Override
    public int getItemCount() {
        return 30;
    }

    class LinearViewHolder extends RecyclerView.ViewHolder{

        private TextView mTextView;

        public LinearViewHolder(View view)
        {
            super(view);
            mTextView= (TextView) view.findViewById(R.id.tv_title);
        }
    }
    class LinearViewHolder2 extends RecyclerView.ViewHolder{

        private TextView mTextView;
        private ImageView mImageView;

        public LinearViewHolder2(View view)
        {
            super(view);
            mTextView= (TextView) view.findViewById(R.id.tv_title);
            mImageView= (ImageView) view.findViewById(R.id.im);
        }
    }


    public interface OnItemClickListener
    {
        void onClick(int pos);
    }
}
