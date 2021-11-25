package com.tw.d01_hungry;

/**
 * 01-饿汉式单例：先new一个对象，这样保证我们Hungry对象是唯一的
 * 问题：浪费内存-刚开始就会去初始化对象，导致没用也会初始化出来，就会浪费
 * 解决：使用懒汉式模式
 */
public class Hungry {

    private Hungry() {
        System.out.println("执行了构造私有方法！");
    } //构造器私有

    private final static Hungry HUNGRY = new Hungry();

    public static Hungry getInstance() {
        return HUNGRY;
    }
}
