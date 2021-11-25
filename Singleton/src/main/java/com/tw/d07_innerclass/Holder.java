package com.tw.d07_innerclass;

/**
 * 03-静态内部类的实现方式：(不安全的!)
 */
public class Holder {

    private Holder() { }

    public static class InnerClass {
        private static final Holder HOLDER = new Holder();
    }

    public static Holder getInstance() {
        return InnerClass.HOLDER;
    }
}
