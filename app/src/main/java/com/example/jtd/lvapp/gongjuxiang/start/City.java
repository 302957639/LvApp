package com.example.jtd.lvapp.gongjuxiang.start;

/**
 * Created by JTD on 2017/7/3.
 */

public class City {

    private String mudidi;
    private String choose;
    private String time1;
    private String time2;

    public City(String mudidi, String choose, String time1, String time2) {

        this.mudidi = mudidi;
        this.choose = choose;

        this.time1 = time1;

        this.time2 = time2;
    }



    public String getMudidi() {
        return mudidi;
    }

    public void setMudidi(String mudidi) {
        this.mudidi = mudidi;
    }

    public String getChoose() {
        return choose;
    }

    public void setChoose(String choose) {
        this.choose = choose;
    }

    public String getTime1() {
        return time1;
    }

    public void setTime1(String time1) {
        this.time1 = time1;
    }


    public String getTime2() {
        return time2;
    }

    public void setTime2(String time2) {
        this.time2 = time2;
    }
}
