package com.mashibing.tank;

import java.awt.*;

public class Build {
    private Integer x=10,y=10;
    private Dir dir;
    private static final Integer speed=5;
    private static final Integer width=20, hight=20;
    private boolean live;
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
        System.out.println("子弹开始跑");
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
                System.out.println("左键");
                x -=speed;
                break;
            case RIGHT:
                System.out.println("右键");
                x +=speed;
                break;
            case UP:
                System.out.println("上键");
                y -=speed;
                break;
            case DOWN:
                y +=speed;
                break;
            default:
                break;
        }
        if (x <0 || y <0 || x > TankFrame.frameWidth || y > TankFrame.frameHegith) live = false;
    }


}
