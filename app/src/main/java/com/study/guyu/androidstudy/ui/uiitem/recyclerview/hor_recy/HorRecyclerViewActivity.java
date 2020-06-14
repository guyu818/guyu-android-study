package com.study.guyu.androidstudy.ui.uiitem.recyclerview.hor_recy;

import android.graphics.Rect;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.view.View;
import android.widget.Toast;

import com.study.guyu.androidstudy.R;

public class HorRecyclerViewActivity extends ActionBarActivity {

    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hor_recycler_view);

        mRecyclerView= (RecyclerView) findViewById(R.id.rc_hor);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(HorRecyclerViewActivity.this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.addItemDecoration(new MyDecoration());
        mRecyclerView.setAdapter(new HorAdapter(HorRecyclerViewActivity.this, new HorAdapter.OnItemClickListener() {
            @Override
            public void onClick(int pos) {
                Toast.makeText(HorRecyclerViewActivity.this,"click"+pos,Toast.LENGTH_SHORT).show();
            }
        }));

    }
    //设置下划线
    class MyDecoration extends RecyclerView.ItemDecoration{
        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            outRect.set(0,0,getResources().getDimensionPixelOffset(R.dimen.dividerHeight),0);
        }
    }
}
