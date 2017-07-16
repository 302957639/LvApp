package com.example.jtd.lvapp.gongjuxiang.translation;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jtd.lvapp.R;
import com.example.jtd.lvapp.gongjuxiang.rate.Rate;

import java.util.Date;
import java.util.List;

/**
 * Created by JTD on 2017/7/15.
 */

public class LanguageAdapter extends BaseAdapter {
    private List<Language> datas;
    private Context context;


    public LanguageAdapter(List<Language> datas, Context context) {
        this.datas = datas;
        this.context = context;
    }

    @Override
    public int getCount() {
        return datas.size();
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
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view==null){
            view=View.inflate(context, R.layout.language_item,null);
        }
        ImageView imageView=view.findViewById(R.id.language_img);
        TextView textView=view.findViewById(R.id.language_language);
        ImageView choose=view.findViewById(R.id.language_choose);

        Language language=datas.get(i);

        imageView.setImageResource(language.getImgid());
        textView.setText(language.getLanguage());

        return view;
    }
}
