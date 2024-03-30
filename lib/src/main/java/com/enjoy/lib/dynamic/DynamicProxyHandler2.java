package com.enjoy.lib.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

public class DynamicProxyHandler2 implements InvocationHandler {
    private Object subject1;
    private Object subject2;
    private Object subject3;

    public DynamicProxyHandler2(Object subject1, Object subject2, Object subject3) {
        this.subject1 = subject1;
        this.subject2 = subject2;
        this.subject3 = subject3;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Method called: " + method.getName());
        // 根据method所属的接口类型，将调用分派到不同的实际对象
        if (Arrays.asList(subject1.getClass().getInterfaces()).contains(method.getDeclaringClass())) {
            return method.invoke(subject1, args);
        } else if (Arrays.asList(subject2.getClass().getInterfaces()).contains(method.getDeclaringClass())) {
            return method.invoke(subject2, args);
        } else if (Arrays.asList(subject3.getClass().getInterfaces()).contains(method.getDeclaringClass())) {
            return method.invoke(subject3, args);
        }
        throw new RuntimeException("Method not supported: " + method.getName());
    }
}