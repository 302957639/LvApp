package com.example.jtd.lvapp.mine;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.jtd.lvapp.R;
import com.example.jtd.lvapp.UseHelpActivity;

/**
 * Created by JTD on 2017/7/7.
 */

public class Mine_Fragment extends Fragment implements View.OnClickListener{
    private RadioButton rbtoyouxiang,rbtoshezhi,rbyouji,rbzhangdan,rbshoucang,rbguanzhu;
    private TextView tvdenglu,tvchuce;
    private Button btnjizhangben_tongbu,btndaochu,btnzhangdan_tongbu,btnzhushou_tongbu,btnall_tongbu;
    private LinearLayout layoutbaoxiandingdan,layoutusehelp;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.mine_fragment, container, false);
        rbtoyouxiang=(RadioButton)view.findViewById(R.id.toyouxiang);
        rbtoshezhi=(RadioButton)view.findViewById(R.id.toshezhi);
        rbtoshezhi.setOnClickListener(this);
        rbtoyouxiang.setOnClickListener(this);
        tvdenglu=(TextView)view.findViewById(R.id.denglu);
        tvdenglu.setOnClickListener(this);
        rbyouji=(RadioButton)view.findViewById(R.id.youji);
        rbyouji.setOnClickListener(this);
        rbzhangdan=(RadioButton)view.findViewById(R.id.zhangdan);
        rbzhangdan.setOnClickListener(this);
        rbshoucang=(RadioButton)view.findViewById(R.id.shoucang);
        rbshoucang.setOnClickListener(this);
        rbguanzhu=(RadioButton)view.findViewById(R.id.guanzhu);
        rbguanzhu.setOnClickListener(this);
        btnjizhangben_tongbu=(Button)view.findViewById(R.id.jizhangben_tongbu);
        btnjizhangben_tongbu.setOnClickListener(this);
        btndaochu=(Button)view.findViewById(R.id.daochu);
        btndaochu.setOnClickListener(this);
        btnzhangdan_tongbu=(Button)view.findViewById(R.id.zhangdan_tongbu);
        btnzhangdan_tongbu.setOnClickListener(this);
        btnzhushou_tongbu=(Button)view.findViewById(R.id.zhushou_tongbu);
        btnzhushou_tongbu.setOnClickListener(this);
        btnall_tongbu=(Button)view.findViewById(R.id.all_tongbu);
        btnall_tongbu.setOnClickListener(this);
        layoutbaoxiandingdan=(LinearLayout)view.findViewById(R.id.baoxiandingdan);
        layoutbaoxiandingdan.setOnClickListener(this);
        tvchuce=(TextView)view.findViewById(R.id.chuce);
        tvchuce.setOnClickListener(this);
        layoutusehelp=(LinearLayout)view.findViewById(R.id.usehelp);
        layoutusehelp.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        Intent intent_todenglu=new Intent(getActivity(),DengluActivity.class);
        switch (view.getId()){
            case R.id.toyouxiang:
                Intent intent_toyouxiang=new Intent(getActivity(),YouxiangActivity.class);
                startActivity(intent_toyouxiang);
                break;
            case R.id.toshezhi:
                Intent intent_toshezhi=new Intent(getActivity(),ShezhiActivity.class);
                startActivity(intent_toshezhi);
                break;
            case R.id.denglu:
                startActivity(intent_todenglu);
                break;
            case R.id.youji:
                startActivity(intent_todenglu);
                break;
            case R.id.zhangdan:
                break;
            case R.id.shoucang:
                startActivity(intent_todenglu);
                break;
            case R.id.guanzhu:
                startActivity(intent_todenglu);
                break;
            case R.id.jizhangben_tongbu:
                startActivity(intent_todenglu);
                break;
            case R.id.daochu:
                startActivity(intent_todenglu);
                break;
            case R.id.zhangdan_tongbu:
                startActivity(intent_todenglu);
                break;
            case R.id.zhushou_tongbu:
                startActivity(intent_todenglu);
                break;
            case R.id.all_tongbu:
                startActivity(intent_todenglu);
                break;
            case R.id.baoxiandingdan:
                startActivity(intent_todenglu);
                break;
            case R.id.chuce:
                Intent intent_chuce=new Intent(getActivity(),ZhuceActivity.class);
                startActivity(intent_chuce);
                break;
            case R.id.usehelp:
                Intent intent_usehelp=new Intent(getActivity(),UseHelpActivity.class);
                startActivity(intent_usehelp);
                break;
        }
    }
}
