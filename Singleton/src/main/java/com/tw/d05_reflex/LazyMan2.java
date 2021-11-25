package com.tw.d05_reflex;

public class LazyMan2 {

    private static boolean flag = false;

    private LazyMan2() {
        synchronized (LazyMan.class) {
            if (flag == false) {
                flag = true;
            } else {
                throw new RuntimeException("不要试图使用反射来破坏");
            }
        }
        System.out.println(Thread.currentThread().getName() + "-ok");
    }

    private volatile static LazyMan2 lazyMan;

    public static LazyMan2 getInstance() {
        synchronized (LazyMan2.class) {
            if (lazyMan == null) {
                lazyMan = new LazyMan2();
            }
        }
        return lazyMan;
    }
}
