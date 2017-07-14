package com.example.jtd.lvapp.mine;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.jtd.lvapp.R;
import com.example.jtd.lvapp.zhushou.Zhushou_Fragment;

/**
 * Created by JTD on 2017/7/8.
 */

public class DengluActivity extends AppCompatActivity implements View.OnClickListener{
    private RadioButton rbback;
    private TextView tvwangjimima,tvzhuce;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mine_denglu);
        rbback=(RadioButton)findViewById(R.id.back);
        rbback.setOnClickListener(this);
        tvwangjimima=(TextView)findViewById(R.id.wangjimima);
        tvzhuce=(TextView)findViewById(R.id.zhuce);
        tvwangjimima.setOnClickListener(this);
        tvzhuce.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent_zhuce=new Intent(DengluActivity.this,ZhuceActivity.class);
        switch (view.getId()){
            case R.id.back:
                finish();
                break;
            case R.id.wangjimima:
                startActivity(intent_zhuce);
                break;
            case R.id.zhuce:
                startActivity(intent_zhuce);
                break;
        }
    }
}
