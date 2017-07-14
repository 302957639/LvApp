package com.example.jtd.lvapp.gongjuxiang.rate;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.jtd.lvapp.R;
import com.example.jtd.lvapp.gongjuxiang.start.City;
import com.example.jtd.lvapp.gongjuxiang.start.DateActivity;
import com.example.jtd.lvapp.gongjuxiang.start.Start_Lvcheng;
import com.zaaach.citypicker.CityPickerActivity;

import java.util.List;

/**
 * Created by 丁金涛 on 2017/4/27.
 */

public class RateCustomAdapter extends BaseAdapter {
    private List<Rate> datas;
    private Activity activity;
    private int position;

    public int getPosition() {
        return position;
    }

    public RateCustomAdapter(Activity activity, List datas) {
        this.datas = datas;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return datas.size();//返回数据的长度
    }

    @Override
    public Object getItem(int i) {
        return datas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {

        //获取view
        if (view == null) {
            view = LayoutInflater.from(activity).inflate(R.layout.rate_item, null);
        }
        ImageView imgid=(ImageView)view.findViewById(R.id.rate_imgid) ;
        TextView name = (TextView) view.findViewById(R.id.rate_name);
         TextView shurujiage = (TextView) view.findViewById(R.id.rate_shuru);
        TextView dechujiage = (TextView) view.findViewById(R.id.rate_dechu);
        TextView moneyname = (TextView) view.findViewById(R.id.rate_moneyname);
         LinearLayout currency_change=(LinearLayout)view.findViewById(R.id.currency_change);

        Rate rate = datas.get(i);

        imgid.setImageResource(rate.getImgid());
        name.setText(rate.getName());
        shurujiage.setText(rate.getShurujiage());
        dechujiage.setText(rate.getDechujiage());
        moneyname.setText(rate.getMoneyname());
        currency_change.setTag(i);
        currency_change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                position=(Integer) view.getTag();
                Intent intent=new Intent(activity,Rate_CurrencyActivity.class);
                activity.startActivityForResult(intent,1002);
            }
        });

        return view;
    }


}
