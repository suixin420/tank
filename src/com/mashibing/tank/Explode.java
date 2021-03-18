package com.mashibing.tank;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Explode {

    public static final Integer width=ResourceMgr.explode[0].getWidth(), hight=ResourceMgr.explode[0].getHeight();
    private Integer x=10,y=10;
    private Integer step=0;
    private boolean living = false;

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public boolean getLiving() {
        return living;
    }

    public void setLiving(boolean living) {
        this.living = living;
    }

    public void paint(Graphics g) {
        System.out.println("进入================");
        if (!living)return;
        g.drawImage(ResourceMgr.explode[step++],x, y,null);
        if (step >= ResourceMgr.explode.length){
            step = 0;
            living = false;
        }
    }

}
