package com.example.jtd.lvapp.mine.shizhi;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;

import com.example.jtd.lvapp.R;

/**
 * Created by JTD on 2017/7/8.
 */

public class ShezhiActivity extends AppCompatActivity implements View.OnClickListener{
    private RadioButton rbback;
    private CheckBox chkchoosexiaoxi,chkchoosefanyi;
    private LinearLayout layoutupdata;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mine_shezhi);
        rbback=(RadioButton)findViewById(R.id.back);
        rbback.setOnClickListener(this);
        chkchoosexiaoxi=(CheckBox)findViewById(R.id.choosexiaoxi);
        chkchoosexiaoxi.setOnClickListener(this);
        chkchoosefanyi=(CheckBox)findViewById(R.id.choosefanyi);
        chkchoosefanyi.setOnClickListener(this);
        layoutupdata=(LinearLayout)findViewById(R.id.updata);
        layoutupdata.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.back:
                finish();
                break;
            case R.id.choosexiaoxi:
                if (chkchoosexiaoxi.isChecked()){
                    chkchoosexiaoxi.setBackgroundDrawable(getResources().getDrawable(R.mipmap.setting_page_notify_bt_up));
                }else {
                    chkchoosexiaoxi.setBackgroundDrawable(getResources().getDrawable(R.mipmap.setting_page_notify_bt_down));
                }
                break;
            case R.id.choosefanyi:
                if (chkchoosefanyi.isChecked()){
                    chkchoosefanyi.setBackgroundDrawable(getResources().getDrawable(R.mipmap.setting_page_notify_bt_up));
                }else {
                    chkchoosefanyi.setBackgroundDrawable(getResources().getDrawable(R.mipmap.setting_page_notify_bt_down));
                }
                break;
            case R.id.updata:
                Intent intent_updata=new Intent(ShezhiActivity.this,UpdataActivity.class);
                startActivity(intent_updata);
                break;
        }
    }
}
