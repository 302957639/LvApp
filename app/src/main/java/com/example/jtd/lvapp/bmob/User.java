package com.example.jtd.lvapp.bmob;

import com.example.jtd.lvapp.mine.ChongzhimimaActivity;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.listener.UpdateListener;

/**
 * Created by JTD on 2017/7/16.
 */

public class User extends BmobObject{
    private String username;
    private String password;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
