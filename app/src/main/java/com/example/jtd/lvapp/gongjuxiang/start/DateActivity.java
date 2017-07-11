package com.example.jtd.lvapp.gongjuxiang.start;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.CalendarView;
import android.widget.CompoundButton;
import android.widget.RadioButton;


import com.example.jtd.lvapp.R;

import java.util.Calendar;
import java.util.Date;


/**
 * Created by 丁金涛 on 2017/7/1.
 */

public class DateActivity extends AppCompatActivity {
    private CalendarView cvdate;
    private RadioButton radioButton;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date);
        cvdate=(CalendarView)findViewById(R.id.date);
        radioButton=(RadioButton)findViewById(R.id.back_start_lvcheng);
        radioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                finish();
            }
        });
        cvdate.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int mouth, int day) {
                String date;
                date= year+"/"+(mouth+1)+"/"+day;
                Intent intent=new Intent();
                intent.putExtra("date",date);
                intent.putExtra("day",day);
                setResult(2001,intent);
                finish();
            }
        });

    }
}
