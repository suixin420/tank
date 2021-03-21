package com.mashibing.tank;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Tank {
    public Integer x=20,y=20;
    public static final Integer tankWidth=ResourceMgr.goodTankD.getWidth(), tankHight=ResourceMgr.goodTankD.getWidth();
    public Dir dir;
    static final Integer speed=Integer.parseInt(PorioertiesMgr.get("tankSpeed").toString());
    private boolean moving = true;
    TankFrame tf=null;
    private BufferedImage image = ResourceMgr.goodTankD;
    private boolean living=true;
    public Group group = Group.BAD;
    private Random random = new Random();

    FireFactory fireFactory;


    public Tank(Integer x, Integer y,Dir dir,TankFrame tf,Group group) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
        this.group = group;

        if (this.group == Group.GOOD){
            String fireFactoryName = PorioertiesMgr.get("goodDirFire").toString();
            try {
                fireFactory = (FireFactory)Class.forName(fireFactoryName).getDeclaredConstructor().newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else {
            fireFactory = new DefaulFire();
        }
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public boolean isMoving() {
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

        if (this.group == Group.BAD){
            if (random.nextInt(10) >8){

                fire();
            }
            if (random.nextInt(10) >8)randomDir();
        }

    }

    private void boundsCheck() {
        if (x < 0) x = 2;
        if (y < 28) y = 28;
        if (x > TankFrame.GAME_WIDRTH -2)x = TankFrame.GAME_WIDRTH - Tank.tankWidth-2;
        if (y > TankFrame.GAME_HEGITH -2)y = TankFrame.GAME_HEGITH - Tank.tankHight-2;
    }

    private void randomDir() {
        this.dir = Dir.values()[random.nextInt(4)];
    }


    /*打子弹 */
    public void fire() {
        fireFactory.fire(this);
    }

    public void die() {
        this.living = false;
    }
}
