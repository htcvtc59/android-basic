package com.os.contactmanagerasm;

import java.io.Serializable;

/**
 * Created by MacOS on 25/01/2018.
 */

public class Contact implements Serializable {
    private int id;
    private String name;
    private String phone;
    private byte[] imgcontact;

    public Contact(int id, String name, String phone, byte[] imgcontact) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.imgcontact = imgcontact;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public byte[] getImgcontact() {
        return imgcontact;
    }

    public void setImgcontact(byte[] imgcontact) {
        this.imgcontact = imgcontact;
    }
}
