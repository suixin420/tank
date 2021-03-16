package com.mashibing.tank;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ResourceMgr {
    public static BufferedImage tankL,tankU,tankR,tankD,build;

    static {
        try {
            build = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("com/image/build.png"));
            tankL = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("com/image/tankL.png"));
            tankU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("com/image/tankU.png"));
            tankR = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("com/image/tankR.png"));
            tankD = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("com/image/tankD.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
