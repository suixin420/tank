package com.mashibing.tank;


import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Build extends GameObject{

    private static final Integer speed=Integer.parseInt(PorioertiesMgr.get("bulletSpeed").toString());
    public static final Integer width=ResourceMgr.buildD.getWidth(), hight=ResourceMgr.buildD.getHeight();
    private BufferedImage image = ResourceMgr.buildD;
//    private Integer x=10,y=10;
    private Dir dir;

    private boolean living = true;
    public Group group = Group.BAD;
    Rectangle rectangle = new Rectangle();


    public Build(Integer x, Integer y, Dir dir,Group group) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;

        this.rectangle.x = this.x;
        this.rectangle.y = this.y;
        this.rectangle.width = this.width;
        this.rectangle.height = this.hight;
//        GameModel.getInstance().builds.add(this);
        GameModel.getInstance().add(this);
    }

    public Dir getDir() {
        return dir;
    }
    public void setDir(Dir dir) {
        this.dir = dir;
    }

    @Override
    public void paint(Graphics g) {
        if (!living){
            GameModel.getInstance().remove(this);
        }

        move();
        g.drawImage(image,x, y,null);
    }

    private void move() {
        switch (dir){
            case LEFT:
                x -= speed;
                image = ResourceMgr.buildL;
                break;
            case RIGHT:
                x += speed;
                image = ResourceMgr.buildR;
                break;
            case UP:
                y -= speed;
                image = ResourceMgr.buildU;
                break;
            case DOWN:
                y += speed;
                image = ResourceMgr.buildD;
                break;
            default:
                break;
        }
        if (x <0 || y <0 || x > TankFrame.GAME_WIDRTH || y > TankFrame.GAME_HEGITH) this.living = false;

        rectangle.x = this.x;
        rectangle.y = this.y;
    }


    /**
     * 碰撞检测
     * @return  true 没有碰撞 false碰撞发生
     */
    public boolean collideWith(Tank tank) {
        if (this.group == tank.group) return true;
        if (this.rectangle.intersects(tank.rectangle)) {
            if (this.group == tank.group){
                return true;
            }
//            Rectangle rect1 = new Rectangle(this.x, this.y, width, hight);
//            Rectangle rect2 = new Rectangle(tank.x, tank.y, tank.tankWidth, tank.tankHight);

            Rectangle rect1 = this.rectangle;
            Rectangle rect2 = tank.rectangle;
            if (rect1.intersects(rect2)) {
                tank.die();
                this.die();
                return false;
            }else {
                return true;
            }
        }

        return true;
    }

    public void die() {
        this.living=false;
    }
}
