package com.mashibing.tank;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class MainTest {

    public static void main(String[] args) {
        Msg msg = new Msg();
        msg.setMsg("大家好:),<script>,欢迎访问,大家都是996");

        FilterChain fc = new FilterChain();
        fc.addFilter(new HtmlFilter()).addFilter(new SensitiveFilter());

        FilterChain fc2 = new FilterChain();
        fc2.addFilter(new FaceFilter());

        fc.addFilter(fc2);
        fc.doFilter(msg);

        System.out.println(msg);
    }
}

class Msg{
    String name;
    String msg;

    @Override
    public String toString() {
        return "Msg{" +
                "msg='" + msg + '\'' +
                '}';
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

interface Filter{
    void doFilter(Msg msg);
}

class HtmlFilter implements Filter{
    @Override
    public void doFilter(Msg msg) {
        String c = msg.getMsg();
        c = c.replace("<","{");
        c = c.replace(">", "]");
        msg.setMsg(c);
    }
}

class SensitiveFilter implements Filter{
    @Override
    public void doFilter(Msg msg) {
        String c = msg.getMsg();
        c = c.replace("996","751");
        c = c.replace(">", "]");
        msg.setMsg(c);
    }
}

class FaceFilter implements Filter{
    @Override
    public void doFilter(Msg msg) {
        String c = msg.getMsg();
        c = c.replace(")","V");
        msg.setMsg(c);
    }
}

class FilterChain implements Filter{
    List<Filter> filters = new ArrayList<>();

    public FilterChain addFilter(Filter f){
        filters.add(f);
        return this;
    }
    public void doFilter(Msg msg) {
        for (Filter f:filters){
            f.doFilter(msg);
        }
    }

}