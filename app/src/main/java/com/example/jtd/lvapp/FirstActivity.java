package com.example.jtd.lvapp;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.jtd.lvapp.R;
import com.example.jtd.lvapp.Gongjuxiang_Fragment;
import com.example.jtd.lvapp.mine.Mine_Fragment;
import com.example.jtd.lvapp.youji.Youji_Fragment;
import com.example.jtd.lvapp.zhushou.Zhushou_Fragment;


/**
 * Created by 丁金涛 on 2017/6/9.
 */

public class FirstActivity extends AppCompatActivity {
    private RadioGroup group;
    private RadioButton btnfunction1,btnfunction2,btnfunction3,btnfunction4;
    private FragmentTransaction transaction;
    private FragmentManager manager;
    private Gongjuxiang_Fragment gongjuxiang;
    private Zhushou_Fragment zhushou;
    private Mine_Fragment mine;
    private Youji_Fragment youji;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.firstactivity);
        group= (RadioGroup) findViewById(R.id.radio_function);
        btnfunction1=(RadioButton)findViewById(R.id.function1);
        btnfunction2=(RadioButton)findViewById(R.id.function2);
        btnfunction3=(RadioButton)findViewById(R.id.function3);
        btnfunction4=(RadioButton)findViewById(R.id.function4);
        manager=getFragmentManager();
        transaction=manager.beginTransaction();
        gongjuxiang =new Gongjuxiang_Fragment();
        transaction.add(R.id.list,gongjuxiang);
        transaction.commit();
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                if (i==btnfunction1.getId()){
                    manager=getFragmentManager();
                    transaction=manager.beginTransaction();
                    gongjuxiang =new Gongjuxiang_Fragment();
                    transaction.replace(R.id.list,gongjuxiang);
                    transaction.commit();

                }else  if (i==btnfunction2.getId()){
                    manager=getFragmentManager();
                    transaction=manager.beginTransaction();
                    zhushou =new Zhushou_Fragment();
                    transaction.replace(R.id.list,zhushou);
                    transaction.commit();
                }else if(i==btnfunction3.getId()){
                    manager=getFragmentManager();
                    transaction=manager.beginTransaction();
                    youji =new Youji_Fragment();
                    transaction.replace(R.id.list,youji);
                    transaction.commit();
                }else if(i==btnfunction4.getId()){
                    manager=getFragmentManager();
                    transaction=manager.beginTransaction();
                    mine =new Mine_Fragment();
                    transaction.replace(R.id.list,mine);
                    transaction.commit();
                }
            }
        });
    }
}
