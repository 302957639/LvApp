package com.example.jtd.lvapp.gongjuxiang.chuguo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;

import com.example.jtd.lvapp.R;
import com.example.jtd.lvapp.gongjuxiang.start.Start_Lvcheng;
import com.example.jtd.lvapp.gongjuxiang.weather.WeatherActivity;

/**
 * Created by JTD on 2017/7/8.
 */

public class ChuguoActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener{
    private RadioButton rbback,rbback_gongjuxiang;
    private LinearLayout layoutjumptostart;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chuguo);
        rbback=(RadioButton)findViewById(R.id.back);
        rbback_gongjuxiang=(RadioButton)findViewById(R.id.back_gongjuxiang);
        rbback.setOnCheckedChangeListener(this);
        rbback_gongjuxiang.setOnCheckedChangeListener(this);
        layoutjumptostart=(LinearLayout)findViewById(R.id.jumptostart);
        layoutjumptostart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ChuguoActivity.this, Start_Lvcheng.class);
                startActivity(intent);
            }
        });
    }


    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        switch (compoundButton.getId()){
            case R.id.back:
                finish();
                break;
            case R.id.back_gongjuxiang:
                finish();
                break;
        }

    }
}
