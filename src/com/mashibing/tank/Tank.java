package com.mashibing.tank;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Tank {
    private Integer x=20,y=20;
    public static final Integer tankWidth=ResourceMgr.goodTankD.getWidth(), tankHeght=ResourceMgr.goodTankD.getWidth();
    private Dir dir;
     static final Integer speed=3;
    private boolean moving = true;
    TankFrame tf=null;
    private BufferedImage image = ResourceMgr.goodTankD;
    private boolean living=true;
    private Group group = Group.BAD;
    private Random random = new Random();
    Rectangle rectangle = new Rectangle();

    public Tank(Integer x, Integer y,Dir dir,TankFrame tf,Group group) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
        this.group = group;

        this.rectangle.x = this.x;
        this.rectangle.y = this.y;
        this.rectangle.width = this.tankWidth;
        this.rectangle.height = this.tankHeght;
    }

    public Dir getDir() {
        return dir;
    }
    public Integer getX() {
        return x;
    }
    public Group getGroup() {
        return group;
    }
    public void setGroup(Group group) {
        this.group = group;
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
        if (!living){
            tf.tanks.remove(this);
            tf.explodes.add(new Explode(this.x,this.y,tf));
            return;
        }
        move();
        g.drawImage(image,x, y,null);
    }

    private void move() {
        if (!moving) return;
        switch (dir){
            case LEFT:
                x -=speed;
                image = this.group == Group.GOOD?ResourceMgr.goodTankL:ResourceMgr.badTankL;
                break;
            case RIGHT:
                x +=speed;
                image = this.group == Group.GOOD?ResourceMgr.goodTankR:ResourceMgr.badTankR;
                break;
            case UP:
                y -=speed;
                image = this.group == Group.GOOD?ResourceMgr.goodTankU:ResourceMgr.badTankU;
                break;
            case DOWN:
                y +=speed;
                image = this.group == Group.GOOD?ResourceMgr.goodTankD:ResourceMgr.badTankD;
                break;
            default:
                break;
        }
        /**边界返回*/
        boundsCheck();

        this.rectangle.x = this.x;
        this.rectangle.y = this.y;

        if (this.group == Group.BAD){
            if (random.nextInt(10) >8)this.fire();
            if (random.nextInt(10) >8)randomDir();
        }
    }

    private void boundsCheck() {
        if (x < 0) x = 2;
        if (y < 28) y = 28;
        if (x > TankFrame.GAME_WIDRTH -2)x = TankFrame.GAME_WIDRTH - Tank.tankWidth-2;
        if (y > TankFrame.GAME_HEGITH -2)y = TankFrame.GAME_HEGITH - Tank.tankHeght-2;
    }

    private void randomDir() {
        this.dir = Dir.values()[random.nextInt(4)];
    }


    /*打子弹 */
    public void fire() {
        int bx = this.x + this.tankWidth/2 - Build.width/2;
        int by = this.y + this.tankHeght/2 - Build.height/2;
        tf.builds.add(new Build(bx,by,this.dir,this.tf,this.group));
    }

    public void die() {
        this.living = false;
    }
}
