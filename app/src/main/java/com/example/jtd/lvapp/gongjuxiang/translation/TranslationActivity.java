package com.example.jtd.lvapp.gongjuxiang.translation;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import com.example.jtd.lvapp.R;
import com.example.jtd.lvapp.FirstActivity;

/**
 * Created by JTD on 2017/7/6.
 */

public class TranslationActivity extends AppCompatActivity implements View.OnClickListener {
    private RadioButton rbback;
    private Button btnchoosefirst, btnchoosesecond,btnexchange;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translation);
        rbback = (RadioButton) findViewById(R.id.back);
        rbback.setOnClickListener(this);
        btnchoosefirst = (Button) findViewById(R.id.choosefirst);
        btnchoosefirst.setOnClickListener(this);
        btnchoosesecond = (Button) findViewById(R.id.choosesecond);
        btnchoosesecond.setOnClickListener(this);
        btnexchange=(Button)findViewById(R.id.exchange);
        btnexchange.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent_language = new Intent(this, LanguageActivity.class);
        switch (view.getId()) {
            case R.id.back:
                Intent intent = new Intent(this, FirstActivity.class);
                startActivity(intent);
                break;
            case R.id.choosefirst:
                intent_language.putExtra("language_name",btnchoosefirst.getText().toString());
                startActivityForResult(intent_language, 1001);
                break;
            case R.id.choosesecond:
                startActivityForResult(intent_language, 1002);
                break;
            case R.id.exchange:
                String first=btnchoosefirst.getText().toString();
                String second=btnchoosesecond.getText().toString();
                btnchoosefirst.setText(second);
                btnchoosesecond.setText(first);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == 2001) {
            String language = data.getStringExtra("language");
            switch (requestCode) {
                case 1001:
                    btnchoosefirst.setText(language);
                    break;
                case 1002:
                    btnchoosesecond.setText(language);
                    break;
            }
        }
    }
}
