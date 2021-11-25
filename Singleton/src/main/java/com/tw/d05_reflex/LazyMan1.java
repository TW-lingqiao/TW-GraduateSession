package com.tw.d05_reflex;

public class LazyMan1{

    private LazyMan1() {
        synchronized (LazyMan.class) {
            if (lazyMan != null) {
                throw new RuntimeException("不要试图使用反射来破坏");
            }
        }
        System.out.println(Thread.currentThread().getName() + "-ok");
    }

    private volatile static LazyMan1 lazyMan;

    public static LazyMan1 getInstance() {
        synchronized (LazyMan1.class) {
            if (lazyMan == null) {
                lazyMan = new LazyMan1();
            }
        }
        return lazyMan;
    }
}
