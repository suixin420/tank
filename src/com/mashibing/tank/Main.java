package com.mashibing.tank;

import java.awt.*;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        TankFrame f = new TankFrame();

        int initTankCount = Integer.parseInt(PorioertiesMgr.get("initTankCount").toString());
        for (int i=0; i <= initTankCount ; i++) {
            f.tanks.add(new Tank(200+i*80,200,Dir.DOWN,f,Group.BAD));
        }
        while (true){
            Thread.sleep(50);
            f.repaint();
        }
    }
}
