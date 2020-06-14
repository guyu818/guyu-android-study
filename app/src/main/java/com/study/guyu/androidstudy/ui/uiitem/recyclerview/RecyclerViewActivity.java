package com.study.guyu.androidstudy.ui.uiitem.recyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;

import com.study.guyu.androidstudy.R;
import com.study.guyu.androidstudy.ui.uiitem.recyclerview.grid_recy.GridActivity;
import com.study.guyu.androidstudy.ui.uiitem.recyclerview.hor_recy.HorRecyclerViewActivity;
import com.study.guyu.androidstudy.ui.uiitem.recyclerview.lin_recy.linearRecyclerViewActivity;
import com.study.guyu.androidstudy.ui.uiitem.recyclerview.pu_recy.PuRecyActivity;

/**
 * @author 我的名字
 * @package com.study.guyu.androidstudy.ui.uiitem
 * @date 2020/2/5 21:36
 * @describe TODO
 * @project
 */
public class RecyclerViewActivity extends ActionBarActivity {
    private Button mBtnlinear,mBtnhor,mGrid,mPu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);

        mBtnlinear= (Button) findViewById(R.id.btn_linear);
        mBtnhor= (Button) findViewById(R.id.btn_hor);
        mGrid= (Button) findViewById(R.id.btn_grid);
        mPu= (Button) findViewById(R.id.btn_pu);

        mBtnlinear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(RecyclerViewActivity.this,linearRecyclerViewActivity.class);
                startActivity(intent);

            }
        });
        mBtnhor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(RecyclerViewActivity.this,HorRecyclerViewActivity.class);
                startActivity(intent);
            }
        });

        mGrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(RecyclerViewActivity.this, GridActivity.class);
                startActivity(intent);
            }
        });

        mPu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(RecyclerViewActivity.this, PuRecyActivity.class);
                startActivity(intent);
            }
        });
    }

}
