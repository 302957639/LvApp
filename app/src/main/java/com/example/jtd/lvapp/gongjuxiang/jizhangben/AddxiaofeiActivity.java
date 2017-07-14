package com.example.jtd.lvapp.gongjuxiang.jizhangben;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.jtd.lvapp.R;
import com.example.jtd.lvapp.gongjuxiang.rate.Rate_CurrencyActivity;
import com.example.jtd.lvapp.gongjuxiang.start.DateActivity;
import com.example.jtd.lvapp.gongjuxiang.start.Start_Lvcheng;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by JTD on 2017/7/9.
 */

public class AddxiaofeiActivity extends AppCompatActivity implements View.OnClickListener{
    private View viewfirst,viewsecond;
    private ViewPager viewPager;
    private List<View> viewList;
    private LinearLayout linearLayout,layouttimechoose,layoutbizhongchoose;
    Button mPreSelectedBt;
    private RadioButton rbcanyin,rbjiaotong,rbgouwu,rbyule,rbmeirong,rbzhusu,rbmenpiao,rbyiliao,rbbaoxian,rbqita,rbback;
    private RadioGroup groupfirst,groupsecond;
    private TextView tvtime,tvbizhongshow;
    private int mYear,mMonth,mDay;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addxiaofei);
        viewPager = (ViewPager) findViewById(R.id.addshow);
        linearLayout=(LinearLayout)findViewById(R.id.pointadd);
        LayoutInflater inflater=getLayoutInflater();
        viewfirst = inflater.inflate(R.layout.addxiaofei_view_first, null);
        viewsecond = inflater.inflate(R.layout.addxiaofei_view_second,null);
        groupfirst=(RadioGroup)viewfirst.findViewById(R.id.viewfirst) ;
        rbcanyin=(RadioButton)viewfirst.findViewById(R.id.canyin);
        rbjiaotong=(RadioButton)viewfirst.findViewById(R.id.jiaotong);
        rbgouwu=(RadioButton)viewfirst.findViewById(R.id.gouwu);
        rbyule=(RadioButton)viewfirst.findViewById(R.id.yule);
        rbmeirong=(RadioButton)viewfirst.findViewById(R.id.meirong);

        groupsecond=(RadioGroup)viewsecond.findViewById(R.id.viewsecond) ;
        rbzhusu=(RadioButton)viewsecond.findViewById(R.id.zhusu);
        rbmenpiao=(RadioButton)viewsecond.findViewById(R.id.menpiao);
        rbyiliao=(RadioButton)viewsecond.findViewById(R.id.yiliao);
        rbbaoxian=(RadioButton)viewsecond.findViewById(R.id.baoxian);
        rbqita=(RadioButton)viewsecond.findViewById(R.id.qita);

        layoutbizhongchoose=(LinearLayout)findViewById(R.id.bizhongchoose);
        layoutbizhongchoose.setOnClickListener(this);
        tvbizhongshow=(TextView)findViewById(R.id.bizhongshow);

        rbcanyin.setChecked(true);
        layouttimechoose=(LinearLayout)findViewById(R.id.timechoose);
        layouttimechoose.setOnClickListener(this);
        tvtime=(TextView)findViewById(R.id.timeshow) ;
        Calendar c = Calendar.getInstance();//
        mYear = c.get(Calendar.YEAR); // 获取当前年份
        mMonth = c.get(Calendar.MONTH) + 1;// 获取当前月份
        mDay = c.get(Calendar.DAY_OF_MONTH);// 获取当日期

        String time = mYear + "/" + mMonth + "/" + mDay;

        tvtime.setText(time);
        rbback=(RadioButton)findViewById(R.id.back);
        rbback.setOnClickListener(this);

        groupfirst.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int id) {
                if (id==rbcanyin.getId()){

                }
                if (id==rbjiaotong.getId()){

                }
            }
        });
        groupsecond.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int id) {
                if (id==rbzhusu.getId()){

                }
            }
        });

        viewList = new ArrayList<View>();// 将要分页显示的View装入数组中
        viewList.add(viewfirst);
        viewList.add(viewsecond);

        Bitmap bitmap = BitmapFactory. decodeResource(getResources(), R.mipmap.page_tag_selected_icon );
        for (int i = 0; i < viewList.size(); i++) {
            Button bt = new Button(this );
            bt.setLayoutParams( new ViewGroup.LayoutParams(bitmap.getWidth(),bitmap.getHeight()));
            bt.setBackgroundResource(R.mipmap.page_tag_default_icon  );
            linearLayout .addView(bt);
        }
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {

                if(mPreSelectedBt != null){
                    mPreSelectedBt.setBackgroundResource(R.mipmap.page_tag_default_icon );
                }

                Button currentBt = (Button)linearLayout.getChildAt(position);
                currentBt.setBackgroundResource(R.mipmap.page_tag_selected_icon );
                mPreSelectedBt = currentBt;

                //Log.i("INFO", "current item:"+position);
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
                // TODO Auto-generated method stub

            }
        });



        PagerAdapter pagerAdapter = new PagerAdapter() {

            @Override
            public boolean isViewFromObject(View arg0, Object arg1) {
                // TODO Auto-generated method stub
                return arg0 == arg1;
            }

            @Override
            public int getCount() {
                // TODO Auto-generated method stub
                return viewList.size();
            }

            @Override
            public void destroyItem(ViewGroup container, int position,
                                    Object object) {
                // TODO Auto-generated method stub
                container.removeView(viewList.get(position));
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                // TODO Auto-generated method stub
                container.addView(viewList.get(position));


                return viewList.get(position);
            }
        };


        viewPager.setAdapter(pagerAdapter);
    }


    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.timechoose:
                Intent intent_date = new Intent(AddxiaofeiActivity.this, DateActivity.class);
                startActivityForResult(intent_date, 1001);
                break;
            case R.id.back:
                finish();
                break;
            case R.id.bizhongchoose:
                Intent intent_currency = new Intent(AddxiaofeiActivity.this, Rate_CurrencyActivity.class);
                startActivityForResult(intent_currency,1002);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==1001&&resultCode==2001){
            String time = data.getStringExtra("date");
            tvtime.setText(time);
        }
        if (requestCode==1002&&resultCode==2001){
            String name=data.getStringExtra("name");
            tvbizhongshow.setText(name);
        }
    }
}
