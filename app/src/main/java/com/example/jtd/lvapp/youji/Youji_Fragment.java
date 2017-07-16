package com.example.jtd.lvapp.youji;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Spinner;

import com.alibaba.fastjson.JSON;
import com.example.jtd.lvapp.R;
import com.example.jtd.lvapp.youji.entity.City;
import com.example.jtd.lvapp.youji.entity.Province;
import com.example.jtd.lvapp.youji.entity.Views;
import com.example.jtd.lvapp.youji.net.ConString;
import com.example.jtd.lvapp.youji.net.HttpUtil;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JTD on 2017/7/7.
 */

public class Youji_Fragment extends Fragment {
    private Spinner mProvinceSpinner, mCitySpinner;
    private ListView lvshowview;

    private List<Province> proList = new ArrayList<Province>();
    private List<City> cityList = new ArrayList<>();
    private List<Views> viewsList = new ArrayList<>();

    private City city;
    private ViewAdapter viewAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.youji_fragment, container, false);
        mProvinceSpinner = view.findViewById(R.id.province);
        mCitySpinner = view.findViewById(R.id.city);
        lvshowview = view.findViewById(R.id.viewshow);

        getProvinceInfo();

        mProvinceSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String id = proList.get(i).getId();
                getCityinfo(id);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        mCitySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                city = cityList.get(i);
                getViewinfo(city.getId());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        return view;
    }

    private void handleProData(JSONObject getprovince) throws JSONException {
        JSONObject jsonObject1 = getprovince.getJSONObject("showapi_res_body");
        JSONObject dataObject = jsonObject1.getJSONObject("list");
        JSONArray data = dataObject.getJSONArray("list");
        proList = JSON.parseArray(data.toString(), Province.class);
        Adapter proadapter = new Adapter(proList, getActivity());
        mProvinceSpinner.setAdapter(proadapter);

    }

    private void handleCityData(JSONObject getcity) throws JSONException {
        JSONObject jsonObject1 = getcity.getJSONObject("showapi_res_body");
        JSONArray data = jsonObject1.getJSONArray("list");
        cityList = JSON.parseArray(data.toString(), City.class);
        Adapter cityadapter = new Adapter(cityList, getActivity());
        mCitySpinner.setAdapter(cityadapter);

    }


    public void getProvinceInfo() {
        HttpUtil.asyncGet(ConString.URL_SERARCH_PROVINCE, new HttpUtil.HttpResponseLister() {

            @Override
            public void onResponse(JSONObject bean) {
                try {
                    handleProData(bean);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }


    public void getCityinfo(String id) {
        HttpUtil.asyncGet(ConString.URL_SERARCH_CITY + "&proId=" + id, new HttpUtil.HttpResponseLister() {
            @Override
            public void onResponse(JSONObject bean) {
                try {
                    handleCityData(bean);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void getViewinfo(String id) {
        HttpUtil.asyncGet(ConString.URL_SERARCH_VIEW + "&cityId=" + id, new HttpUtil.HttpResponseLister() {
            @Override
            public void onResponse(JSONObject bean) {
                try {
                    handleViewData(bean);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void handleViewData(JSONObject bean) throws JSONException {
        JSONArray array = bean.getJSONObject("showapi_res_body").getJSONObject("pagebean").getJSONArray("contentlist");
        viewsList = JSON.parseArray(array.toString(), Views.class);
        viewAdapter = new ViewAdapter(getActivity(), viewsList);
        lvshowview.setAdapter(viewAdapter);
    }


}
