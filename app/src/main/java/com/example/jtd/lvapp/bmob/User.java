package com.example.jtd.lvapp.bmob;

import cn.bmob.v3.BmobObject;

/**
 * Created by JTD on 2017/7/16.
 */

public class User extends BmobObject{
    private String username;
    private String passward;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassward() {
        return passward;
    }

    public void setPassward(String passward) {
        this.passward = passward;
    }
}
