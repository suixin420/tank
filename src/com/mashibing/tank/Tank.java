package com.mashibing.tank;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Tank {
    private Integer x=20,y=20;
    public static final Integer tankWidth=ResourceMgr.tankD.getWidth(), tankHight=ResourceMgr.tankD.getWidth();
    private Dir dir;
     static final Integer speed=3;
    private boolean moving = true;
    TankFrame tf=null;
    private BufferedImage image = ResourceMgr.tankD;
    private boolean living=true;
    private Group group = Group.BAD;
    private Random random = new Random();

    public Tank(Integer x, Integer y,Dir dir,TankFrame tf,Group group) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
        this.group = group;
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
            tf.explode.setLiving(true);
            tf.explode.setX(this.x);
            tf.explode.setY(this.y);
            return;
        }
        move();
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
        if (x <0){
            dir=Dir.RIGHT;
            move();
        }
        if (y <0){
            dir=Dir.DOWN;
            move();
        }
        if (x > TankFrame.GAME_WIDRTH){
            dir=Dir.LEFT;
            move();
        }
        if (y > TankFrame.GAME_HEGITH){
            dir=Dir.UP;
            move();
        }

        if (random.nextInt(10) >8)this.fire();
    }


    /*打子弹 */
    public void fire() {
        int bx = this.x + this.tankWidth/2 - Build.width/2;
        int by = this.y + this.tankHight/2 - Build.hight/2;
        tf.builds.add(new Build(bx,by,this.dir,this.tf,this.group));
    }

    public void die() {
        this.living = false;
    }
}
