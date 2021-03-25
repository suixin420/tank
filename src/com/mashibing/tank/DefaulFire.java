package com.mashibing.tank;

public class DefaulFire implements FireFactory {
    @Override
    public void fire(Tank t) {
        int bx = t.x + t.tankWidth/2 - Build.width/2;
        int by = t.y + t.tankHight/2 - Build.hight/2;
        new Build(bx,by,t.dir,t.group);
    }

}
