package com.enjoy.lib.statics;

import com.enjoy.lib.Massage;
import com.enjoy.lib.Wash;

/**
 *  实实现类： 提供马杀鸡服务的Alvin
 */
public class Alvin implements Massage, Wash {

    @Override
    public void massage() {

        System.out.println("AAAAAAAAAAAAAAA");
    }

    @Override
    public void wash() {
        System.out.println("BBBBBBBBBBBBBBBB");
    }
}
