package com.example.jtd.lvapp.gongjuxiang.rate;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jtd.lvapp.R;

import java.util.List;

/**
 * Created by 丁金涛 on 2017/4/27.
 */

public class CurrencyCustomAdapter extends BaseAdapter {
    private List<Currency> datas;
    private Activity activity;

    public CurrencyCustomAdapter(Activity activity, List datas) {
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
            view = LayoutInflater.from(activity).inflate(R.layout.rate_currency_item, null);
        }
        ImageView image=(ImageView)view.findViewById(R.id.currency_image) ;
        TextView name = (TextView) view.findViewById(R.id.currency_name);
        TextView jiancheng = (TextView) view.findViewById(R.id.currency_jiancheng);



        Currency currency = datas.get(i);

        image.setImageResource(currency.getImgid());
        name.setText(currency.getName());
        jiancheng.setText(currency.getJiancheng());


        return view;
    }


}
