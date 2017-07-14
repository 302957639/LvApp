package com.example.jtd.lvapp.gongjuxiang.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;

import com.example.jtd.lvapp.R;

/**
 * Created by JTD on 2017/7/7.
 */

public class ViewActivity extends AppCompatActivity implements View.OnClickListener{
    private RadioButton rbback,rbchaxun;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        rbback=(RadioButton)findViewById(R.id.back);
        rbchaxun=(RadioButton)findViewById(R.id.chaxun);
        rbback.setOnClickListener(this);
        rbchaxun.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.back:
                finish();
                break;
            case R.id.chaxun:
                Intent intent_chaxun=new Intent(this,ChaXunAvtivity.class);
                startActivity(intent_chaxun);
                break;
        }
    }
}
