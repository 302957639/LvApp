package com.example.jtd.lvapp.youji.net;

import com.itheima.retrofitutils.ItheimaHttp;
import com.itheima.retrofitutils.Request;
import com.itheima.retrofitutils.listener.HttpResponseListener;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.ResponseBody;
import retrofit2.Call;

/**
 * Created by JTD on 2017/7/13.
 */

public class HttpUtil {

    public static void asyncGet(String url, final HttpResponseLister callback){


        Request request = ItheimaHttp.newGetRequest(url);//apiUrl格式："xxx/xxxxx"
        Call call = ItheimaHttp.send(request, new HttpResponseListener<String>() {
            @Override
            public void onResponse(String bean) {
                try {
                    callback.onResponse(new JSONObject(bean));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable e) {
                System.out.println(e.toString()+"\n"+call.toString());
            }
        });
        call.request();
    }

    public interface HttpResponseLister{
        void onResponse(JSONObject bean);
    }


}
