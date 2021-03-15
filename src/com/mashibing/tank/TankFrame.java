package com.mashibing.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

public class TankFrame extends Frame {
    Tank myTank = new Tank(200,200,Dir.DOWN,this);
    List<Build> buildList = new ArrayList<Build>();
    static final Integer frameWidth=800, frameHegith=800;


    public TankFrame(){
        setSize(frameWidth,frameHegith);
        setResizable(false);
        setTitle("窗口");
        setVisible(true);

        this.addKeyListener(new MykeyListener());

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public void paint(Graphics g){
        System.out.println("第一次打开或者隐藏后打开");
        Color color = g.getColor();
        g.setColor(Color.black);
        g.drawString("子弹数量"+buildList.size(),10,60);
        g.setColor(color);
        myTank.paint(g);
        for (int i=0;i<buildList.size();i++){
            buildList.get(i).paint(g);
        }

    }

    class MykeyListener extends KeyAdapter{
        boolean bl = false;
        boolean bu = false;
        boolean br = false;
        boolean bd= false;

        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key){
                case KeyEvent.VK_LEFT:
                    bl = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    br = true;
                    break;
                case KeyEvent.VK_UP:
                    bu =true;
                    break;
                case KeyEvent.VK_DOWN:
                    bd = true;
                    break;
                case KeyEvent.VK_CONTROL:
                    myTank.fire();
                    break;
                default:
                    break;
            }

            setMainTankDir();
        }



        @Override
        public void keyReleased(KeyEvent e) {
            System.out.println("抬起键盘");
            int key = e.getKeyCode();
            switch (key){
                case KeyEvent.VK_LEFT:
                    bl = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    br = false;
                    break;
                case KeyEvent.VK_UP:
                    bu =false;
                    break;
                case KeyEvent.VK_DOWN:
                    bd = false;
                    break;
                default:
                    break;
            }

            setMainTankDir();
        }

        private void setMainTankDir() {
            if (!bl && !br && !bu && !bd){
                myTank.setMoving(false);
            }else {
                myTank.setMoving(true);
                if (bl) myTank.setDir(Dir.LEFT);
                if (br) myTank.setDir(Dir.RIGHT);
                if (bu) myTank.setDir(Dir.UP);
                if (bd) myTank.setDir(Dir.DOWN);
            }

        }


    }
}
