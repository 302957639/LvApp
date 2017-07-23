package com.example.jtd.lvapp.mine;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.jtd.lvapp.R;
import com.example.jtd.lvapp.bmob.User;

import java.util.List;

import cn.bmob.sms.BmobSMS;
import cn.bmob.sms.listener.RequestSMSCodeListener;
import cn.bmob.sms.listener.VerifySMSCodeListener;
import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SaveListener;
import cn.bmob.v3.listener.UpdateListener;

/**
 * Created by JTD on 2017/7/22.
 */

public class ChongzhimimaActivity extends AppCompatActivity implements View.OnClickListener {
    private RadioButton rbback;
    private Button btnsure, btnyanzhengma;
    private EditText etname, etpassword, etcode;
    private String name, password;
    private  User user;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mine_wangjimima);
        rbback = (RadioButton) findViewById(R.id.back);
        rbback.setOnClickListener(this);
        btnsure = (Button) findViewById(R.id.sure);
        etname = (EditText) findViewById(R.id.name);
        etpassword = (EditText) findViewById(R.id.password);
        btnsure.setOnClickListener(this);
        btnyanzhengma = (Button) findViewById(R.id.yanzhengma);
        etcode = (EditText) findViewById(R.id.Code);
        btnyanzhengma.setOnClickListener(this);
        initBomb();
        String[] PERMISSIONS_STORAGE = {Manifest.permission.READ_PHONE_STATE};
        int prermission = ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE);
        if (prermission != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, PERMISSIONS_STORAGE, 1);
        }
    }

    private void initBomb() {
        BmobSMS.initialize(ChongzhimimaActivity.this, "b6bd29e7a74a0fddeb82660590ad0678");
        Bmob.initialize(ChongzhimimaActivity.this, "b6bd29e7a74a0fddeb82660590ad0678");

    }

    @Override
    public void onClick(View view) {
        name = etname.getText().toString();
        password = etpassword.getText().toString();
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.yanzhengma:
                if (name.length() != 11) {
                    Toast.makeText(this, "请输入11位有效手机号码", Toast.LENGTH_SHORT).show();
                }
                //判断该手机号是否已经被注册过
                BmobQuery<User> query = new BmobQuery<User>();
                query.addWhereEqualTo("username", name);
                query.findObjects(new FindListener<User>() {
                    @Override
                    public void done(List<User> list, BmobException e) {
                        if (e == null) {
                            if (list.size() == 1) {

                                user=list.get(0);

                                BmobSMS.requestSMSCode(ChongzhimimaActivity.this, name, "短信模板", new RequestSMSCodeListener() {
                                    @Override
                                    public void done(Integer integer, cn.bmob.sms.exception.BmobException e) {
                                        if (e == null) {
                                            btnyanzhengma.setClickable(false);
                                            Toast.makeText(ChongzhimimaActivity.this, "验证码发送成功，请尽快使用", Toast.LENGTH_SHORT).show();
                                            new CountDownTimer(60000, 1000) {
                                                @Override
                                                public void onTick(long l) {
                                                    btnyanzhengma.setText("重新获取" + "(" + l / 1000 + "秒)");
                                                }

                                                @Override
                                                public void onFinish() {
                                                    btnyanzhengma.setClickable(true);
                                                    btnyanzhengma.setText("重新发送");
                                                }
                                            }.start();
                                        } else {
                                            Toast.makeText(ChongzhimimaActivity.this, "验证码发送失败，请检查网络连接", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });
                            } else {
                                Toast.makeText(ChongzhimimaActivity.this, "该手机号未注册", Toast.LENGTH_SHORT).show();

                            }
                        }
                    }
                });

                break;
            case R.id.sure:
                if (name.length() != 11) {
                    Toast.makeText(ChongzhimimaActivity.this, "手机格式不正确", Toast.LENGTH_SHORT).show();
                } else if (name.length() == 0) {
                    Toast.makeText(ChongzhimimaActivity.this, "请先输入手机号", Toast.LENGTH_SHORT).show();
                } else {
                    BmobSMS.verifySmsCode(this, name, etcode.getText().toString(), new VerifySMSCodeListener() {
                        @Override
                        public void done(cn.bmob.sms.exception.BmobException e) {
                            if (e == null) {
                                user.setValue("password",password);
                                user.update(user.getObjectId(), new UpdateListener() {
                                    @Override
                                    public void done(BmobException e) {
                                        Toast.makeText(ChongzhimimaActivity.this, "重置密码成功", Toast.LENGTH_SHORT).show();
                                        finish();
                                    }
                                });
                            } else {
                                Toast.makeText(ChongzhimimaActivity.this, "验证码错误", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
                break;
        }
    }
}
