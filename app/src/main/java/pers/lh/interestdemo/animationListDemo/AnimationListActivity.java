package pers.lh.interestdemo.animationListDemo;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import pers.lh.interestdemo.R;

public class AnimationListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_list);
        ImageView img = findViewById(R.id.imageView);
        img.setImageResource(R.drawable.animation_drawable);
        final AnimationDrawable drawable = (AnimationDrawable)img.getDrawable();
        drawable.stop();
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (drawable.isRunning()){
                    drawable.stop();
                }else{
                    drawable.start();
                }
            }
        });
    }
}
