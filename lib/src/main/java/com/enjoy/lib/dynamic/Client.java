package com.enjoy.lib.dynamic;

import com.enjoy.lib.Massage;
import com.enjoy.lib.MyClass;
import com.enjoy.lib.Wash;
import com.enjoy.lib.statics.Alvin;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Client {
    public static void main(String[] args) {
        RealSubject realSubject = new RealSubject();
        Subject proxySubject = (Subject) Proxy.newProxyInstance(
                RealSubject.class.getClassLoader(),
                new Class[]{Subject.class, Subject2.class, Subject3.class},
                new DynamicProxyHandler(realSubject));

//        Object o = Proxy.newProxyInstance(MyClass.class.getClassLoader(),
//                new Class[]{Subject.class, Subject2.class, Subject3.class},
//                new InvocationHandler() {
//                    @Override
//                    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
////                        System.out.println(o.toString());
//                        return method.invoke(proxySubject,objects);
//                    }
//                });
//
//        ((Subject)o).doAction(); // 使用代理执行方法
//        ((Subject2)o).doAction2(); // 使用代理执行方法
//        ((Subject3)o).doAction3(); // 使用代理执行方法
        Alvin alvin = new Alvin();


        Object o = Proxy.newProxyInstance(MyClass.class.getClassLoader(),
                new Class[]{Massage.class, Wash.class}, new InvocationHandler() {
                    @Override
                    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
//                        System.out.println(o.toString());
                        return method.invoke(alvin,objects);
                    }
                });

        Massage massage = (Massage) o;
        massage.massage();

        Wash wash = (Wash) o;
        wash.wash();

        RealSubject realSubject1 = new RealSubject();
        RealSubject2 realSubject2 = new RealSubject2();
        RealSubject3 realSubject3 = new RealSubject3();
        Subject proxySubject2 = (Subject) Proxy.newProxyInstance(
                RealSubject.class.getClassLoader(),
                new Class[]{Subject.class, Subject2.class, Subject3.class},
                new DynamicProxyHandler2(realSubject1, realSubject2, realSubject3));

        Object o2 = Proxy.newProxyInstance(MyClass.class.getClassLoader(),
                new Class[]{Subject.class, Subject2.class, Subject3.class},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                        System.out.println(o.toString());
                        return method.invoke(proxySubject2,objects);
                    }
                });
                ((Subject)o2).doAction(); // 使用代理执行方法
                ((Subject2)o2).doAction2(); // 使用代理执行方法
                ((Subject3)o2).doAction3(); // 使用代理执行方法
    }
}
