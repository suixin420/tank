package com.mashibing.collider;


import com.mashibing.collider.Collider;
import com.mashibing.tank.*;

public class BuildTankCollider implements Collider {

    @Override
    public boolean collideWith(GameObject go1, GameObject go2) {
        if (go1 instanceof Build && go2 instanceof Tank){
            Build b = (Build)go1;
            Tank t = (Tank)go2;
            if (b.group == t.group || t.group == Group.GOOD){
                return true;
            }
            if (b.rectangle.intersects(t.rectangle)) {
                t.die();
                b.die();
                GameModel.getInstance().add(new Explode(t.x,t.y));
                return false;
            }else {
                return true;
            }

        }else if (go1 instanceof Tank && go2 instanceof Build){
            collideWith(go2,go1);
        }else {
            return true;
        }
        return true;
    }
}
