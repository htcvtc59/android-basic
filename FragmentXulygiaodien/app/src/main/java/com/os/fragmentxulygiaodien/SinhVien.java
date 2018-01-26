package com.os.fragmentxulygiaodien;

import java.io.Serializable;

/**
 * Created by MacOS on 24/01/2018.
 */

public class SinhVien implements Serializable{
    private String hoten;
    private int namsinh;
    private String diachi;
    private String email;

    public SinhVien(String hoten, int namsinh, String diachi, String email) {
        this.hoten = hoten;
        this.namsinh = namsinh;
        this.diachi = diachi;
        this.email = email;
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

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
