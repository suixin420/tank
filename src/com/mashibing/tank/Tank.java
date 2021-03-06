package com.mashibing.tank;

import com.mashibing.abstractFactory.BaseTank;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Tank extends BaseTank {

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
    Rectangle rectangle = new Rectangle();

    FireFactory fireFactory;


    public Rectangle getRectangle() {
        return rectangle;
    }

    public void setRectangle(Rectangle rectangle) {
        this.rectangle = rectangle;
    }

    public Tank(Integer x, Integer y, Dir dir, TankFrame tf, Group group) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
        this.group = group;

        this.rectangle.x = this.x;
        this.rectangle.y = this.y;
        this.rectangle.width = this.tankWidth;
        this.rectangle.height = this.tankHight;

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

    @Override
    public void paint(Graphics g) {
        if (!living){
            tf.tanks.remove(this);
            tf.explodes.add(tf.gf.createExplode(this.x,this.y,tf));
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
        /**????????????*/
        boundsCheck();

        this.rectangle.x = this.x;
        this.rectangle.y = this.y;

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


    /*????????? */
    public void fire() {
        int bx = this.x + this.tankWidth/2 - Build.width/2;
        int by = this.y + this.tankHight/2 - Build.hight/2;
        tf.builds.add(new Build(bx,by,this.dir,this.tf,this.group));
        fireFactory.fire(this);
    }

    public void die() {
        this.living = false;
    }
}
