package com.mashibing.tank;

import java.awt.*;
import java.util.Random;

public class Build {
    private static final Integer speed=10;
    public static final Integer width=ResourceMgr.build.getWidth(), hight=ResourceMgr.build.getHeight();
    private Integer x=10,y=10;
    private Dir dir;
    private boolean living = true;
    private TankFrame tf = null;
    private Group group = Group.BAD;


    public Build(Integer x, Integer y, Dir dir,TankFrame tf,Group group) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
        this.group = group;
    }

    public Dir getDir() {
        return dir;
    }
    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public void paint(Graphics g) {
        if (!living){
            tf.builds.remove(this);
        }

        move();
        g.drawImage(ResourceMgr.build,x, y,null);
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
        if (x <0 || y <0 || x > TankFrame.GAME_WIDRTH || y > TankFrame.GAME_HEGITH) this.living = false;
    }


    /**
     * 碰撞检测
     * @param tank
     */
    public void collideWith(Tank tank) {
        if (this.group == tank.getGroup())return;

        Rectangle rect1 = new Rectangle(this.x,this.y,width,hight);
        Rectangle rect2 = new Rectangle(tank.getX(),tank.getY(),tank.tankWidth,tank.tankHight);
        if (rect1.intersects(rect2)){
            tank.die();
            this.die();
        }
    }

    private void die() {
        this.living=false;
    }
}
