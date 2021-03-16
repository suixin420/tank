package com.mashibing.tank;

import java.awt.*;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        TankFrame f = new TankFrame();

        for (int i=0; i <= 250 ; i=i+50) {
            f.tanks.add(new Tank(400+i,400,Dir.DOWN,f));
        }
        while (true){
            Thread.sleep(50);
            f.repaint();
        }
    }
}
