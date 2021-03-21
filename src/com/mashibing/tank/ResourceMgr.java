package com.mashibing.tank;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ResourceMgr {
    public static BufferedImage goodTankL,goodTankU,goodTankR,goodTankD;
    public static BufferedImage badTankL,badTankU,badTankR,badTankD;
    public static BufferedImage buildL,buildU,buildR,buildD;
    public static BufferedImage[] explode = new BufferedImage[16];


    private ResourceMgr(){

    }

    private static class ResourceMgrHold{
        private final static ResourceMgr INSTANCE =new ResourceMgr();
    }

    public static ResourceMgr getInstance(){
        return ResourceMgrHold.INSTANCE;
    }

//    private final static ResourceMgr INSTANCE =new ResourceMgr();
//    public static ResourceMgr getInstance(){
//        return INSTANCE;
//    }

    static {
        try {
//            buildL = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("com/images/bulletL.gif"));
//            buildU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("com/images/bulletU.gif"));
//            buildR = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("com/images/bulletR.gif"));
//            buildD = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("com/images/bulletD.gif"));

            buildU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("com/images/bulletU.png"));
            buildL = ImageUtil.rotateImage(buildU,-90);
            buildR = ImageUtil.rotateImage(buildU,90);
            buildD = ImageUtil.rotateImage(buildU,180);

//            tankL = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("com/images/tankL.gif"));
//            tankU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("com/images/tankU.gif"));
//            tankR = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("com/images/tankR.gif"));
//            tankD = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("com/images/tankD.gif"));

            goodTankU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("com/images/GoodTank1.png"));
            goodTankL = ImageUtil.rotateImage(goodTankU,-90);
            goodTankR = ImageUtil.rotateImage(goodTankU,90);
            goodTankD = ImageUtil.rotateImage(goodTankU,180);

            badTankU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("com/images/BadTank1.png"));
            badTankL = ImageUtil.rotateImage(badTankU,-90);
            badTankR = ImageUtil.rotateImage(badTankU,90);
            badTankD = ImageUtil.rotateImage(badTankU,180);

            for (int i = 0; i < 16; i++){
                explode[i] = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("com/images/e"+(i+1)+".gif"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
