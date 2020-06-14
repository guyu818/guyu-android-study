package com.study.guyu.androidstudy.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.study.guyu.androidstudy.R;

/**
 * @author 我的名字
 * @package com.study.guyu.androidstudy.fragment
 * @date 2020/2/10 14:44
 * @describe TODO
 * @project
 */
public class BFragment extends Fragment {

    private TextView mTvTitle;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_b,container,false);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mTvTitle= (TextView) view.findViewById(R.id.tv_title);
        
    }
}
