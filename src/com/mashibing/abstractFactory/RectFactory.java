package com.mashibing.abstractFactory;

import com.mashibing.tank.Build;
import com.mashibing.tank.Dir;
import com.mashibing.tank.Group;
import com.mashibing.tank.TankFrame;

public class RectFactory extends GameFactory {
    @Override
    public BaseExplode createExplode(Integer x, Integer y, TankFrame tf) {
        return new RectExplode( x, y, tf);
    }

    @Override
    public BaseTank createTank(Integer x, Integer y, Dir dir, TankFrame tf, Group group) {
        return null;
    }

    @Override
    public BaseBuild createBuild(Integer x, Integer y, Dir dir, TankFrame tf, Group group) {
        return new RectBuild(x,y,dir,tf,group);
    }
}
