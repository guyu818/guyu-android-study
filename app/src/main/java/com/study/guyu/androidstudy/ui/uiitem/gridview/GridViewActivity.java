package com.study.guyu.androidstudy.ui.uiitem.gridview;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.study.guyu.androidstudy.R;

/**
 * @author 我的名字
 * @package com.study.guyu.androidstudy.ui.uiitem
 * @date 2020/2/5 21:35
 * @describe TODO
 * @project
 */
public class GridViewActivity extends ActionBarActivity {
    private GridView mGridView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gridview);
        mGridView= (GridView) findViewById(R.id.gv);

        mGridView.setAdapter(new MyGridViewAdapter(GridViewActivity.this));

        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(GridViewActivity.this, "点击 pos:" + i, Toast.LENGTH_SHORT).show();
            }
        });

        mGridView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(GridViewActivity.this, "长按 pos:" + i, Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }
}
