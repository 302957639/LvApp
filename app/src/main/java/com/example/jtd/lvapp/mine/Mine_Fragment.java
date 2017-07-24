package com.example.jtd.lvapp.mine;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.nfc.NdefRecord;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jtd.lvapp.CircleImageView.CircleImageView;
import com.example.jtd.lvapp.R;
import com.example.jtd.lvapp.UseHelpActivity;
import com.example.jtd.lvapp.bmob.UserInformation;
import com.example.jtd.lvapp.mine.information.UserInformationActivity;
import com.example.jtd.lvapp.mine.shizhi.ShezhiActivity;

import java.util.List;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;


/**
 * Created by JTD on 2017/7/7.
 */

public class Mine_Fragment extends Fragment implements View.OnClickListener {
    private RadioButton rbtoyouxiang, rbtoshezhi, rbyouji, rbzhangdan, rbshoucang, rbguanzhu;
    private TextView tvdenglu, tvchuce, tvinformation_nicheng;
    private Button btnjizhangben_tongbu, btndaochu, btnzhangdan_tongbu, btnzhushou_tongbu, btnall_tongbu;
    private LinearLayout layoutbaoxiandingdan, layoutusehelp, layoutchange, layoutaddview,addview;
    private View view;
    private SharedPreferences preferences;
    private String name;
    private CircleImageView circle;
    private LinearLayout layoutinformation;
    private ImageView imginformation_sex;
    private UserInformation information;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.mine_fragment, container, false);
        findidandlistener();
        loginstatus();
        return view;
    }

    private void loginstatus() {
        preferences=getActivity().getSharedPreferences("user", Context.MODE_PRIVATE);
        name=preferences.getString("name","");
        if (name.equals("")!=true){
            replace();
        }else {
            layoutchange.setVisibility(View.VISIBLE);
            layoutaddview.removeView(addview);
            super.onResume();
        }
    }

    @Override
    public void onClick(View view) {
        Intent intent_todenglu = new Intent(getActivity(), DengluActivity.class);
        Intent intent_information=new Intent(getActivity(),UserInformationActivity.class);
        switch (view.getId()) {
            case R.id.toyouxiang:
                Intent intent_toyouxiang = new Intent(getActivity(), YouxiangActivity.class);
                startActivity(intent_toyouxiang);
                break;
            case R.id.toshezhi:
                Intent intent_toshezhi = new Intent(getActivity(), ShezhiActivity.class);
                startActivityForResult(intent_toshezhi,1002);
                break;
            case R.id.denglu:
                if (name.equals("")){
                    startActivityForResult(intent_todenglu, 1001);
                }
                break;
            case R.id.youji:
                if (name.equals("")) {
                    startActivityForResult(intent_todenglu, 1001);
                }
                break;
            case R.id.zhangdan:
                break;
            case R.id.shoucang:
                if (name.equals("")) {
                    startActivityForResult(intent_todenglu, 1001);
                }
                break;
            case R.id.guanzhu:
                if (name.equals("")) {
                    startActivityForResult(intent_todenglu, 1001);
                }
                break;
            case R.id.jizhangben_tongbu:
                if (name.equals("")) {
                    startActivityForResult(intent_todenglu, 1001);
                }
                break;
            case R.id.daochu:
                if (name.equals("")) {
                    startActivityForResult(intent_todenglu, 1001);
                }
                break;
            case R.id.zhangdan_tongbu:
                if (name.equals("")) {
                    startActivityForResult(intent_todenglu, 1001);
                }
                break;
            case R.id.zhushou_tongbu:
                if (name.equals("")) {
                    startActivityForResult(intent_todenglu, 1001);
                }
                break;
            case R.id.all_tongbu:
                if (name.equals("")) {
                    startActivityForResult(intent_todenglu, 1001);
                }
                break;
            case R.id.baoxiandingdan:
                if (name.equals("")) {
                    startActivityForResult(intent_todenglu, 1001);
                }
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
                startActivityForResult(intent_information,1003);
                break;
            case R.id.touxiang:
                startActivityForResult(intent_information,1003);
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1001 && resultCode == 2001) {
            loginstatus();
        }
        if (requestCode==1002 && resultCode==2001){
            loginstatus();
        }
        if (requestCode==1003 && resultCode==2001){
            int imgid = data.getIntExtra("touxiang", 0);
            String nicheng = data.getStringExtra("nicheng");
            String sex = data.getStringExtra("sex");
            circle.setImageResource(imgid);
            tvinformation_nicheng.setText(nicheng);
            choosesex(sex);
        }
    }


    private void choosesex(String sex) {
        switch (sex) {
            case "男":
                if (imginformation_sex.getVisibility() == View.GONE) {
                    imginformation_sex.setVisibility(View.VISIBLE);
                    imginformation_sex.setImageResource(R.mipmap.user_center_sex_man_icon);
                }
                imginformation_sex.setImageResource(R.mipmap.user_center_sex_man_icon);
                break;
            case "女":
                if (imginformation_sex.getVisibility() == View.GONE) {
                    imginformation_sex.setVisibility(View.VISIBLE);
                    imginformation_sex.setImageResource(R.mipmap.user_center_sex_woman_icon);
                }
                imginformation_sex.setImageResource(R.mipmap.user_center_sex_woman_icon);
                break;
            case "其他":
                imginformation_sex.setVisibility(View.GONE);
                break;
        }
    }
    private void replace() {
        Bmob.initialize(getActivity(), "b6bd29e7a74a0fddeb82660590ad0678");

        layoutchange.setVisibility(View.GONE);
        LayoutInflater inflater = getActivity().getLayoutInflater();
        addview = (LinearLayout) inflater.inflate(R.layout.mine_changeview, null);
        layoutaddview.addView(addview);
        layoutinformation = addview.findViewById(R.id.information);
        layoutinformation.setOnClickListener(this);
        tvinformation_nicheng = addview.findViewById(R.id.information_nicheng);
        imginformation_sex = addview.findViewById(R.id.information_sex);
        circle = addview.findViewById(R.id.touxiang);
        circle.setOnClickListener(this);

        BmobQuery<UserInformation> query = new BmobQuery<UserInformation>();
        query.addWhereEqualTo("name", name);
        query.findObjects(new FindListener<UserInformation>() {
            @Override
            public void done(List<UserInformation> list, BmobException e) {
                if (e == null) {
                    if (list.size() == 1) {
                        information = list.get(0);
                        circle.setImageResource(information.getImgid());
                        tvinformation_nicheng.setText(information.getNicheng());
                        String sex = information.getSex();
                        choosesex(sex);
                    } else {
                        circle.setImageResource(R.mipmap.qq);
                    }
                }
            }
        });
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
