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

        switch(dir) {
            case LEFT:
                g.drawImage(ResourceMgr.buildL, x, y, null);
                break;
            case UP:
                g.drawImage(ResourceMgr.buildU, x, y, null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.buildR, x, y, null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.buildD, x, y, null);
                break;
        }
        move();
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

        rectangle.x = this.x;
        rectangle.y = this.y;
    }



    public void die() {
        this.living=false;
    }
}
