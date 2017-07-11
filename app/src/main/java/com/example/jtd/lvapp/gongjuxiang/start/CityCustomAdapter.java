package com.example.jtd.lvapp.gongjuxiang.start;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.jtd.lvapp.R;
import com.zaaach.citypicker.CityPickerActivity;


import java.util.List;

/**
 * Created by 丁金涛 on 2017/4/27.
 */

public class CityCustomAdapter extends BaseAdapter {
    private List<City> datas;
    private Activity activity;
    private int position;
    private int timeid;
    private int time2id;
    private int deleteid;
    private int flag=0;

    public void setFlag(int flag) {
        this.flag = flag;
    }

    private RadioButton radioButton;
    public int getDeleteid() {
        return deleteid;
    }

    private static final int REQUEST_CODE_PICK_CITY = 0;

    public int getPosition() {
        return position;
    }

    public int getTimeid() {
        return timeid;
    }

    public int getTime2id() {
        return time2id;
    }

    public CityCustomAdapter(Activity activity, List datas) {
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
            view = LayoutInflater.from(activity).inflate(R.layout.final_add, null);
        }
        TextView mudidi = (TextView) view.findViewById(R.id.mudidi);
        TextView choose = (TextView) view.findViewById(R.id.choose);
        TextView time1 = (TextView) view.findViewById(R.id.time1);
        TextView time2 = (TextView) view.findViewById(R.id.time2);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.addmudidi);
        radioButton = (RadioButton) view.findViewById(R.id.delete_item);
        City city = datas.get(i);
        if (flag==0) {
            radioButton.setVisibility(View.GONE);
        }else {
            radioButton.setVisibility(View.VISIBLE);
        }
        mudidi.setText(city.getMudidi());
        choose.setText(city.getChoose());

        time1.setText(city.getTime1());

        time2.setText(city.getTime2());

        linearLayout.setTag(i);
        time1.setTag(i);
        time2.setTag(i);
        radioButton.setTag(i);

        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                position = (Integer) view.getTag();
                Intent intent = new Intent(activity, CityPickerActivity.class);
                activity.startActivityForResult(intent, 3001);
            }
        });
        time1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timeid = (Integer) view.getTag();
                Intent intent = new Intent(activity, DateActivity.class);
                activity.startActivityForResult(intent, 1002);

            }
        });
        time2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                time2id = (Integer) view.getTag();
                Intent intent = new Intent(activity, DateActivity.class);
                activity.startActivityForResult(intent, 1003);
            }
        });


        radioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (datas.size() > 1) {
                    flag=1;
                    deleteid = (Integer) view.getTag();
                    datas.remove(deleteid);
                    for (int i = 0; i < datas.size(); i++) {
                        City city = datas.get(i);
                        city.setMudidi("目的地" + (i + 1));
                    }
                    CityCustomAdapter.this.notifyDataSetChanged();
                }
            }
        });
        //当datas只有一个的时候
        if (getCount()==1){
            ((Start_Lvcheng) activity).cbbianji.setText("编辑");
            ((Start_Lvcheng) activity).cbbianji.setVisibility(View.GONE);
            ((Start_Lvcheng) activity).cbbianji.setChecked(false);
            ((Start_Lvcheng)activity).btnstart.setBackgroundResource(R.color.colorstart);
            ((Start_Lvcheng)activity).btnstart.setTextColor(Color.parseColor("#ffffff"));
             radioButton.setVisibility(View.GONE);

        }


        return view;
    }


}
