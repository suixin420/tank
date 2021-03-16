package com.mashibing.tank;

import java.awt.*;

public class Build {
    private static final Integer speed=10;
    public static final Integer width=ResourceMgr.build.getWidth(), hight=ResourceMgr.build.getHeight();
    private Integer x=10,y=10;
    private Dir dir;
    private boolean live = true;
    private TankFrame tf = null;

    public Build(Integer x, Integer y, Dir dir,TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
    }

    public boolean getLive() {
        return live;
    }

    public void setLive(boolean live) {
        this.live = live;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }


    public void paint(Graphics g) {
        if (!live){
            tf.buildList.remove(this);
        }

//        Color color = g.getColor();
//        g.setColor(Color.white);
//        g.fillOval(x, y, width, hight);
//        g.setColor(color);
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
        if (x <0 || y <0 || x > TankFrame.GAME_WIDRTH || y > TankFrame.GAME_HEGITH) live = false;
    }


}
