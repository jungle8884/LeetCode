package com.DesignPattern.Observer;

// 警察属于观察者：
public class PoliceObserver  implements Observer{

    // 响应
    @Override
    public void update(String event) {
        // 警察实现了观察者接口，当警察收到事件后，做出响应，这里的响应就是简单的打印了一条日志。
        System.out.println("警察收到消息，罪犯在" + event);
    }
}
