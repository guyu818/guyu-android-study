package com.study.guyu.androidstudy.ui.uiitem.recyclerview.grid_recy;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.study.guyu.androidstudy.R;

public class GridActivity extends ActionBarActivity {


    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);

        mRecyclerView= (RecyclerView) findViewById(R.id.rv_grid);

        mRecyclerView.setLayoutManager(new GridLayoutManager(GridActivity.this,3));//这里的网格视图设置为3列
        mRecyclerView.setAdapter(new GridAdapter(GridActivity.this, new GridAdapter.OnItemClickListener() {
            @Override
            public void onClick(int pos) {
                Log.d("pos",pos+"");
                Toast.makeText(GridActivity.this,"click"+pos,Toast.LENGTH_SHORT).show();
            }
        }));

    }
}
