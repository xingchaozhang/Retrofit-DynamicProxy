package com.enjoy.lib;

import com.enjoy.lib.agent.Agent;
import com.enjoy.lib.statics.Alvin;
import com.enjoy.lib.statics.Lucy;

import java.io.FileOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//import sun.misc.ProxyGenerator;

public class MyClass {

    public static void main(String[] args) throws Exception {
        //静态代理
//        Massage message = new Lucy();
//        Agent agent = new Agent(message);
//
//        agent.massage();

        //动态代理
        Alvin alvin = new Alvin();


        Object o = Proxy.newProxyInstance(MyClass.class.getClassLoader(),
                new Class[]{Massage.class, Wash.class}, new InvocationHandler() {
                    @Override
                    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                        System.out.println(o.toString());
                        return method.invoke(alvin,objects);
                    }
                });

        Massage massage = (Massage) o;
        massage.massage();

        Wash wash = (Wash) o;
        wash.wash();


        proxy();
    }


    private static void proxy() throws Exception {
        String name = Massage.class.getName() + "$Proxy0";
        //生成代理指定接口的Class数据
//        byte[] bytes = ProxyGenerator.generateProxyClass(name, new Class[]{Massage.class});
//        FileOutputStream fos = new FileOutputStream("lib/" + name + ".class");
//        fos.write(bytes);
//        fos.close();
    }
}
