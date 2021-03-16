package com.mashibing.tank;

import org.junit.Test;

import javax.imageio.ImageIO;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertNotNull;


public class ResourceMgrTest {

    @Test
    void getImg() throws IOException {
//        BufferedImage tankL = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("com/image/tankL.jpg"));
//        assertNotNull(tankL);
//        BufferedImage tankR = ImageIO.read(new File("C:/Users/Administrator/Desktop/照片.jpg"));
        Image image= Toolkit.getDefaultToolkit().getImage("com/image/tankL.jpg");
        assertNotNull(image);
    }
}