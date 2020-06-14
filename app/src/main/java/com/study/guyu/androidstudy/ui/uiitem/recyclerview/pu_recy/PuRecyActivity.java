package com.study.guyu.androidstudy.ui.uiitem.recyclerview.pu_recy;

import android.graphics.Rect;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.study.guyu.androidstudy.R;

public class PuRecyActivity extends ActionBarActivity {

    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pu_recy);

        mRecyclerView= (RecyclerView) findViewById(R.id.rv_pu);
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));//这里设置的两个参数，如果是垂直格式，2代表列，相反代表行
        //设置分割线
        mRecyclerView.addItemDecoration(new MyDecoration());
        mRecyclerView.setAdapter(new PuGridAdapter(PuRecyActivity.this, new PuGridAdapter.OnItemClickListener() {
            @Override
            public void onClick(int pos) {
                Toast.makeText(PuRecyActivity.this,"click "+pos,Toast.LENGTH_SHORT).show();
            }
        }));
    }

    //设置分割瀑布流图片之间的分割线
    class MyDecoration extends RecyclerView.ItemDecoration{
        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            int gap=getResources().getDimensionPixelSize(R.dimen.dividerHeight);
            outRect.set(gap,gap,gap,gap);
        }
    }
}
