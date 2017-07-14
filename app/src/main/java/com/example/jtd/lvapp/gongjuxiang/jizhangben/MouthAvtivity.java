package com.example.jtd.lvapp.gongjuxiang.jizhangben;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CalendarView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.jtd.lvapp.R;

/**
 * Created by JTD on 2017/7/8.
 */

public class MouthAvtivity extends AppCompatActivity implements View.OnClickListener{
    private RadioButton rbback;
    private LinearLayout layoutdateshow;
    private TextView tvopen,tvyearmouthshow;
    private ImageView imgdown_up;
    private boolean datajudge=true;
    private CalendarView calendarchoosetime;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jizhangben_mouth);
        rbback=(RadioButton)findViewById(R.id.back);
        rbback.setOnClickListener(this);
        layoutdateshow=(LinearLayout)findViewById(R.id.dateshow);
        layoutdateshow.setOnClickListener(this);
        tvopen=(TextView)findViewById(R.id.open);
        imgdown_up=(ImageView)findViewById(R.id.down_up);
        Intent intent=getIntent();
        int year=intent.getIntExtra("year",1);
        int mouth=intent.getIntExtra("mouth",1);
        tvyearmouthshow=(TextView)findViewById(R.id.yearmouthshow);
        tvyearmouthshow.setText(year+"年"+mouth+"月");
        calendarchoosetime=(CalendarView)findViewById(R.id.choosetime);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.back:
                finish();
                break;
            case R.id.dateshow:
                if (datajudge){
                    tvopen.setText("收起账单日历");
                    imgdown_up.setImageResource(R.mipmap.myaccount_page_collapse);
                    calendarchoosetime.setVisibility(View.VISIBLE);
                }else {
                    tvopen.setText("展开账单日历");
                    imgdown_up.setImageResource(R.mipmap.myaccount_page_expand);
                    calendarchoosetime.setVisibility(View.INVISIBLE);
                }
                datajudge=!datajudge;
                break;
        }

    }
}
