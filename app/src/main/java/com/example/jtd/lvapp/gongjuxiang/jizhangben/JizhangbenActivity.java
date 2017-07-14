package com.example.jtd.lvapp.gongjuxiang.jizhangben;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.jtd.lvapp.R;
import com.example.jtd.lvapp.gongjuxiang.start.DateActivity;

import java.util.Calendar;

/**
 * Created by JTD on 2017/7/8.
 */

public class JizhangbenActivity extends AppCompatActivity implements View.OnClickListener{
    private RadioButton rbback,rbtomouth;
    private LinearLayout layoutchoose;
    private ImageButton toadd;
    private TextView tvnowtime,tvnowweek;
    private int year,mouth;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jizhangben);
        rbback=(RadioButton)findViewById(R.id.back);
        rbback.setOnClickListener(this);
        layoutchoose=(LinearLayout)findViewById(R.id.choosedate);
        layoutchoose.setOnClickListener(this);
        tvnowtime=(TextView)findViewById(R.id.nowtime);
        tvnowweek=(TextView)findViewById(R.id.nowweek);
        rbtomouth=(RadioButton)findViewById(R.id.tomouth);
        rbtomouth.setOnClickListener(this);
        toadd=(ImageButton)findViewById(R.id.toadd);
        toadd.setOnClickListener(this);
        Calendar calendar = Calendar.getInstance();
        int nowyear = calendar.get(Calendar.YEAR);
        int nowmonth = calendar.get(Calendar.MONTH) + 1;// Java月份从0开始算
        int nowday = calendar.get(Calendar.DAY_OF_MONTH);
        String time=nowyear+"/"+nowmonth+"/"+nowday;
        tvnowtime.setText(time);
        calendar.set(Calendar.DAY_OF_MONTH, nowday);  //指定日
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        Showweek(dayOfWeek);
        year=nowyear;
        mouth=nowmonth;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.back:
                finish();
                break;
            case R.id.choosedate:
                Intent intent_date=new Intent(this, DateActivity.class);
                startActivityForResult(intent_date,1001);
                break;
            case R.id.tomouth:
                Intent intent_mouth=new Intent(this,MouthAvtivity.class);
                intent_mouth.putExtra("year",year);
                intent_mouth.putExtra("mouth",mouth);
                startActivity(intent_mouth);
                break;
            case R.id.toadd:
                Intent intent_add=new Intent(this,AddxiaofeiActivity.class);
                startActivity(intent_add);
                break;
        }
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==1001&&resultCode==2001){
             String date=data.getStringExtra("date");
             int day=data.getIntExtra("day",1);
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.DAY_OF_MONTH, day);  //指定日
            int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
            tvnowtime.setText(date);
            Showweek(dayOfWeek);
            year=data.getIntExtra("year",1);
            mouth=data.getIntExtra("mouth",1)+1;
        }
    }
    public void Showweek(int weekday){
        switch (weekday)
        {
            case 1:
                tvnowweek.setText("周日");
                break;
            case 2:
                tvnowweek.setText("周一");
                break;
            case 3:
                tvnowweek.setText("周二");
                break;
            case 4:
                tvnowweek.setText("周三");
                break;
            case 5:
                tvnowweek.setText("周四");
                break;
            case 6:
                tvnowweek.setText("周五");
                break;
            case 7:
                tvnowweek.setText("周六");
                break;
        }
    }
}
