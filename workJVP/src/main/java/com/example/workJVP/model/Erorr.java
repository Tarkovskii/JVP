package com.example.workJVP.model;

public class Erorr {
    private boolean ok;

    private String msg;

    public Erorr(boolean ok, String msg) {
        this.ok = ok;
        this.msg = msg;
    }

    public boolean getOk() {
        return ok;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
