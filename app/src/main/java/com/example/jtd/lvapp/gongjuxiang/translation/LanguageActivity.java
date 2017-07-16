package com.example.jtd.lvapp.gongjuxiang.translation;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;

import com.example.jtd.lvapp.FirstActivity;
import com.example.jtd.lvapp.R;
import com.example.jtd.lvapp.gongjuxiang.rate.Rate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JTD on 2017/7/13.
 */

public class LanguageActivity extends AppCompatActivity implements View.OnClickListener{
    private List<Language> datas;
    private LanguageAdapter adapter;
    private ListView listView;
    private RadioButton rbback,rbbackhome;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translation_language);
        rbback=(RadioButton)findViewById(R.id.back);
        rbbackhome=(RadioButton)findViewById(R.id.backhome);
        rbback.setOnClickListener(this);
        rbbackhome.setOnClickListener(this);
        listView= (ListView) findViewById(R.id.list_language);
        datas=new ArrayList<>();
        datas.add(new Language(R.mipmap.languagechoice_page_flag_china,"简体中文"));
        datas.add(new Language(R.mipmap.languagechoice_page_flag_china,"粤语"));
        datas.add(new Language(R.mipmap.languagechoice_page_flag_uk,"英语"));
        datas.add(new Language(R.mipmap.languagechoice_page_flag_fr,"法语"));
        datas.add(new Language(R.mipmap.languagechoice_page_flag_de,"德语"));
        datas.add(new Language(R.mipmap.languagechoice_page_flag_ja,"日语"));
        datas.add(new Language(R.mipmap.languagechoice_page_flag_ko,"汉语"));
        datas.add(new Language(R.mipmap.languagechoice_page_flag_th,"泰语"));
        datas.add(new Language(R.mipmap.languagechoice_page_flag_vi,"越南语"));
        datas.add(new Language(R.mipmap.languagechoice_page_flag_cs,"捷克语"));
        datas.add(new Language(R.mipmap.languagechoice_page_flag_nl,"荷兰语"));
        datas.add(new Language(R.mipmap.languagechoice_page_flag_ar,"阿拉伯语"));
        datas.add(new Language(R.mipmap.languagechoice_page_flag_fi,"芬兰语"));
        datas.add(new Language(R.mipmap.languagechoice_page_flag_hu,"匈牙利语"));
        datas.add(new Language(R.mipmap.languagechoice_page_flag_id,"印度尼西亚语"));
        datas.add(new Language(R.mipmap.languagechoice_page_flag_it,"意大利语"));
        datas.add(new Language(R.mipmap.languagechoice_page_flag_no,"挪威语"));
        datas.add(new Language(R.mipmap.languagechoice_page_flag_pl,"波兰语"));
        datas.add(new Language(R.mipmap.languagechoice_page_flag_pt,"葡萄牙语"));
        datas.add(new Language(R.mipmap.languagechoice_page_flag_ru,"俄语"));
        datas.add(new Language(R.mipmap.languagechoice_page_flag_es,"西班牙语"));
        datas.add(new Language(R.mipmap.languagechoice_page_flag_sv,"瑞典语"));
        datas.add(new Language(R.mipmap.languagechoice_page_flag_tr,"土耳其语"));
        adapter=new LanguageAdapter(datas,this);
        listView.setAdapter(adapter);
        Intent intent=getIntent();
        String language=intent.getStringExtra("language_name");
        for (int i=0;i<datas.size();i++){
            Language language_name=datas.get(i);
            String lang=language_name.getLanguage();
            if (lang.equals(language)){

            }
        }
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Language language=datas.get(i);
                Intent intent=new Intent();
                intent.putExtra("language",language.getLanguage());
                setResult(2001,intent);
                finish();
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.back:
                finish();
                break;
            case R.id.backhome:
                Intent intent_home=new Intent(LanguageActivity.this, FirstActivity.class);
                startActivity(intent_home);
                break;
        }
    }
}
