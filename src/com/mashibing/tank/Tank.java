package com.mashibing.tank;


import com.mashibing.util.Dir;
import com.mashibing.util.Group;
import com.mashibing.util.PorioertiesMgr;
import com.mashibing.util.ResourceMgr;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Tank extends GameObject {

//    public Integer x=20,y=20;
    public static final Integer tankWidth= ResourceMgr.goodTankD.getWidth(), tankHight=ResourceMgr.goodTankD.getWidth();
    public Dir dir;
    static final Integer speed=Integer.parseInt(PorioertiesMgr.get("tankSpeed").toString());
    private boolean moving = true;

    private BufferedImage image = ResourceMgr.goodTankD;
    private boolean living=true;
    public Group group = Group.BAD;
    private Random random = new Random();
    public Rectangle rectangle = new Rectangle();
    FireFactory fireFactory;

    public Integer oldx,oldy;

    public Rectangle getRectangle() {
        return rectangle;
    }

    public void setRectangle(Rectangle rectangle) {
        this.rectangle = rectangle;
    }

    public Tank(Integer x, Integer y, Dir dir,  Group group) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;

        this.oldx=this.x;
        this.oldy=this.y;

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
            GameModel.getInstance().remove(this);
            return;
        }

        switch (dir){
            case LEFT:
                g.drawImage(this.group == Group.GOOD?ResourceMgr.goodTankL:ResourceMgr.badTankL,x, y,null);
                break;
            case RIGHT:
                g.drawImage(this.group == Group.GOOD?ResourceMgr.goodTankR:ResourceMgr.badTankR,x, y,null);
                break;
            case UP:
                g.drawImage(this.group == Group.GOOD?ResourceMgr.goodTankU:ResourceMgr.badTankU,x, y,null);
                break;
            case DOWN:
                g.drawImage(this.group == Group.GOOD?ResourceMgr.goodTankD:ResourceMgr.badTankD,x, y,null);
                break;
            default:
                break;
        }
        move();

    }

    private void move() {
        this.oldx=x;
        this.oldy=y;
        if (!moving) return;

        switch (dir){
            case LEFT:
                x -=speed;
                break;
            case RIGHT:
                x +=speed;
                break;
            case UP:
                y -=speed;
                break;
            case DOWN:
                y +=speed;
                break;
            default:
                break;
        }

        if (this.group == Group.BAD){
            if (random.nextInt(100) >95)fire();
            if (random.nextInt(100) >90)randomDir();
        }

        /**边界返回*/
        boundsCheck();

        this.rectangle.x = this.x;
        this.rectangle.y = this.y;
    }

    private void boundsCheck() {
        if (x < 0) x = 20;
        if (y < 28) y = 28;
        if (x > TankFrame.GAME_WIDRTH -20)x = TankFrame.GAME_WIDRTH - Tank.tankWidth-20;
        if (y > TankFrame.GAME_HEGITH -28)y = TankFrame.GAME_HEGITH - Tank.tankHight-28;
    }

    private void randomDir() {
        this.dir = Dir.values()[random.nextInt(4)];
    }


    /*打子弹 */
    public void fire() {
        int bx = this.x + this.tankWidth/2 - Build.width/2;
        int by = this.y + this.tankHight/2 - Build.hight/2;
//        GameModel.getInstance().builds.add(new Build(bx,by,this.dir,this.group));
        GameModel.getInstance().add(new Build(bx,by,this.dir,this.group));
        fireFactory.fire(this);
    }

    public void die() {
        this.living = false;
    }

    public void goBack(){
        this.x=oldx;
        this.y=oldy;
        move();
    }

}
