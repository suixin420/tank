package com.mashibing.tank;

import java.awt.*;

public class Wall extends GameObject {
    public int w,h;
    public Rectangle rectangle = new Rectangle();

    public Wall(Integer x, Integer y,Integer w, Integer h){
        this.x=x;
        this.y=y;
        this.w=w;
        this.h=h;
        this.rectangle.x = this.x;
        this.rectangle.y = this.y;
        this.rectangle.width = this.w+20;
        this.rectangle.height = this.h+20;
    }

    @Override
    public void paint(Graphics g) {

        Color color = g.getColor();
        g.setColor(Color.GRAY);
        g.fillRect(x,y,w,h);
        g.setColor(color);
    }
}
