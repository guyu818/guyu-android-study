package com.study.guyu.androidstudy.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.study.guyu.androidstudy.R;

/**
 * @author 我的名字
 * @package com.study.guyu.androidstudy.fragment
 * @date 2020/2/10 14:44
 * @describe TODO
 * @project
 */
public class AFragment extends Fragment {

    private TextView mTvTitle;
    private BFragment bFragment;
//    private Activity mActivity;
    private Button mBtnChange,mBtnRest,mBtnMessage;
    private IOnMessageClick listener;

    public static AFragment newInstance(String title){
        AFragment fragment=new AFragment();

        Bundle bundle=new Bundle();
        bundle.putString("title", title);
        fragment.setArguments(bundle);

        return fragment;
    }

    //fragment向activity传递信息的第二种方法，用回调接口来实现
    public interface IOnMessageClick{
        void onClick(String text);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_a,container,false);
        Log.d("AFragment","------onCreateView------");
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mTvTitle= (TextView) view.findViewById(R.id.tv_title);
        mBtnChange= (Button) view.findViewById(R.id.btn_change);
        mBtnRest= (Button) view.findViewById(R.id.btn_reset);
        mBtnMessage= (Button) view.findViewById(R.id.btn_message);

//        if(getActivity()==null){
//            //如果发现fragment和绑定的activity为空，要做的处理
//        }else{
//
//        }
        mBtnMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                ((ContainerActivity)getActivity()).setData("你好");
                listener.onClick("你好");
            }
        });
        mBtnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (bFragment==null){
                    bFragment=new BFragment();
                }

                Fragment fragment=getFragmentManager().findFragmentByTag("A");
                if (fragment!=null){
                    Log.d("dadad","hdahhdjah");
                    getFragmentManager().beginTransaction().hide(fragment).add(R.id.fl_container,bFragment,"B").addToBackStack("B").commit();
                }else{
                    Log.d("dadad","11111111");
                    getFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.fl_container,bFragment).commit();
                }

            }
        });
        mBtnRest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTvTitle.setText("我是新文字");
            }
        });
        if (getArguments()!=null){
            mTvTitle.setText(getArguments().getString("title"));
        }
    }

    //fragment和actuvuty保持关系的调的函数
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try{
            listener= (IOnMessageClick) activity;
        }catch (ClassCastException e){
            throw new ClassCastException("activity 必须实现 IOnMessageClick接口");
        }
//        mActivity=activity;
    }

    //解除关系调用函数
    @Override
    public void onDetach() {
        Log.d("dadad","ondetch");
        super.onDetach();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //做一些取消异步任务的操作
    }


}
