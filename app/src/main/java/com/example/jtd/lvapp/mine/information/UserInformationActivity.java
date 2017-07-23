package com.example.jtd.lvapp.mine.information;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.health.TimerStat;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.jtd.lvapp.R;
import com.example.jtd.lvapp.mine.ChongzhimimaActivity;
import com.zaaach.citypicker.CityPickerActivity;

/**
 * Created by JTD on 2017/7/20.
 */

public class UserInformationActivity extends AppCompatActivity implements View.OnClickListener{
    private RadioButton rbback;
    private LinearLayout layoutnicheng,layoutyouxiang,layoutchangemima,layoutresidence,layoutsexchoose;
    private TextView tvresidence_show,tvnicheng_show,tvyouxiang_show,tvsex_show,tvnumber;
    private SharedPreferences preferences;
    private String name;
    private Button  btnsure;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mine_user_information);
        rbback=(RadioButton)findViewById(R.id.back);
        rbback.setOnClickListener(this);
        layoutnicheng=(LinearLayout)findViewById(R.id.tonicheng);
        layoutnicheng.setOnClickListener(this);
        layoutyouxiang=(LinearLayout)findViewById(R.id.toyouxiang);
        layoutyouxiang.setOnClickListener(this);
        layoutchangemima=(LinearLayout)findViewById(R.id.tochangemima);
        layoutchangemima.setOnClickListener(this);
        layoutresidence=(LinearLayout)findViewById(R.id.residence);
        layoutresidence.setOnClickListener(this);
        layoutsexchoose=(LinearLayout)findViewById(R.id.sexchoose);
        layoutsexchoose.setOnClickListener(this);
        btnsure=(Button)findViewById(R.id.sure);
        btnsure.setOnClickListener(this);

        tvresidence_show=(TextView)findViewById(R.id.residence_show);
        tvnicheng_show=(TextView)findViewById(R.id.nicheng_show);
        tvyouxiang_show=(TextView)findViewById(R.id.youxiang_show);
        tvsex_show=(TextView)findViewById(R.id.sex_show);
        tvnumber=(TextView)findViewById(R.id.phonenumber);

        preferences=getSharedPreferences("user", Context.MODE_PRIVATE);
        name=preferences.getString("name","");
        tvnumber.setText(name);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.back:
                finish();
                break;
            case R.id.tonicheng:
                Intent intent_nicheng=new Intent(this,Information_NichengActivity.class);
                String nicheng=tvnicheng_show.getText().toString();
                intent_nicheng.putExtra("nicheng",nicheng);
                startActivityForResult(intent_nicheng,1001);
                break;
            case R.id.toyouxiang:
                Intent intent_youxiang=new Intent(this,Information_YouxiangActivity.class);
                String youxiang=tvyouxiang_show.getText().toString();
                intent_youxiang.putExtra("youxiang",youxiang);
                startActivityForResult(intent_youxiang,1002);
                break;
            case R.id.tochangemima:
                Intent intent_changemima=new Intent(this,ChongzhimimaActivity.class);
                startActivityForResult(intent_changemima,1003);
                break;
            case R.id.residence:
                Intent intent_city=new Intent(this, CityPickerActivity.class);
                startActivityForResult(intent_city,1004);
                break;
            case R.id.sexchoose:
                AlertDialog.Builder sexchosoe=new AlertDialog.Builder(this);
                final String [] sex=new String[]{"男", "女", "其他"};
                sexchosoe.setItems(sex, new DialogInterface.OnClickListener() {
                             @Override
                             public void onClick(DialogInterface dialogInterface, int i) {
                                 tvsex_show.setText(sex[i]);
                             }
                         })
                         .show();
                break;
            case R.id.sure:
                Intent intent=new Intent();
                setResult(2001,intent);
                finish();
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==1004 && resultCode==RESULT_OK){
            String city = data.getStringExtra(CityPickerActivity.KEY_PICKED_CITY);
            tvresidence_show.setText(city);
        }
        if(requestCode==1001 && resultCode==2001){
            String nicheng=data.getStringExtra("nicheng");
            tvnicheng_show.setText(nicheng);
        }
        if (requestCode==1002 && resultCode==2001){
            String youxiang=data.getStringExtra("youxiang");
            tvyouxiang_show.setText(youxiang);
        }
    }
}
