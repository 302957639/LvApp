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
import java.util.List;
import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;


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
                if (username.equals("")&&password.equals("")){
                    Toast.makeText(DengluActivity.this,"请输入账号密码",Toast.LENGTH_SHORT).show();
                }
                BmobQuery<User> query=new BmobQuery<User>();
                query.addWhereEqualTo("username",username);
                query.addWhereEqualTo("password",password);
                query.findObjects(new FindListener<User>() {
                    @Override
                    public void done(List<User> list, BmobException e) {
                     if (e==null){
                         if (list.size()==1){
                             Intent intent=new Intent();
                             setResult(2001,intent);
                             finish();
                         }else {
                             Toast.makeText(DengluActivity.this,"账号密码错误",Toast.LENGTH_SHORT).show();
                         }
                     }
                    }
                });
                break;
        }
    }
}
