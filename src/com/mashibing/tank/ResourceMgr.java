package com.mashibing.tank;

import com.sun.prism.Image;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;

public class ResourceMgr {
    public static BufferedImage tankL,tankU,tankR,tankD;

    static {
        try {
            tankL = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("com/image/1.jpg"));
            tankU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("com/image/2.jpg"));
            tankR = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("com/image/3.jpg"));
            tankD = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("com/image/4.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
