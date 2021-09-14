package com.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DebugInvocationHandler implements InvocationHandler {
    /**
     * 代理类中的真实对象
     */
    private final Object target;

    public DebugInvocationHandler(Object target) {
        this.target = target;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws InvocationTargetException, IllegalAccessException {
        System.out.println("before method " + method.getName());
        Object result = method.invoke(target, args);
        System.out.println("after method " + method.getName());
        return result;
    }

    public static void main(String[] args) {
        String Target = new String("Target");
        DebugInvocationHandler debugInvocationHandler = new DebugInvocationHandler(Target);
        Proxy proxy = (Proxy) Proxy.newProxyInstance(Target.getClass().getClassLoader(), Target.getClass().getInterfaces(), debugInvocationHandler);
        System.out.println(proxy.equals(new String("Proxy"))); // false
    }
}

