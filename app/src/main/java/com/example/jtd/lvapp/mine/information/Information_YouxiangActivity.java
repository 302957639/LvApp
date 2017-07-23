package com.example.jtd.lvapp.mine.information;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.jtd.lvapp.R;

/**
 * Created by JTD on 2017/7/20.
 */

public class Information_YouxiangActivity extends AppCompatActivity implements View.OnClickListener{
    private RadioButton rbback;
    private Button btnsure;
    private EditText etyouxiang;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mine_information_youxiang);
        rbback=(RadioButton)findViewById(R.id.back);
        rbback.setOnClickListener(this);
        btnsure=(Button)findViewById(R.id.sure);
        btnsure.setOnClickListener(this);
        etyouxiang=(EditText)findViewById( R.id.youxiang);
        Intent intent=getIntent();
        String youxiang=intent.getStringExtra("youxiang");
        etyouxiang.setText(youxiang);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.back:
                finish();
                break;
            case R.id.sure:
                String youxiang=etyouxiang.getText().toString();
                if (youxiang.equals("")){
                    Toast.makeText(this,"请输入邮箱",Toast.LENGTH_SHORT).show();
                }
                Intent intent=new Intent();
                intent.putExtra("youxiang",youxiang);
                setResult(2001,intent);
                finish();
                break;
        }
    }
}
