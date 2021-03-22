package com.mashibing.abstractFactory;

import com.mashibing.tank.*;

public class DefaultFactory extends GameFactory {

    @Override
    public BaseExplode createExplode(Integer x, Integer y, TankFrame tf) {
        return new Explode( x, y, tf);
    }

    @Override
    public BaseTank createTank(Integer x, Integer y, Dir dir, TankFrame tf, Group group) {
        return new Tank( x,  y, dir, tf, group);
    }

    @Override
    public BaseBuild createBuild(Integer x, Integer y, Dir dir, TankFrame tf, Group group) {
        return new Build(x,y,dir,tf,group);
    }
}
