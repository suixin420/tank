package com.mashibing.abstractFactory;

import com.mashibing.tank.ResourceMgr;
import com.mashibing.tank.TankFrame;

import java.awt.*;

public class RectExplode extends BaseExplode {
    public static final Integer width= ResourceMgr.explode[0].getWidth(), hight=ResourceMgr.explode[0].getHeight();
    private Integer x=10,y=10;
    private Integer step=0;
    private boolean living = false;
    TankFrame tf=null;

    public RectExplode(Integer x, Integer y,TankFrame tf) {
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

    @Override
    public void paint(Graphics g) {
//        g.drawImage(ResourceMgr.explode[step++],x, y,null);
        Color c = g.getColor();
        g.setColor(Color.red);
        g.drawRect(x,y,50,50);
        g.setColor(c);
        step++;

        if (step >= ResourceMgr.explode.length){
//            step = 0;
            tf.explodes.remove(this);
        }
    }

}
