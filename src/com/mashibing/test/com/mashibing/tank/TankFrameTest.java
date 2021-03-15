package com.mashibing.tank;

import static org.junit.Assert.*;

public class TankFrameTest {

    @org.junit.Test
    public void paint() {
        TankFrame f = new TankFrame();

        while (true){
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            f.repaint();
        }
    }
}