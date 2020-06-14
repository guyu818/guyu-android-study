package com.study.guyu.androidstudy.ui.uiitem.listview;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.study.guyu.androidstudy.R;

/**
 * @author 我的名字
 * @package com.study.guyu.androidstudy.ui.uiitem
 * @date 2020/2/5 21:34
 * @describe TODO
 * @project
 */
public class ListViewActivity extends ActionBarActivity{

    private ListView mLv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        mLv1= (ListView) findViewById(R.id.lv_1);

        //这里设置适配器
        mLv1.setAdapter(new MyListAdapter(ListViewActivity.this));
        //监听哪一个item被点击了
        mLv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(ListViewActivity.this,"点击 pos:"+i,Toast.LENGTH_SHORT).show();
            }
        });
        //监听那个item被长安了
        mLv1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(ListViewActivity.this,"长安 pos:"+i,Toast.LENGTH_SHORT).show();
                ///这里返回的false代表这里没有处理完，接下来还会处理点击事件函数里面的动作
                return false;
            }
        });
        //还可以监听那个item被选择了，这里就不打了
    }
}
