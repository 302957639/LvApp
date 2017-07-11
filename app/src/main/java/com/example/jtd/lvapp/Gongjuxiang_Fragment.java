package com.example.jtd.lvapp;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;

import com.example.jtd.lvapp.gongjuxiang.baoxian.BaoxianActivity;
import com.example.jtd.lvapp.gongjuxiang.chuguo.ChuguoActivity;
import com.example.jtd.lvapp.gongjuxiang.information.InformationActivity;
import com.example.jtd.lvapp.gongjuxiang.jizhangben.JizhangbenActivity;
import com.example.jtd.lvapp.gongjuxiang.rate.RateActivity;
import com.example.jtd.lvapp.gongjuxiang.save.SaveActivity;
import com.example.jtd.lvapp.gongjuxiang.start.Start_Lvcheng;
import com.example.jtd.lvapp.gongjuxiang.translation.TranslationActivity;
import com.example.jtd.lvapp.gongjuxiang.view.ViewActivity;
import com.example.jtd.lvapp.gongjuxiang.weather.WeatherActivity;
import com.romainpiel.shimmer.Shimmer;
import com.romainpiel.shimmer.ShimmerTextView;



/**
 * Created by 丁金涛 on 2017/6/9.
 */

public class Gongjuxiang_Fragment extends Fragment implements CompoundButton.OnCheckedChangeListener{
    private LinearLayout layout;
    private ShimmerTextView textView;
    private CheckBox chkweather,chktranslation,chkview,chkjizhangben,chkchuguo,chkinformation,chksave,chkrate,chkbaoxian;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.gongjuxiang_fragment, container, false);
        layout=(LinearLayout)view.findViewById(R.id.tostart);
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(),Start_Lvcheng.class);
                startActivity(intent);
            }
        });
        textView=(ShimmerTextView)view.findViewById(R.id.text_show);
        Shimmer shimmer = new Shimmer();
        shimmer.start(textView);
        shimmer.setDuration(4000);
        shimmer.setStartDelay(1000);
        chkweather=(CheckBox)view.findViewById(R.id.weather);
        chktranslation=(CheckBox)view.findViewById(R.id.translation);
        chkview=(CheckBox)view.findViewById(R.id.view);
        chkjizhangben=(CheckBox)view.findViewById(R.id.jizhangben);
        chkchuguo=(CheckBox)view.findViewById(R.id.chuguo);
        chkinformation=(CheckBox)view.findViewById(R.id.information);
        chksave=(CheckBox)view.findViewById(R.id.save);
        chkrate=(CheckBox)view.findViewById(R.id.rate);
        chkbaoxian=(CheckBox)view.findViewById(R.id.baoxian);
        chkbaoxian.setOnCheckedChangeListener(this);
        chkrate.setOnCheckedChangeListener(this);
        chksave.setOnCheckedChangeListener(this);
        chkinformation.setOnCheckedChangeListener(this);
        chkchuguo.setOnCheckedChangeListener(this);
        chkweather.setOnCheckedChangeListener(this);
        chktranslation.setOnCheckedChangeListener(this);
        chkview.setOnCheckedChangeListener(this);
        chkjizhangben.setOnCheckedChangeListener(this);
        return view;
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        switch (compoundButton.getId()){
            case R.id.weather:
                Intent intent=new Intent(getActivity(), WeatherActivity.class);
                startActivity(intent);
                break;
            case R.id.translation:
                Intent intent_translation=new Intent(getActivity(), TranslationActivity.class);
                startActivity(intent_translation);
                break;
            case R.id.view:
                Intent intent_view=new Intent(getActivity(), ViewActivity.class);
                startActivity(intent_view);
                break;
            case R.id.jizhangben:
                Intent intent_jizhangben=new Intent(getActivity(), JizhangbenActivity.class);
                startActivity(intent_jizhangben);
                break;
            case R.id.chuguo:
                Intent intent_chuguo=new Intent(getActivity(), ChuguoActivity.class);
                startActivity(intent_chuguo);
                break;
            case R.id.information:
                Intent intent_infomation=new Intent(getActivity(), InformationActivity.class);
                startActivity(intent_infomation);
                break;
            case R.id.save:
                Intent intent_save=new Intent(getActivity(), SaveActivity.class);
                startActivity(intent_save);
                break;
            case R.id.rate:
                Intent intent_rate=new Intent(getActivity(), RateActivity.class);
                startActivity(intent_rate);
                break;
            case R.id.baoxian:
                Intent intent_baoxian=new Intent(getActivity(), BaoxianActivity.class);
                startActivity(intent_baoxian);
                break;

        }
    }
}
