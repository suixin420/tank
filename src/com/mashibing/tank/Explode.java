package com.mashibing.tank;


import java.awt.*;

public class Explode extends GameObject {

    public static final Integer width=ResourceMgr.explode[0].getWidth(), hight=ResourceMgr.explode[0].getHeight();
//    private Integer x=10,y=10;
    private Integer step=0;

    public Explode(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }


    @Override
    public void paint(Graphics g) {
        g.drawImage(ResourceMgr.explode[step++],x, y,null);
        if (step >= ResourceMgr.explode.length){
//            step = 0;
            GameModel.getInstance().remove(this);
        }
    }

}
