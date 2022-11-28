package com.vuhtang.main;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.text.SimpleDateFormat;

@Named("sessionBean")
@SessionScoped
public class SessionBean implements Serializable {
    private Double x = 0d;
    private Double y = 0d;
    private Double r = 1d;
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public String doubleFormat(Double d) {
        return String.format("%.4f", d);
    }

    public SimpleDateFormat getDateFormat() {
        return dateFormat;
    }


    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }

    public Double getR() {
        return r;
    }

    public void setR(Double r) {
        this.r = r;
    }
}
