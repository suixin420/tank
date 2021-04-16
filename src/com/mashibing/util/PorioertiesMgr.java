package com.mashibing.util;

import java.io.IOException;
import java.util.Properties;

public class PorioertiesMgr {

    static Properties props = new Properties();

    static {
        try {
            props.load(PorioertiesMgr.class.getClassLoader().getResourceAsStream("config"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object get(String key) {
        if(props == null) return null;
        return props.get(key);
    }

    //int getInt(key)
    //getString(key)

    public static void main(String[] args) {
        System.out.println(PorioertiesMgr.get("initTankCount"));

    }

}
