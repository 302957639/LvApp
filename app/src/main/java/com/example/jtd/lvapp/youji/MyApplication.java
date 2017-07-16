package com.example.jtd.lvapp.youji;

import android.app.Application;

import com.example.jtd.lvapp.youji.net.ConString;
import com.itheima.retrofitutils.ItheimaHttp;

/**
 * Created by Marco on 2017/7/14.
 */

public class MyApplication extends Application{

	@Override
	public void onCreate() {
		super.onCreate();
		ItheimaHttp.init(this, ConString.getBaseUrl());
	}
}
