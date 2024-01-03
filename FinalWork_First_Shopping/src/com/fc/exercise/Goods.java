package com.fc.exercise;

import java.io.Serializable;

public class Goods implements Serializable {
    private static final long serialVersionUID = 3941941157018263802L;
    private int gid;
    private String gname;
    private double gprice;
    private int gcount;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
    public int getGid() {
        return gid;
    }
    public void setGid(int gid) {
        this.gid = gid;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public double getGprice() {
        return gprice;
    }

    public void setGprice(double gprice) {
        this.gprice = gprice;
    }

    public int getGcount() {
        return gcount;
    }

    public void setGcount(int gcount) {
        this.gcount = gcount;
    }

}
