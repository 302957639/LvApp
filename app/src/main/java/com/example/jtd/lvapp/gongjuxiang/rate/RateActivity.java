package com.example.jtd.lvapp.gongjuxiang.rate;

import android.content.Intent;
import android.icu.util.*;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.jtd.lvapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JTD on 2017/7/9.
 */

public class RateActivity extends AppCompatActivity implements View.OnClickListener{
    private RadioButton rbback;
    private List<Rate> datas;
    private RateCustomAdapter adapter;
    private ListView listView;
    private ImageView imgchoosecurrency;
    private TextView tvratename,tvratejiancheng;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.avtivity_rate);
        rbback=(RadioButton)findViewById(R.id.back);
        rbback.setOnClickListener(this);
        datas = new ArrayList<>();
        datas.add(new Rate(R.mipmap.exrate_page_flag_usd,"USD","0","0.00","美元"));
        datas.add(new Rate(R.mipmap.exrate_page_flag_cny,"CNY","0","0.00","人民币"));
        datas.add(new Rate(R.mipmap.exrate_page_flag_hkd,"HKD","0","0.00","港币"));
        datas.add(new Rate(R.mipmap.exrate_page_flag_gbp,"GBP","0","0.00","英镑"));

        adapter = new RateCustomAdapter(RateActivity.this, datas);
        listView=(ListView)findViewById(R.id.rate_show);
        listView.setAdapter(adapter);
        imgchoosecurrency=(ImageView)findViewById(R.id.choosecurrency);
        imgchoosecurrency.setOnClickListener(this);
        tvratename=(TextView)findViewById(R.id.ratename);
        tvratejiancheng=(TextView)findViewById(R.id.ratejiancheng);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.back:
                finish();
                break;
            case R.id.choosecurrency:
                Intent intent_currency=new Intent(this,Rate_CurrencyActivity.class);
                startActivityForResult(intent_currency,1001);
                break;

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode==2001){
            int imgid=data.getIntExtra("imgid",R.mipmap.exrate_page_flag_zar);
            String name=data.getStringExtra("name");
            String jiecheng=data.getStringExtra("jiancheng");
            switch (requestCode){
                case 1001:
                    imgchoosecurrency.setImageResource(imgid);
                    tvratename.setText(name);
                    tvratejiancheng.setText(jiecheng);
                    break;
                case 1002:
                    int position = adapter.getPosition();
                    Rate rate=datas.get(position);
                    rate.setImgid(imgid);
                    rate.setName(name);
                    rate.setMoneyname(jiecheng);
                    adapter.notifyDataSetChanged();
                    break;
            }
        }
    }
}
