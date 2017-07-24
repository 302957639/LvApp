package com.example.jtd.lvapp.mine.information;

import android.app.Dialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.health.TimerStat;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jtd.lvapp.CircleImageView.CircleImageView;
import com.example.jtd.lvapp.R;
import com.example.jtd.lvapp.bmob.User;
import com.example.jtd.lvapp.bmob.UserInformation;
import com.example.jtd.lvapp.mine.ChongzhimimaActivity;
import com.example.jtd.lvapp.mine.ZhuceActivity;
import com.zaaach.citypicker.CityPickerActivity;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.zip.Inflater;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SaveListener;
import cn.bmob.v3.listener.UpdateListener;

/**
 * Created by JTD on 2017/7/20.
 */

public class UserInformationActivity extends AppCompatActivity implements View.OnClickListener{
    private RadioButton rbback;
    private LinearLayout layoutnicheng, layoutyouxiang, layoutchangemima, layoutresidence, layoutsexchoose, layouttouxiangchoose;
    private TextView tvresidence_show,tvnicheng_show,tvyouxiang_show,tvsex_show,tvnumber;
    private SharedPreferences preferences;
    private String name;
    private Button  btnsure;
    private CircleImageView circletouxiang;
    private UserInformation information;
    private Dialog dialog;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mine_user_information);
        Bmob.initialize(this, "b6bd29e7a74a0fddeb82660590ad0678");
        findidandlisten();


        preferences = getSharedPreferences("user", Context.MODE_PRIVATE);
        name = preferences.getString("name", "");
        tvnumber.setText(name);

        BmobQuery<UserInformation> query = new BmobQuery<UserInformation>();
        query.addWhereEqualTo("name", name);
        query.findObjects(new FindListener<UserInformation>() {
            @Override
            public void done(List<UserInformation> list, BmobException e) {
                if (e == null) {
                    if (list.size() == 1) {
                        information = list.get(0);
                        circletouxiang.setImageResource(information.getImgid());
                        tvnicheng_show.setText(information.getNicheng());
                        tvsex_show.setText(information.getSex());
                        tvresidence_show.setText(information.getResidence());
                        tvyouxiang_show.setText(information.getYouxiang());
                    }
                }
            }
        });
    }

    private void findidandlisten() {
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
        layouttouxiangchoose = (LinearLayout) findViewById(R.id.touxiang_choose);
        layouttouxiangchoose.setOnClickListener(this);
        btnsure=(Button)findViewById(R.id.sure);
        btnsure.setOnClickListener(this);

        tvresidence_show=(TextView)findViewById(R.id.residence_show);
        tvnicheng_show=(TextView)findViewById(R.id.nicheng_show);
        tvyouxiang_show=(TextView)findViewById(R.id.youxiang_show);
        tvsex_show=(TextView)findViewById(R.id.sex_show);
        tvnumber=(TextView)findViewById(R.id.phonenumber);
        circletouxiang = (CircleImageView) findViewById(R.id.touxiang);
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
                final Intent intent = new Intent();
                intent.putExtra("touxiang", R.mipmap.login_page_qq);
                intent.putExtra("nicheng", tvnicheng_show.getText().toString());
                intent.putExtra("sex", tvsex_show.getText().toString());
                setResult(2001,intent);

                BmobQuery<UserInformation> query = new BmobQuery<UserInformation>();
                query.addWhereEqualTo("name", name);
                query.findObjects(new FindListener<UserInformation>() {
                    @Override
                    public void done(List<UserInformation> list, BmobException e) {
                        if (e == null) {
                            if (list.size() == 1) {
                                information = list.get(0);
                                information.setImgid(R.mipmap.login_page_qq);
                                information.setNicheng(tvnicheng_show.getText().toString());
                                information.setSex(tvsex_show.getText().toString());
                                information.setResidence(tvresidence_show.getText().toString());
                                information.setName(name);
                                information.setYouxiang(tvyouxiang_show.getText().toString());
                                information.update(new UpdateListener() {
                                    @Override
                                    public void done(BmobException e) {
                                        Toast.makeText(UserInformationActivity.this, "修改成功", Toast.LENGTH_SHORT).show();
                                        finish();
                                    }
                                });
                            } else {
                                information = new UserInformation();
                                information.setImgid(R.mipmap.login_page_qq);
                                information.setNicheng(tvnicheng_show.getText().toString());
                                information.setSex(tvsex_show.getText().toString());
                                information.setResidence(tvresidence_show.getText().toString());
                                information.setName(name);
                                information.setYouxiang(tvyouxiang_show.getText().toString());
                                information.save(new SaveListener<String>() {
                                    @Override
                                    public void done(String s, BmobException e) {
                                        Toast.makeText(UserInformationActivity.this, "修改成功", Toast.LENGTH_SHORT).show();
                                        finish();
                                    }
                                });
                            }
                        }
                    }
                });
                break;
            case R.id.touxiang_choose:
                touxiang();
                break;
            case R.id.formalbum:
                Intent intent_xiangce = new Intent();
                intent_xiangce.setType("image/*");
                intent_xiangce.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent_xiangce, 1005);
                break;
            case R.id.photograph:


                break;
            case R.id.cancel:
                dialog.dismiss();
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==1001 && resultCode==2001){
            String nicheng=data.getStringExtra("nicheng");
            tvnicheng_show.setText(nicheng);
        }
        if (requestCode==1002 && resultCode==2001){
            String youxiang=data.getStringExtra("youxiang");
            tvyouxiang_show.setText(youxiang);
        }
        if (requestCode == 1004 && resultCode == RESULT_OK) {
            String city = data.getStringExtra(CityPickerActivity.KEY_PICKED_CITY);
            tvresidence_show.setText(city);
        }
        if (requestCode == 1005 && resultCode == RESULT_OK) {
            Uri uri = data.getData();
            String img_url = uri.getPath();//这是本机的图片路径
            ContentResolver cr = this.getContentResolver();
            try {
                Bitmap bitmap = BitmapFactory.decodeStream(cr.openInputStream(uri));
                /* 将Bitmap设定到ImageView */
                circletouxiang.setImageBitmap(bitmap);
            } catch (FileNotFoundException e) {
                Log.e("Exception", e.getMessage(), e);
            }
        }
    }

    private void touxiang() {
        dialog = new BottomSheetDialog(this);
        View inflater = LayoutInflater.from(this).inflate(R.layout.mine_information_touxiangchoose_view, null);
        Button btnformalbum = inflater.findViewById(R.id.formalbum);
        Button btnphotograph = inflater.findViewById(R.id.photograph);
        Button btncancel = inflater.findViewById(R.id.cancel);
        btnformalbum.setOnClickListener(this);
        btnphotograph.setOnClickListener(this);
        btncancel.setOnClickListener(this);
        dialog.setContentView(inflater);
        dialog.show();
    }
}
