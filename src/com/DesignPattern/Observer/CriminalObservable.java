package com.DesignPattern.Observer;

// 罪犯属于被观察者：
public class CriminalObservable extends Observable{
    // 罪犯继承自被观察者类，当罪犯有犯罪行为时，所有的观察者都会收到通知。
    public void crime(String event) {
        System.out.println("罪犯正在" + event);
        notifyObservers(event);
    }
}
