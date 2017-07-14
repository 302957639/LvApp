package com.example.jtd.lvapp.gongjuxiang.save;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;

import com.example.jtd.lvapp.R;
import com.example.jtd.lvapp.gongjuxiang.start.Start_Lvcheng;

/**
 * Created by JTD on 2017/7/9.
 */

public class SaveActivity extends AppCompatActivity implements View.OnClickListener{
    private RadioButton rbback;
    private ImageView imgshezhididian,imggoneshow;
    private LinearLayout layoutshow;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save);
        rbback=(RadioButton)findViewById(R.id.back);
        rbback.setOnClickListener(this);
        imgshezhididian=(ImageView)findViewById(R.id.shezhididian);
        imgshezhididian.setOnClickListener(this);
        imggoneshow=(ImageView)findViewById(R.id.goneshow);
        imggoneshow.setOnClickListener(this);
        layoutshow=(LinearLayout) findViewById(R.id.show);
        layoutshow.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.back:
                finish();
                break;
            case R.id.shezhididian:
                Intent intent_tostart=new Intent(this, Start_Lvcheng.class);
                startActivity(intent_tostart);
                break;
            case R.id.goneshow:
                layoutshow.setVisibility(View.GONE);
                break;
        }
    }
}
