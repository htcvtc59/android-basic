package com.os.recyclerviewtest;

/**
 * Created by MacOS on 25/01/2018.
 */

public class DataShop {
    private int HinhAnh;
    private String Ten;

    public DataShop(int hinhAnh, String ten) {
        HinhAnh = hinhAnh;
        Ten = ten;
    }

    public int getHinhAnh() {
        return HinhAnh;
    }

    public void setHinhAnh(int hinhAnh) {
        HinhAnh = hinhAnh;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        Ten = ten;
    }
}
