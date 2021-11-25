package com.tw.d04_volatilelocked;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 * 双重检测锁模式：DCL-加锁来避免线程问题
 * 问题：
 *      表面上看起来好想没问题，输出也是对的
 *      lazyMan = new LazyMan(); 会经过如下的四个步骤：
 *            1、分配一块内存
 *            2、给成员变量赋个默认值,比如0
 *            3、执行构造方法，初始化对象
 *            4、把这个对象指向这个空间--把对象引用传递给lazyMan
 *          这就会可能会发生指令重排序的现象
 *          比如：
 *              1234
 *              1242  线程A  先分配内存空间，有可能进行完第二步，就直接进行第四步了，这时候lazyMan就成了个半初始化对象
 *                    线程B  另一个线程进来刚好lazyMan不为null，然后看代码执行最后的返回，并没有完成构造
 *
 *  解决：加volatile关键字
 */
public class LazyMan {

    private static boolean flag = false;

    public LazyMan() {
        System.out.println(Thread.currentThread().getName() + "-ok");
    }

    private volatile static LazyMan lazyMan;

    public static LazyMan getInstance() {
        synchronized (LazyMan.class) {
            if (lazyMan == null) {
                lazyMan = new LazyMan();
            }
        }
        return lazyMan;
    }
}
