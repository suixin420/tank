package com.mashibing.tank;

import com.mashibing.collider.ColliderChain;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameModel {
    private static GameModel INSTANCE = new GameModel();

    public static GameModel getInstance(){
        return INSTANCE;
    }
    List<GameObject> gameObjects = new ArrayList<>();

    ColliderChain colliderChain = new ColliderChain();

    Tank myTank = new Tank(100,200,Dir.DOWN,Group.GOOD);
//    public List<Build> builds = new ArrayList<Build>();

//    List<Tank> tanks = new ArrayList<Tank>();
//    public List<Explode> explodes = new ArrayList<Explode>();

    private GameModel(){
        this.add(myTank);
        int initTankCount = Integer.parseInt(PorioertiesMgr.get("initTankCount").toString());
        for (int i=0; i <= initTankCount ; i++) {
            this.add(new Tank(200+i*80,200+i*20,Dir.DOWN,Group.BAD));
        }

        add(new Wall(150,150,200,50));
        add(new Wall(550,150,200,50));
        add(new Wall(300,300,50,200));

    }

    public void add(GameObject go){
        this.gameObjects.add(go);
    }

    public void remove(GameObject go){
        this.gameObjects.remove(go);
    }

    public void paint(Graphics g){
//        Color color = g.getColor();
//        g.setColor(Color.white);
//        g.drawString("子弹数量"+builds.size(),10,60);
//        g.drawString("坦克数量"+tanks.size(),10,80);
//        g.setColor(color);

        for (int i=0;i<gameObjects.size();i++ ){
            gameObjects.get(i).paint(g);
        }

        for (int i=0; i<gameObjects.size();i++){
            for (int j=1; j<gameObjects.size();j++){
                GameObject go1 = gameObjects.get(i);
                GameObject go2 = gameObjects.get(j);
                colliderChain.collide(go1,go2);

            }
        }


    }

}
