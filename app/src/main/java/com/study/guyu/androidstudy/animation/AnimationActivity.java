package com.study.guyu.androidstudy.animation;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.study.guyu.androidstudy.R;

public class AnimationActivity extends ActionBarActivity {
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        mTextView= (TextView) findViewById(R.id.tv);

//        mTextView.animate().translationYBy(500).setDuration(2000).start();
//
//        mTextView.animate().alpha(0).setDuration(2000).start();
//
//        ValueAnimator valueAnimator=ValueAnimator.ofInt(0,100);
//        valueAnimator.setDuration(2000);
//        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator valueAnimator) {
//                //valueAnimator 实际的值
//                Log.d("aaa",valueAnimator.getAnimatedValue()+"");
//                //动画进度0-1
//                Log.d("aaa",valueAnimator.getAnimatedFraction()+"");
//            }
//        });
//        valueAnimator.start();
        mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(mTextView, "translationY", 0, 500, 200, 800);
                objectAnimator.setDuration(6000);
                objectAnimator.start();
            }
        });


    }
}
