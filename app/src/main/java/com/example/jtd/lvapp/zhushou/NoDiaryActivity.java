package com.example.jtd.lvapp.zhushou;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.jtd.lvapp.R;
import com.example.jtd.lvapp.UseHelpActivity;
import com.example.jtd.lvapp.gongjuxiang.start.Start_Lvcheng;

/**
 * Created by JTD on 2017/7/7.
 */

public class NoDiaryActivity extends AppCompatActivity implements View.OnClickListener{
    private RadioButton rbback,rbadd;
    private TextView tvtousehelp;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nodiary);
        rbback=(RadioButton)findViewById(R.id.back_zhushou);
        rbadd=(RadioButton)findViewById(R.id.add_xingcheng);
        rbback.setOnClickListener(this);
        rbadd.setOnClickListener(this);
        tvtousehelp=(TextView)findViewById(R.id.tousehelp);
        tvtousehelp.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.back_zhushou:
                finish();
                break;
            case R.id.add_xingcheng:
                Intent intent_start=new Intent(NoDiaryActivity.this,Start_Lvcheng.class);
                startActivity(intent_start);
                break;
            case R.id.tousehelp:
                Intent intent_usehelp=new Intent(NoDiaryActivity.this,UseHelpActivity.class);
                startActivity(intent_usehelp);
                break;
        }

    }
}
