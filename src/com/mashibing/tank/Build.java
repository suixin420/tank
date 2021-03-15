package com.mashibing.tank;

import java.awt.*;

public class Build {
    private static final Integer speed=5;
    private static final Integer width=20, hight=20;
    private Integer x=10,y=10;
    private Dir dir;
    private boolean live = true;
    private TankFrame tf = null;

    public Build(Integer x, Integer y, Dir dir,TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
    }

    public boolean getLive() {
        return live;
    }

    public void setLive(boolean live) {
        this.live = live;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }


    public void paint(Graphics g) {
        if (!live){
            tf.buildList.remove(this);
        }

        Color color = g.getColor();
        g.setColor(Color.black);
        g.fillOval(x, y, width, hight);
        g.setColor(color);
        move();
    }

    private void move() {
        switch (dir){
            case LEFT:
                x -= speed;
                break;
            case RIGHT:
                x += speed;
                break;
            case UP:
                y -= speed;
                break;
            case DOWN:
                y += speed;
                break;
            default:
                break;
        }
        if (x <0 || y <0 || x > TankFrame.frameWidth || y > TankFrame.frameHegith) live = false;
    }


}
