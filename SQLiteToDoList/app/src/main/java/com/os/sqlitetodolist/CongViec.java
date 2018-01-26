package com.os.sqlitetodolist;

/**
 * Created by MacOS on 22/01/2018.
 */

public class CongViec {
    private int id;
    private String Ten;

    public CongViec(int id, String ten) {
        this.id = id;
        Ten = ten;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        Ten = ten;
    }
}
