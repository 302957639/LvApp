package com.example.jtd.lvapp.mine;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jtd.lvapp.R;
import com.example.jtd.lvapp.bmob.User;
import com.example.jtd.lvapp.zhushou.Zhushou_Fragment;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.datatype.BmobQueryResult;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SQLQueryListener;
import cn.bmob.v3.listener.SaveListener;

/**
 * Created by JTD on 2017/7/8.
 */

public class DengluActivity extends AppCompatActivity implements View.OnClickListener{
    private RadioButton rbback;
    private TextView tvwangjimima,tvzhuce;
    private Button btndenglu;
    private EditText etusername,etuserpassword;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mine_denglu);
        rbback=(RadioButton)findViewById(R.id.back);
        rbback.setOnClickListener(this);
        tvwangjimima=(TextView)findViewById(R.id.wangjimima);
        tvzhuce=(TextView)findViewById(R.id.zhuce);
        tvwangjimima.setOnClickListener(this);
        tvzhuce.setOnClickListener(this);
        btndenglu=(Button)findViewById(R.id.denglu) ;
        btndenglu.setOnClickListener(this);

        etusername=(EditText)findViewById(R.id.username);
        etuserpassword=(EditText)findViewById(R.id.userpassword);

        Bmob.initialize(this, "b6bd29e7a74a0fddeb82660590ad0678");
//        User user=new User();
//        user.setUsername("admin");
//        user.setPassward("admin");
//        user.save(new SaveListener<String>() {
//            @Override
//            public void done(String s, BmobException e) {
//                if(e==null){
//                    Toast.makeText(DengluActivity.this,"添加数据成功，返回objectId为："+s,Toast.LENGTH_LONG).show();
//                }else{
//                    Toast.makeText(DengluActivity.this,"创建数据失败：" + e.getMessage(),Toast.LENGTH_LONG).show();
//
//                }
//            }
//        });
    }

    @Override
    public void onClick(View view) {
        Intent intent_zhuce=new Intent(DengluActivity.this,ZhuceActivity.class);
        switch (view.getId()){
            case R.id.back:
                finish();
                break;
            case R.id.wangjimima:
                startActivity(intent_zhuce);
                break;
            case R.id.zhuce:
                startActivity(intent_zhuce);
                break;
            case R.id.denglu:
                String username=etusername.getText().toString();
                String password=etuserpassword.getText().toString();
                String sql="select * from User where username=? and password=?";

                break;
        }
    }
}
