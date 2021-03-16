package com.mashibing.tank;

import java.awt.*;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        TankFrame f = new TankFrame();

        while (true){
            Thread.sleep(50);
            f.repaint();
        }
    }
}
