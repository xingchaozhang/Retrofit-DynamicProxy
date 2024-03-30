package com.enjoy.lib.dynamic;

public class RealSubject implements Subject,Subject2,Subject3 {
    @Override
    public void doAction() {
        System.out.println("Executing action in RealSubject");
    }

    @Override
    public void doAction2() {

    }

    @Override
    public void doAction3() {

    }
}
