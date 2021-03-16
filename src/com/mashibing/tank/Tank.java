package com.mashibing.tank;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class Tank {
    private Integer x=20,y=20;
    public static final Integer tankWidth=ResourceMgr.tankD.getWidth(), tankHight=ResourceMgr.tankD.getWidth();
    private Dir dir;
     static final Integer speed=5;
    private boolean moving = false;
    TankFrame tf=null;
    private BufferedImage image = ResourceMgr.tankD;
    private boolean living=true;

    public Tank(Integer x, Integer y,Dir dir,TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
    }

    public Dir getDir() {
        return dir;
    }

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
        if (!living){
            tf.tanks.remove(this);
            return;
        }
        move();
//        Color color = g.getColor();
//        g.setColor(Color.YELLOW);
//        g.fillRect(x, y, width, hight);
//        g.setColor(color);
        g.drawImage(image,x, y,null);
    }

    private void move() {
        if (!moving) return;
        switch (dir){
            case LEFT:
                System.out.println("左键");
                x -=speed;
                image = ResourceMgr.tankL;
                break;
            case RIGHT:
                System.out.println("右键");
                x +=speed;
                image = ResourceMgr.tankR;
                break;
            case UP:
                System.out.println("上键");
                y -=speed;
                image = ResourceMgr.tankU;
                break;
            case DOWN:
                y +=speed;
                image = ResourceMgr.tankD;
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
        int bx = this.x + this.tankWidth/2 - Build.width/2;
        int by = this.y + this.tankHight/2 - Build.hight/2;
        tf.builds.add(new Build(bx,by,this.dir,this.tf));
    }

    public void die() {
        this.living = false;
    }
}
