package com.example.jtd.lvapp.mine.shizhi;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;

import com.example.jtd.lvapp.R;
import com.example.jtd.lvapp.gongjuxiang.rate.Rate;

/**
 * Created by JTD on 2017/7/12.
 */

public class UpdataActivity extends AppCompatActivity implements View.OnClickListener{
    private RadioButton rbback;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mine_shizhi_updata);
        rbback=(RadioButton)findViewById(R.id.back);
        rbback.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.back:
                finish();
                break;
        }
    }
}
