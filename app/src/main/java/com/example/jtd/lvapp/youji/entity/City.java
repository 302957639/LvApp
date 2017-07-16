package com.example.jtd.lvapp.youji.entity;

/**
 * Created by JTD on 2017/7/13.
 */

public class City extends Province{
    private String proId;
    private String proName;


    public void setProId(String proId){
        this.proId = proId;
    }
    public String getProId(){
        return this.proId;
    }

    public void setProName(String proName){
        this.proName = proName;
    }
    public String getProName(){
        return this.proName;
    }

}
