package com.example.jtd.lvapp.youji.net;

/**
 * Created by Marco on 2017/7/14.
 */

public class ConString {
	public final static String showapi_appid = "42140";
	public final static String showapi_sign = "fd500d69caa24a81b8ba76e8d56e18ff";
	public final static String URL_SERARCH_PROVINCE = "268-2?showapi_appid=" + showapi_appid + "&showapi_sign=" + showapi_sign;
	public final static String URL_SERARCH_CITY = "268-3?showapi_appid=" + showapi_appid + "&showapi_sign=" + showapi_sign;
	public final static String URL_SERARCH_VIEW = "268-1?showapi_appid=" + showapi_appid + "&showapi_sign=" + showapi_sign;
	public final static String BASE_URL = "http://route.showapi.com/";
	public static String getBaseUrl(){
		return BASE_URL;
	}
}
