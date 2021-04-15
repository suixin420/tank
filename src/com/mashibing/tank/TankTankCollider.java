package com.mashibing.tank;


public class TankTankCollider implements Collider {

    @Override
    public boolean collideWith(GameObject go1, GameObject go2) {
        if (go1 instanceof Tank && go2 instanceof Tank){
            Tank t1 = (Tank)go1;
            Tank t2 = (Tank)go2;
            if (t1.rectangle.intersects(t2.rectangle)) {
//                t1.goBack();
//                t2.goBack();
            }
            return true;
        }else {
            return true;
        }
    }
}
