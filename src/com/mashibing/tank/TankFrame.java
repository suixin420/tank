package com.mashibing.tank;


import com.mashibing.util.Dir;
import com.mashibing.util.PorioertiesMgr;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame {

    public static final Integer GAME_WIDRTH=Integer.parseInt(PorioertiesMgr.get("gameWidth").toString());
    public static final Integer GAME_HEGITH=Integer.parseInt(PorioertiesMgr.get("gameHeight").toString());


    public TankFrame(){
        setSize(GAME_WIDRTH,GAME_HEGITH);
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

    Image offScreenImage = null;
    @Override
    public void update(Graphics g){
        if (offScreenImage == null){
            offScreenImage = this.createImage(GAME_WIDRTH,GAME_HEGITH);
        }
        Graphics gOffScreen =offScreenImage.getGraphics();
        Color color = gOffScreen.getColor();
        gOffScreen.setColor(Color.black);
        gOffScreen.fillRect(0,0,GAME_WIDRTH,GAME_HEGITH);
        gOffScreen.setColor(color);
        paint(gOffScreen);
        g.drawImage(offScreenImage,0,0,null);
    }

    public void paint(Graphics g){
        GameModel.getInstance().paint(g);

    }

    /**监听按键*/
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
                    GameModel.getInstance().myTank.fire();
                    break;
                default:
                    break;
            }

            setMainTankDir();
        }

        @Override
        public void keyReleased(KeyEvent e) {
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
            Tank myTank = GameModel.getInstance().myTank;
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
