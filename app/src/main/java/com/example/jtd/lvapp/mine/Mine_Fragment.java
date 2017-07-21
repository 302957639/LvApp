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
import com.example.jtd.lvapp.mine.information.UserInformationActivity;
import com.example.jtd.lvapp.mine.shizhi.ShezhiActivity;

/**
 * Created by JTD on 2017/7/7.
 */

public class Mine_Fragment extends Fragment implements View.OnClickListener {
    private RadioButton rbtoyouxiang, rbtoshezhi, rbyouji, rbzhangdan, rbshoucang, rbguanzhu;
    private TextView tvdenglu, tvchuce;
    private Button btnjizhangben_tongbu, btndaochu, btnzhangdan_tongbu, btnzhushou_tongbu, btnall_tongbu;
    private LinearLayout layoutbaoxiandingdan, layoutusehelp, layoutchange, layoutaddview,addview;
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.mine_fragment, container, false);
        findidandlistener();
        return view;
    }

    @Override
    public void onClick(View view) {
        Intent intent_todenglu = new Intent(getActivity(), DengluActivity.class);
        switch (view.getId()) {
            case R.id.toyouxiang:
                Intent intent_toyouxiang = new Intent(getActivity(), YouxiangActivity.class);
                startActivity(intent_toyouxiang);
                break;
            case R.id.toshezhi:
                Intent intent_toshezhi = new Intent(getActivity(), ShezhiActivity.class);
                startActivity(intent_toshezhi);
                break;
            case R.id.denglu:
                startActivityForResult(intent_todenglu, 1001);
                break;
            case R.id.youji:
                startActivityForResult(intent_todenglu, 1001);
                break;
            case R.id.zhangdan:
                break;
            case R.id.shoucang:
                startActivityForResult(intent_todenglu, 1001);
                break;
            case R.id.guanzhu:
                startActivityForResult(intent_todenglu, 1001);
                break;
            case R.id.jizhangben_tongbu:
                startActivityForResult(intent_todenglu, 1001);
                break;
            case R.id.daochu:
                startActivityForResult(intent_todenglu, 1001);
                break;
            case R.id.zhangdan_tongbu:
                startActivityForResult(intent_todenglu, 1001);
                break;
            case R.id.zhushou_tongbu:
                startActivityForResult(intent_todenglu, 1001);
                break;
            case R.id.all_tongbu:
                startActivityForResult(intent_todenglu, 1001);
                break;
            case R.id.baoxiandingdan:
                startActivityForResult(intent_todenglu, 1001);
                break;
            case R.id.chuce:
                Intent intent_chuce = new Intent(getActivity(), ZhuceActivity.class);
                startActivityForResult(intent_chuce,1001);
                break;
            case R.id.usehelp:
                Intent intent_usehelp = new Intent(getActivity(), UseHelpActivity.class);
                startActivity(intent_usehelp);
                break;
            case R.id.information:
                Intent intent_information=new Intent(getActivity(),UserInformationActivity.class);
                startActivity(intent_information);
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1001 && resultCode == 2001) {
            replace();

        }
    }

    private void replace() {
        layoutchange.setVisibility(View.GONE);
        LayoutInflater inflater = getActivity().getLayoutInflater();
        addview = (LinearLayout) inflater.inflate(R.layout.mine_changeview, null);
        layoutaddview.addView(addview);
        LinearLayout layoutinformation=addview.findViewById(R.id.information);
        layoutinformation.setOnClickListener(this);
    }
    private void findidandlistener(){
        rbtoyouxiang = view.findViewById(R.id.toyouxiang);
        rbtoshezhi = view.findViewById(R.id.toshezhi);
        rbtoshezhi.setOnClickListener(this);
        rbtoyouxiang.setOnClickListener(this);
        tvdenglu = view.findViewById(R.id.denglu);
        tvdenglu.setOnClickListener(this);
        rbyouji = view.findViewById(R.id.youji);
        rbyouji.setOnClickListener(this);
        rbzhangdan = view.findViewById(R.id.zhangdan);
        rbzhangdan.setOnClickListener(this);
        rbshoucang = view.findViewById(R.id.shoucang);
        rbshoucang.setOnClickListener(this);
        rbguanzhu = view.findViewById(R.id.guanzhu);
        rbguanzhu.setOnClickListener(this);
        btnjizhangben_tongbu = view.findViewById(R.id.jizhangben_tongbu);
        btnjizhangben_tongbu.setOnClickListener(this);
        btndaochu = view.findViewById(R.id.daochu);
        btndaochu.setOnClickListener(this);
        btnzhangdan_tongbu = view.findViewById(R.id.zhangdan_tongbu);
        btnzhangdan_tongbu.setOnClickListener(this);
        btnzhushou_tongbu = view.findViewById(R.id.zhushou_tongbu);
        btnzhushou_tongbu.setOnClickListener(this);
        btnall_tongbu =  view.findViewById(R.id.all_tongbu);
        btnall_tongbu.setOnClickListener(this);
        layoutbaoxiandingdan =  view.findViewById(R.id.baoxiandingdan);
        layoutbaoxiandingdan.setOnClickListener(this);
        tvchuce =  view.findViewById(R.id.chuce);
        tvchuce.setOnClickListener(this);
        layoutusehelp =  view.findViewById(R.id.usehelp);
        layoutusehelp.setOnClickListener(this);
        layoutchange =  view.findViewById(R.id.changelayout);
        layoutaddview =  view.findViewById(R.id.addview);
    }
}
