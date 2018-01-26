package com.os.activitylifecycle;

import java.io.Serializable;

/**
 * Created by MacOS on 18/01/2018.
 */

public class HocSinh implements Serializable{
    private String hoten;
    private int namsinh;

    public HocSinh() {
    }

    public HocSinh(String hoten, int namsinh) {
        this.hoten = hoten;
        this.namsinh = namsinh;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public int getNamsinh() {
        return namsinh;
    }

    public void setNamsinh(int namsinh) {
        this.namsinh = namsinh;
    }
}
