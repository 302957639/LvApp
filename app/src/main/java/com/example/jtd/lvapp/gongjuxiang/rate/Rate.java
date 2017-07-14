package com.example.jtd.lvapp.gongjuxiang.rate;

/**
 * Created by JTD on 2017/7/3.
 */

public class Rate {
    private int imgid;
    private String name;
    private String shurujiage;
    private String dechujiage;
    private String moneyname;

    public Rate(int imgid, String name, String shurujiage, String dechujiage, String moneyname) {
        this.imgid = imgid;
        this.name = name;
        this.shurujiage = shurujiage;
        this.dechujiage = dechujiage;
        this.moneyname = moneyname;
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

    public String getShurujiage() {
        return shurujiage;
    }

    public void setShurujiage(String shurujiage) {
        this.shurujiage = shurujiage;
    }

    public String getDechujiage() {
        return dechujiage;
    }

    public void setDechujiage(String dechujiage) {
        this.dechujiage = dechujiage;
    }

    public String getMoneyname() {
        return moneyname;
    }

    public void setMoneyname(String moneyname) {
        this.moneyname = moneyname;
    }
}