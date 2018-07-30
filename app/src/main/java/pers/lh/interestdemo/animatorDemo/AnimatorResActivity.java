package pers.lh.interestdemo.animatorDemo;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.ColorSpace;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import pers.lh.interestdemo.R;

public class AnimatorResActivity extends AppCompatActivity {

    private ImageView img;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animator_res);
        img = findViewById(R.id.imageView3);
        textView = findViewById(R.id.textView);

    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button5:
                ValueAnimator animator = (ValueAnimator) AnimatorInflater.loadAnimator(this, R.animator.int_animator);
                animator.setDuration(2000);
                animator.setTarget(img);
                animator.start();
                animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        int value = (int) valueAnimator.getAnimatedValue();
                        textView.setText(value + "");
                    }
                });
                break;
            case R.id.button6:  //缩放
                ObjectAnimator loadAnimator = (ObjectAnimator) AnimatorInflater.loadAnimator(this, R.animator.scale);
                loadAnimator.setDuration(2000);
                loadAnimator.setInterpolator(new OvershootInterpolator());
                loadAnimator.setTarget(img);
                loadAnimator.start();
                break;
            case R.id.button7: //其他动画类似
                ObjectAnimator rotate = (ObjectAnimator) AnimatorInflater.loadAnimator(this, R.animator.rotate);
                rotate.setDuration(2000);
                rotate.setTarget(img);
                img.setPivotX(img.getWidth() / 3);
                img.setPivotY(img.getHeight() / 3);
                rotate.start();
                break;
        }
    }
}
