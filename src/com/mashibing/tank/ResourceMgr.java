package com.mashibing.tank;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ResourceMgr {
    public static BufferedImage tankL,tankU,tankR,tankD;
    public static BufferedImage buildL,buildU,buildR,buildD;
    public static BufferedImage[] explode = new BufferedImage[16];

    static {
        try {
            buildL = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("com/images/bulletL.gif"));
            buildU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("com/images/bulletU.gif"));
            buildR = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("com/images/bulletR.gif"));
            buildD = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("com/images/bulletD.gif"));


            tankL = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("com/images/tankL.gif"));
            tankU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("com/images/tankU.gif"));
            tankR = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("com/images/tankR.gif"));
            tankD = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("com/images/tankD.gif"));

            for (int i = 0; i < 16; i++){
                explode[i] = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("com/images/e"+(i+1)+".gif"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
