package com.example.jtd.lvapp.zhushou;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import com.example.jtd.lvapp.R;


/**
 * Created by 丁金涛 on 2017/6/9.
 */

public class Zhushou_Fragment extends Fragment implements View.OnClickListener{
    private RadioButton rbadd,rbtianjia;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.zhushou_fragment, container, false);
        rbadd=(RadioButton)view.findViewById(R.id.addxingcheng);
        rbtianjia=(RadioButton)view.findViewById(R.id.tianjiaxingcheng);
        rbadd.setOnClickListener(this);
        rbtianjia.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        Intent intent=new Intent(getActivity(),NoDiaryActivity.class);
        switch (view.getId()){
            case R.id.addxingcheng:
                startActivity(intent);
                break;
            case R.id.tianjiaxingcheng:
                startActivity(intent);
                break;
        }
    }
}
