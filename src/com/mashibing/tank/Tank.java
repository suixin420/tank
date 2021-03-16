package com.mashibing.tank;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Tank {
    private Integer x=20,y=20;
    private static final Integer width=50, hight=50;
    private Dir dir;
     static final Integer speed=5;
    private boolean moving = false;
    TankFrame tf=null;

    public Tank(Integer x, Integer y,Dir dir,TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public boolean getMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public void paint(Graphics g) {
        System.out.println("坦克开始跑");
        Color color = g.getColor();
        move();
        g.setColor(Color.YELLOW);
        g.fillRect(x, y, width, hight);
        g.setColor(color);
    }

    private void move() {
        if (!moving) return;
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
        if (x <0  )x = 0;
        if (y <0  )y = 0;
        if (x > TankFrame.GAME_WIDRTH)x = TankFrame.GAME_WIDRTH;
        if (y > TankFrame.GAME_HEGITH)y = TankFrame.GAME_HEGITH;
    }


    public void fire() {
        tf.buildList.add(new Build(this.x,this.y,this.dir,this.tf));
    }
}
