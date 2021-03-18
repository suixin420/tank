package com.mashibing.tank;

import java.awt.*;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        TankFrame f = new TankFrame();

        for (int i=0; i <= 300 ; i=i+90) {
            f.tanks.add(new Tank(200+i,200,Dir.DOWN,f,Group.BAD));
        }
        while (true){
            Thread.sleep(50);
            f.repaint();
        }
    }
}
