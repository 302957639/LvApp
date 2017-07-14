package com.example.jtd.lvapp.gongjuxiang.rate;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RadioButton;

import com.example.jtd.lvapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JTD on 2017/7/10.
 */

public class Rate_CurrencyActivity extends AppCompatActivity implements View.OnClickListener {
    private List<Currency> datas;
    private CurrencyCustomAdapter adapter;
    private ListView listView;
    private RadioButton rbback;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate_currency);
        datas = new ArrayList<>();
        datas.add(new Currency(R.mipmap.exrate_page_flag_cny, "人民币", "CNY"));
        datas.add(new Currency(R.mipmap.exrate_page_flag_hkd, "港币", "HKD"));
        datas.add(new Currency(R.mipmap.exrate_page_flag_mop, "澳门币", "MOP"));
        datas.add(new Currency(R.mipmap.exrate_page_flag_twd, "新台币", "TWD"));
        datas.add(new Currency(R.mipmap.exrate_page_flag_usd, "美元", "USD"));
        datas.add(new Currency(R.mipmap.exrate_page_flag_gbp, "英镑", "GBP"));
        datas.add(new Currency(R.mipmap.exrate_page_flag_jpy, "日元", "JPY"));
        datas.add(new Currency(R.mipmap.exrate_page_flag_eur, "欧元", "EUR"));
        datas.add(new Currency(R.mipmap.exrate_page_flag_krw, "韩元", "KRW"));
        datas.add(new Currency(R.mipmap.exrate_page_flag_thb, "泰铢", "THB"));
        datas.add(new Currency(R.mipmap.exrate_page_flag_sgd, "新加坡元", "SGD"));
        datas.add(new Currency(R.mipmap.exrate_page_flag_idr, "印尼盾", "IDR"));
        datas.add(new Currency(R.mipmap.exrate_page_flag_rub, "俄罗斯卢布", "RUB"));
        datas.add(new Currency(R.mipmap.exrate_page_flag_aud, "澳大利亚元", "AUD"));
        datas.add(new Currency(R.mipmap.exrate_page_flag_chf, "瑞士法郎", "CHF"));
        datas.add(new Currency(R.mipmap.exrate_page_flag_nzd, "新西兰元", "NZD"));
        datas.add(new Currency(R.mipmap.exrate_page_flag_php, "菲律宾比索", "PHP"));
        datas.add(new Currency(R.mipmap.exrate_page_flag_vnd, "越南盾", "VND"));
        datas.add(new Currency(R.mipmap.exrate_page_flag_mvr, "马尔代夫卢比", "MVR"));
        datas.add(new Currency(R.mipmap.exrate_page_flag_myr, "马元", "MYR"));
        datas.add(new Currency(R.mipmap.exrate_page_flag_npr, "尼泊尔卢比", "NPR"));
        datas.add(new Currency(R.mipmap.exrate_page_flag_cad, "加元", "CAD"));
        datas.add(new Currency(R.mipmap.exrate_page_flag_ars, "阿根廷比索", "ARS"));
        datas.add(new Currency(R.mipmap.exrate_page_flag_mxn, "墨西哥比索", "MXN"));
        datas.add(new Currency(R.mipmap.exrate_page_flag_inr, "卢比", "INR"));
        datas.add(new Currency(R.mipmap.exrate_page_flag_zar, "兰特", "ZAR"));
        datas.add(new Currency(R.mipmap.exrate_page_flag_mad, "摩洛哥迪拉姆", "MAD"));
        datas.add(new Currency(R.mipmap.exrate_page_flag_try, "土耳其里拉", "TRY"));
        datas.add(new Currency(R.mipmap.exrate_page_flag_brl, "巴西雷亚尔", "BRL"));
        datas.add(new Currency(R.mipmap.exrate_page_flag_kes, "肯尼亚先令", "KES"));
        datas.add(new Currency(R.mipmap.exrate_page_flag_uah, "乌克兰格里夫纳", "UAH"));
        datas.add(new Currency(R.mipmap.exrate_page_flag_egp, "埃及镑", "EGP"));
        datas.add(new Currency(R.mipmap.exrate_page_flag_aed, "阿联酋迪拉姆", "AED"));


        adapter = new CurrencyCustomAdapter(Rate_CurrencyActivity.this, datas);
        listView = (ListView) findViewById(R.id.currency_show);
        listView.setAdapter(adapter);
        rbback = (RadioButton) findViewById(R.id.back);
        rbback.setOnClickListener(this);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Currency currency = datas.get(i);
                int imgid = currency.getImgid();
                String name = currency.getName();
                String jiancheng = currency.getJiancheng();
                Intent intent = new Intent();
                intent.putExtra("imgid", imgid);
                intent.putExtra("name", name);
                intent.putExtra("jiancheng", jiancheng);
                setResult(2001, intent);
                finish();
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
        }
    }
}
