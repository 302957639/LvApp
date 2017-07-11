package com.example.jtd.lvapp.youji;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jtd.lvapp.R;

/**
 * Created by JTD on 2017/7/7.
 */

public class Youji_Fragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.youji_fragment, container, false);

        return view;
    }
}
