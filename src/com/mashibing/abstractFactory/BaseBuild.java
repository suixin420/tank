package com.mashibing.abstractFactory;

import com.mashibing.tank.Tank;

import java.awt.*;

public abstract class BaseBuild {

    public abstract void paint(Graphics g);

    public abstract void collideWith(Tank tank);
}
