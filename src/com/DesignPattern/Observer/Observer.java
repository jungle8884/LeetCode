package com.DesignPattern.Observer;

// 观察者接口 --- 基类1
public interface Observer {
    // 接口中只有一个 update 方法，用于对被观察者发出的事件做出响应。
    void update(String event);
}
