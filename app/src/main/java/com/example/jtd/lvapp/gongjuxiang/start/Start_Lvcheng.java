package com.example.jtd.lvapp.gongjuxiang.start;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import com.example.jtd.lvapp.R;
import com.zaaach.citypicker.CityPickerActivity;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by 丁金涛 on 2017/6/11.
 */

public class Start_Lvcheng extends AppCompatActivity implements View.OnClickListener{
    private RadioButton rbback_first, rbmap,rbdelete ;
    private Button btnadd;
    public Button btnstart;
    private LinearLayout layoutchufadi, layoutfirsttime;
    private ListView lvcity;
    private List<City> datas;
    public CheckBox cbbianji;
    private static final int REQUEST_CODE_PICK_CITY = 0;
    private TextView tvchufa, tvchufatime;
    private int flag,mYear,mMonth,mDay;
    private CityCustomAdapter adapter;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_lvcheng);
        datas = new ArrayList<>();

        Calendar c = Calendar.getInstance();//
        mYear = c.get(Calendar.YEAR); // 获取当前年份
        mMonth = c.get(Calendar.MONTH) + 1;// 获取当前月份
        mDay = c.get(Calendar.DAY_OF_MONTH);// 获取当日期

        String time = mYear + "/" + mMonth + "/" + mDay;
        String time2 =mYear + "/" + mMonth + "/" + (mDay+1);
        tvchufatime = (TextView) findViewById(R.id.chufatime);
        tvchufatime.setText(time);

        datas.add(new City("目的地1", "请选择"
                , time2, time2));

        adapter = new CityCustomAdapter(Start_Lvcheng.this, datas);
        lvcity = (ListView) findViewById(R.id.list);
        lvcity.setAdapter(adapter);


        rbback_first = (RadioButton) findViewById(R.id.back_first);
        rbback_first.setOnClickListener(this);

        rbmap = (RadioButton) findViewById(R.id.map);
        rbmap.setOnClickListener(this);
        tvchufa = (TextView) findViewById(R.id.chufadidian);

        btnadd = (Button) findViewById(R.id.addview);
        btnadd.setOnClickListener(this);
        layoutchufadi = (LinearLayout) findViewById(R.id.chufadi);
        layoutchufadi.setOnClickListener(this);
        btnstart = (Button) findViewById(R.id.start);
        btnstart.setOnClickListener(this);
        layoutfirsttime = (LinearLayout) findViewById(R.id.firsttime);
        layoutfirsttime.setOnClickListener(this);
        cbbianji=(CheckBox)findViewById(R.id.bianji);
        cbbianji.setOnClickListener(this);

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            String city = data.getStringExtra(CityPickerActivity.KEY_PICKED_CITY);
            switch (requestCode) {
                case REQUEST_CODE_PICK_CITY:
                    if (flag == 1) {
                        tvchufa.setText(city);

                    } else if (flag == 2) {
                        if (cbbianji.getVisibility()!=View.VISIBLE) {
                            cbbianji.setVisibility(View.VISIBLE);
                        }
                        adapter.setFlag(0);

                        int i=lvcity.getCount()+1;
                        String time =mYear + "/" + mMonth + "/" + (mDay+i);
                        datas.add(new City("目的地"+i, city
                                , time, time));
                        adapter.notifyDataSetChanged();
//                        if (cbbianji.getText()=="完成"){
//                            for (int a=0;a<lvcity.getChildCount();a++) {
//                                rbdelete = (RadioButton) lvcity.getChildAt(a).findViewById(R.id.delete_item);
//                                rbdelete.setVisibility(View.VISIBLE);
//                            }
//                        }
                    }
                    break;
                case 3001:
                    btnadd.setVisibility(View.VISIBLE);
                    btnstart.setBackgroundResource(R.color.colorstart);
                    btnstart.setTextColor(Color.parseColor("#ffffff"));
                    int position = adapter.getPosition();
                    City city1 = datas.get(position);
                    city1.setChoose(city);
                    adapter.notifyDataSetChanged();
                    break;
            }
        }

        if (resultCode == 2001) {
            String time = data.getStringExtra("date");
            switch (requestCode) {
                case 1001:
                    tvchufatime.setText(time);
                    break;
                case 1002:
                    int timeid = adapter.getTimeid();
                    City city1 = datas.get(timeid);
                    city1.setTime1(time);
                    adapter.notifyDataSetChanged();

                    break;
                case 1003:
                    int time2id = adapter.getTime2id();
                    City city2 = datas.get(time2id);
                    city2.setTime2(time);
                    adapter.notifyDataSetChanged();
                    break;
            }
        }
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_first:
                finish();
                break;
            case R.id.map:
                Intent intent2 = new Intent(Start_Lvcheng.this, MapActivity.class);
                startActivity(intent2);
                break;
            case R.id.chufadi:
                flag = 1;
                startActivityForResult(new Intent(Start_Lvcheng.this, CityPickerActivity.class),
                        REQUEST_CODE_PICK_CITY);
                break;
            case R.id.addview:

                flag = 2;
                startActivityForResult(new Intent(Start_Lvcheng.this, CityPickerActivity.class),
                        REQUEST_CODE_PICK_CITY);

                break;

            case R.id.firsttime:
                Intent intent = new Intent(Start_Lvcheng.this, DateActivity.class);
                startActivityForResult(intent, 1001);
                break;
            case R.id.start:
              Toast.makeText(Start_Lvcheng.this,"11",Toast.LENGTH_LONG).show();
                break;
            case R.id.bianji:
               if (cbbianji.isChecked()){
                   cbbianji.setText("完成");
                   btnstart.setBackgroundResource(R.color.colorstart_choose);
                   btnstart.setTextColor(Color.parseColor("#575757"));
                   for (int i=0;i<lvcity.getChildCount();i++) {
                       rbdelete = (RadioButton) lvcity.getChildAt(i).findViewById(R.id.delete_item);
                       LinearLayout linearLayout=(LinearLayout)lvcity.getChildAt(i).findViewById(R.id.addmudidi) ;
                       TextView time1=(TextView)lvcity.getChildAt(i).findViewById(R.id.time1);
                       TextView time2=(TextView)lvcity.getChildAt(i).findViewById(R.id.time2);
                       time1.setClickable(false);
                       time2.setClickable(false);
                       linearLayout.setClickable(false);
                       rbdelete.setVisibility(View.VISIBLE);
                   }
               }
               else {
                   btnstart.setBackgroundResource(R.color.colorstart);
                   btnstart.setTextColor(Color.parseColor("#ffffff"));
                   cbbianji.setText("编辑");

                   for (int i=0;i<lvcity.getChildCount();i++) {
                       RadioButton radioButton = (RadioButton) lvcity.getChildAt(i).findViewById(R.id.delete_item);
                       LinearLayout linearLayout=(LinearLayout)lvcity.getChildAt(i).findViewById(R.id.addmudidi) ;
                       TextView time1=(TextView)lvcity.getChildAt(i).findViewById(R.id.time1);
                       TextView time2=(TextView)lvcity.getChildAt(i).findViewById(R.id.time2);
                       time1.setClickable(true);
                       time2.setClickable(true);
                       linearLayout.setClickable(true);
                       radioButton.setVisibility(View.GONE);
                   }
               }
                break;
        }
    }

}
