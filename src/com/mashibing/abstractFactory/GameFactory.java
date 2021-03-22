package com.mashibing.abstractFactory;

import com.mashibing.tank.Dir;
import com.mashibing.tank.Group;
import com.mashibing.tank.TankFrame;

public abstract class GameFactory {

    public abstract BaseExplode createExplode(Integer x, Integer y, TankFrame tf);

    public abstract BaseTank createTank(Integer x, Integer y, Dir dir, TankFrame tf, Group group);

    public abstract BaseBuild createBuild(Integer x, Integer y, Dir dir,TankFrame tf,Group group);



}
