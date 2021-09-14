package com.DesignPattern.Proxy;

//客户类，一般客户都会去找代理！
//public class Client {
//    public static void main(String[] args) {
//        //房东要租房
//        Host host = new Host();
//        //中介帮助房东
//        Proxy proxy = new Proxy(host);
//
//        //你去找中介！
//        proxy.rent();
//    }
//}

//租客
public class Client {
    public static void main(String[] args) {
        //真实角色
        Host host = new Host();
        //代理实例的调用处理程序
        ProxyInvocationHandler pih = new ProxyInvocationHandler();
        pih.setRent(host); //将真实角色放置进去！
        Rent proxy = (Rent)pih.getProxy(); //动态生成对应的代理类！
        proxy.rent();
    }

}