package com.mashibing.tank;

public interface Collider {

    /**
     * 碰撞检测 true继续检测
     * @param go1
     * @param go2
     * @return
     */
    public boolean collideWith(GameObject go1,GameObject go2);
}
