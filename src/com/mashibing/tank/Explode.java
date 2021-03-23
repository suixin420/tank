package com.mashibing.tank;


import java.awt.*;
import java.awt.image.BufferedImage;

public class Explode {

    public static final Integer width=ResourceMgr.explode[0].getWidth(), hight=ResourceMgr.explode[0].getHeight();
    private Integer x=10,y=10;
    private Integer step=0;
    private boolean living = false;
    TankFrame tf=null;

    public Explode(Integer x, Integer y,TankFrame tf) {
        this.x = x;
        this.y = y;
        this.tf = tf;
    }

    public boolean getLiving() {
        return living;
    }

    public void setLiving(boolean living) {
        this.living = living;
    }

    public void paint(Graphics g) {
        g.drawImage(ResourceMgr.explode[step++],x, y,null);
        if (step >= ResourceMgr.explode.length){
//            step = 0;
            tf.explodes.remove(this);
        }
    }

}
