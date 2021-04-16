package com.mashibing.tank;

import com.mashibing.util.Dir;

public class FourDirFire implements FireFactory {
    @Override
    public void fire(Tank t) {
        int bx = t.x + t.tankWidth/2 - Build.width/2;
        int by = t.y + t.tankHight/2 - Build.hight/2;
        for (Dir dir:Dir.values())new Build(bx,by,dir,t.group);
    }
}
