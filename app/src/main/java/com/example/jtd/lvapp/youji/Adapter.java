package com.example.jtd.lvapp.youji;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.jtd.lvapp.youji.entity.Province;

import java.util.List;

/**
 * Created by JTD on 2017/7/13.
 */

public class Adapter<T extends Province> extends BaseAdapter {
    private List<T> array;
    private Activity activity;


    public Adapter(List<T> array, Activity activity) {
        this.array = array;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return array.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = View.inflate(activity, android.R.layout.simple_list_item_1, null);
        }
        TextView tv = view.findViewById(android.R.id.text1);
        tv.setText(array.get(i).getName());
        return view;
    }
}
