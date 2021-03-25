package com.mashibing.tank;


public class TankWallCollider implements Collider {

    @Override
    public boolean collideWith(GameObject go1, GameObject go2) {
        if (go1 instanceof Build && go2 instanceof Wall){
            Build b = (Build)go1;
            Wall w = (Wall)go2;
            if (b.rectangle.intersects(w.rectangle)) {
                b.die();
                return false;
            }else {
                return true;
            }
        }else if (go1 instanceof Wall && go2 instanceof Build){
            collideWith(go2,go1);
        }else if (go1 instanceof Tank && go2 instanceof Wall){
            Tank t = (Tank)go1;
            Wall w = (Wall)go2;
            if (t.rectangle.intersects(w.rectangle)) {
                t.goBack();
            }
            return true;
        }else if (go1 instanceof Wall && go2 instanceof Tank){
            collideWith(go2,go1);
        }else {
            return true;
        }
        return true;
    }
}
