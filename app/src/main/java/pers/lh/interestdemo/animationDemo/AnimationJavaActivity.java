package pers.lh.interestdemo.animationDemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.OvershootInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import pers.lh.interestdemo.R;

public class AnimationJavaActivity extends AppCompatActivity {

    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_java);
        img = findViewById(R.id.imageView2);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button: //缩放
                ScaleAnimation scaleAnimation = new ScaleAnimation(1, 2, 1, 3);
                scaleAnimation.setInterpolator(new OvershootInterpolator());
                scaleAnimation.setRepeatCount(Animation.INFINITE);
                scaleAnimation.setRepeatMode(Animation.REVERSE);
                scaleAnimation.setDuration(2000);
                img.startAnimation(scaleAnimation);
                break;
            case R.id.button2: //平移
                TranslateAnimation translateAnimation=new TranslateAnimation(1,200,1,200);
                translateAnimation.setInterpolator(new OvershootInterpolator());
                translateAnimation.setRepeatCount(Animation.INFINITE);
                translateAnimation.setRepeatMode(Animation.RESTART);
                translateAnimation.setDuration(2000);
                img.startAnimation(translateAnimation);
                break;
            case R.id.button3: //旋转
                RotateAnimation rotateAnimation=new RotateAnimation(0,360,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
                rotateAnimation.setInterpolator(new OvershootInterpolator());
                rotateAnimation.setRepeatCount(Animation.INFINITE);
                rotateAnimation.setRepeatMode(Animation.REVERSE);
                rotateAnimation.setDuration(2000);
                img.startAnimation(rotateAnimation);
                break;
            case R.id.button4: //透敏度
                AlphaAnimation alphaAnimation=new AlphaAnimation(1,0);
                alphaAnimation.setInterpolator(new OvershootInterpolator());
                alphaAnimation.setRepeatCount(Animation.INFINITE);
                alphaAnimation.setRepeatMode(Animation.REVERSE);
                alphaAnimation.setDuration(2000);
                img.startAnimation(alphaAnimation);
                break;
        }
    }
}
