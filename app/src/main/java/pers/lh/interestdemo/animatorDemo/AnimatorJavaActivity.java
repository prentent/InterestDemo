package pers.lh.interestdemo.animatorDemo;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import pers.lh.interestdemo.R;

public class AnimatorJavaActivity extends AppCompatActivity {

    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animator_java);
        img = findViewById(R.id.imageView4);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button8:
                ValueAnimator valueAnimator = ValueAnimator.ofObject(new MyTypeEvaluator(), "#ff0077", "#00ffff");
                valueAnimator.setDuration(2000);
                valueAnimator.setTarget(img);
                valueAnimator.start();
                valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        String value = (String) valueAnimator.getAnimatedValue();
                        img.setBackgroundColor(Color.parseColor(value));
                    }
                });
                break;
            case R.id.button9:
                ObjectAnimator scaleX = ObjectAnimator.ofFloat(img, "scaleX", 1.0f, 0.5f);
                scaleX.setDuration(2000);
                scaleX.start();
                break;
            case R.id.button10:
                ObjectAnimator scaleX1 = ObjectAnimator.ofFloat(img, "scaleX", 1.0f, 0.5f);
                ObjectAnimator scaleY1 = ObjectAnimator.ofFloat(img, "scaleY", 1.0f, 0.5f);
                ObjectAnimator translationX1 = ObjectAnimator.ofFloat(img, "translationX", 300f);
                AnimatorSet set = new AnimatorSet();
//                set.play(scaleX1).with(scaleY1).after(translationX1);  //看就懂了
                set.playTogether(scaleX1, scaleY1, translationX1);   //同时执行
//                set.playSequentially(scaleX1,scaleY1,translationX1);  //顺序执行
                set.setDuration(2000);
                set.start();

                break;
            case R.id.button11:
                PropertyValuesHolder p1 = PropertyValuesHolder.ofFloat("scaleX", 1.0f, 0.5f);
                PropertyValuesHolder p2 = PropertyValuesHolder.ofFloat("scaleY", 1.0f, 0.5f);
                PropertyValuesHolder p3 = PropertyValuesHolder.ofFloat("translationX", 0.0f,300f);
                ObjectAnimator objectAnimator = ObjectAnimator.ofPropertyValuesHolder(img, p1, p2, p3);
                objectAnimator.setDuration(2000);
                objectAnimator.start();
                break;
        }
    }
}
