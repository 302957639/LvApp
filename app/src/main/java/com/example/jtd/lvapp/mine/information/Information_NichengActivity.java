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

public class Information_NichengActivity extends AppCompatActivity implements View.OnClickListener{
    private RadioButton rbback;
    private EditText etnicheng;
    private Button btnsure;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mine_information_nicheng);
        rbback=(RadioButton)findViewById(R.id.back);
        rbback.setOnClickListener(this);
        etnicheng=(EditText)findViewById(R.id.nicheng);
        btnsure=(Button)findViewById(R.id.sure);
        btnsure.setOnClickListener(this);
        Intent intent=getIntent();
        String nicheng=intent.getStringExtra("nicheng");
        etnicheng.setText(nicheng);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.back:
                finish();
                break;
            case R.id.sure:
                String nicheng=etnicheng.getText().toString();
                if (nicheng.equals("")){
                    Toast.makeText(this,"请输入昵称",Toast.LENGTH_SHORT).show();
                }
                Intent intent=new Intent();
                intent.putExtra("nicheng",nicheng);
                setResult(2001,intent);
                finish();
                break;
        }
    }
}
