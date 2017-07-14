package com.example.jtd.lvapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;


public class WelcomeActivity extends Activity {

    ImageView mLogo;
    ImageView mText;

    Animation mScaleAnimation;//图片缩放
    Animation mTranslateAnimation;//图片平移

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        mLogo = (ImageView) findViewById(R.id.welcome_iv_logo);
        mText = (ImageView) findViewById(R.id.welcome_iv_text);

        mScaleAnimation = AnimationUtils.loadAnimation(this, R.anim.welcom);
        mLogo.startAnimation(mScaleAnimation);

        mTranslateAnimation  = AnimationUtils.loadAnimation(this, R.anim.welcome_translate);
        mText.startAnimation(mTranslateAnimation);

        mScaleAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                startActivity(new Intent(WelcomeActivity.this, FirstActivity.class));
                finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

    }
}
