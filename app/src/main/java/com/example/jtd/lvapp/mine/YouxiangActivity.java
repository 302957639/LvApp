package com.example.jtd.lvapp.mine;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;

import com.example.jtd.lvapp.R;

/**
 * Created by JTD on 2017/7/8.
 */

public class YouxiangActivity extends AppCompatActivity implements View.OnClickListener{
    private RadioButton rbback;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.avtivity_mine_youxiang);
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
