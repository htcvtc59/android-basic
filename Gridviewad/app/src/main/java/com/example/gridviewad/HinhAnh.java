package com.example.gridviewad;

/**
 * Created by MacOS on 15/01/2018.
 */

public class HinhAnh {
    private String Ten;
    private int Hinh;

    public HinhAnh() {
    }

    public HinhAnh(String ten, int hinh) {
        Ten = ten;
        Hinh = hinh;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        Ten = ten;
    }

    public int getHinh() {
        return Hinh;
    }

    public void setHinh(int hinh) {
        Hinh = hinh;
    }
}
