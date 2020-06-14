package com.study.guyu.androidstudy.ui.uiitem.recyclerview.lin_recy;

import android.graphics.Rect;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.study.guyu.androidstudy.R;

public class linearRecyclerViewActivity extends ActionBarActivity {

    private RecyclerView mRvMain;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_recycler_view);

        mRvMain= (RecyclerView) findViewById(R.id.rc_main);
        mRvMain.setLayoutManager(new LinearLayoutManager(linearRecyclerViewActivity.this));
       //添加下划线
        mRvMain.addItemDecoration(new MyDecoration());
        //设置适配器
        mRvMain.setAdapter(new LinearAdapter(linearRecyclerViewActivity.this, new LinearAdapter.OnItemClickListener() {
            @Override
            public void onClick(int pos) {
                Toast.makeText(linearRecyclerViewActivity.this,"click "+pos,Toast.LENGTH_SHORT).show();
            }
        }));

    }

    //设置下划线
    class MyDecoration extends RecyclerView.ItemDecoration{
        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            outRect.set(0,0,0,getResources().getDimensionPixelOffset(R.dimen.dividerHeight));
        }
    }
}
