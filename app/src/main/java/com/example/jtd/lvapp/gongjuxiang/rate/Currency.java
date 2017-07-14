package com.example.jtd.lvapp.gongjuxiang.rate;

/**
 * Created by JTD on 2017/7/3.
 */

public class Currency {
    private int imgid;
    private String name;
    private String jiancheng;

    public Currency(int imgid, String name, String jiancheng) {
        this.imgid = imgid;
        this.name = name;
        this.jiancheng = jiancheng;
    }

    public int getImgid() {
        return imgid;
    }

    public void setImgid(int imgid) {
        this.imgid = imgid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJiancheng() {
        return jiancheng;
    }

    public void setJiancheng(String jiancheng) {
        this.jiancheng = jiancheng;
    }
}