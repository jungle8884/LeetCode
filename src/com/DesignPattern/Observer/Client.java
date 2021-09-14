package com.DesignPattern.Observer;


import org.junit.Test;

public class Client {
    @Test
    public void test(){
        // 被观察者
        CriminalObservable zhangSan = new CriminalObservable();
        // 观察者
        PoliceObserver police1 = new PoliceObserver();
        PoliceObserver police2 = new PoliceObserver();
        PoliceObserver police3 = new PoliceObserver();
        // 订阅 或 注册
        zhangSan.addObserver(police1);
        zhangSan.addObserver(police2);
        zhangSan.addObserver(police3);
        // 张三违法, 警察抓捕
        zhangSan.crime("在嫖娼");
    }
}
