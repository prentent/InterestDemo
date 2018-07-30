package pers.lh.interestdemo.animationDemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;

import pers.lh.interestdemo.R;

/*
 * 通过资源文件加载的补间动画
 * */
public class AnimationResActivity extends AppCompatActivity {

    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_res);
        img = findViewById(R.id.imageView2);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button:  //缩放
                Animation animation = AnimationUtils.loadAnimation(this, R.anim.scale);
                animation.setInterpolator(new AnticipateOvershootInterpolator());
                img.startAnimation(animation);
                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        Log.e("=======scale", "onAnimationStart");
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        Log.e("=======scale", "onAnimationEnd");
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {
                        Log.e("=======scale", "onAnimationRepeat");
                    }
                });
                break;
            case R.id.button2: //平移
                Animation animation1 = AnimationUtils.loadAnimation(this, R.anim.translate);
                animation1.setInterpolator(new OvershootInterpolator());
                img.startAnimation(animation1);
                animation1.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        Log.e("=======translate", "onAnimationStart");
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        Log.e("=======translate", "onAnimationStart");
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {
                        Log.e("=======translate", "onAnimationStart");
                    }
                });
                break;
            case R.id.button3: //旋转
                Animation animation2 = AnimationUtils.loadAnimation(this, R.anim.rotate);
                animation2.setInterpolator(new OvershootInterpolator());
                img.startAnimation(animation2);
                animation2.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        Log.e("=======rotate", "onAnimationStart");
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        Log.e("=======rotate", "onAnimationStart");
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {
                        Log.e("=======rotate", "onAnimationStart");
                    }
                });
                break;
            case R.id.button4: //透敏度
                Animation animation3 = AnimationUtils.loadAnimation(this, R.anim.alpha);
                animation3.setInterpolator(new OvershootInterpolator());
                img.startAnimation(animation3);
                animation3.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        Log.e("=======alpha", "onAnimationStart");
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        Log.e("=======alpha", "onAnimationStart");
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {
                        Log.e("=======alpha", "onAnimationStart");
                    }
                });
                break;
        }
    }
}
