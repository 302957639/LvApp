package com.example.jtd.lvapp.gongjuxiang.translation;

/**
 * Created by JTD on 2017/7/3.
 */

public class Language {
    private int imgid;
    private String language;

    public Language(int imgid, String language) {
        this.imgid = imgid;
        this.language = language;
    }

    public int getImgid() {
        return imgid;
    }

    public void setImgid(int imgid) {
        this.imgid = imgid;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}