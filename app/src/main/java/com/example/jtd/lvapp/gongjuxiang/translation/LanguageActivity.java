package com.example.jtd.lvapp.gongjuxiang.translation;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;

import com.example.jtd.lvapp.FirstActivity;
import com.example.jtd.lvapp.R;
import com.example.jtd.lvapp.gongjuxiang.rate.Rate;

/**
 * Created by JTD on 2017/7/13.
 */

public class LanguageActivity extends AppCompatActivity implements View.OnClickListener{
    private RadioButton rbback,rbbackhome;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translation_language);
        rbback=(RadioButton)findViewById(R.id.back);
        rbbackhome=(RadioButton)findViewById(R.id.backhome);
        rbback.setOnClickListener(this);
        rbbackhome.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.back:
                finish();
                break;
            case R.id.backhome:
                Intent intent_home=new Intent(LanguageActivity.this, FirstActivity.class);
                startActivity(intent_home);
                break;
        }
    }
}
