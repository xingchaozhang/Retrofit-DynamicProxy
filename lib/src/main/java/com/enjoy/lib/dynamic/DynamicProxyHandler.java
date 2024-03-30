package com.enjoy.lib.dynamic;

import java.lang.reflect.*;

public class DynamicProxyHandler implements InvocationHandler {
    private Object subject; // 实际对象的引用

    public DynamicProxyHandler(Object subject) {
        this.subject = subject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Before method: " + method.getName());
        Object result = method.invoke(subject, args); // 调用实际对象的方法
        System.out.println("After method: " + method.getName());
        return result;
    }
}
