package com.mashibing.tank;

import java.util.LinkedList;
import java.util.List;

public class ColliderChain {

    List<Collider> colliders = new LinkedList<>();

    public ColliderChain(){
        String colliderClass = (String) PorioertiesMgr.get("colliderClass");
        String[] c = colliderClass.split(",");
        for (String s:c){
            try {
                Collider collider = (Collider) Class.forName(s).newInstance();
                add(collider);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void add(Collider c){
        colliders.add(c);
    }

    public void remove(Collider c){
        colliders.remove(c);
    }

    public void collide(GameObject go1,GameObject go2){
        for (int i =0; i<colliders.size();i++){
            if (!colliders.get(i).collideWith(go1,go2)){
                return;
            }

        }
    }
}
