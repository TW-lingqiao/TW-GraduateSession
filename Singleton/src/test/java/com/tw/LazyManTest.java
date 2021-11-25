package com.tw;

import com.tw.d02_lazyman.LazyMan;
import org.junit.jupiter.api.Test;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LazyManTest {

    //单线程
    @Test
    public void when_the_condition_is_singlethread_two_results_are_output() {
        new Thread(() -> {
            String name = LazyMan.getInstance().getClass().getName();
            assertEquals("Thread-4-ok",name);
        }).start();

    }

    //多线程
    @Test
    public void when_the_condition_is_multithreaded_two_results_are_output() {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                LazyMan.getInstance();
            }).start();
        }
    }

    /**
     * 反射破坏的第一种方法：
     * 解决：在LazyMan的构造方法做一个判断即可：
     *        synchronized (LazyMan.class) {
     *             if(lazyMan != null){
     *                 throw new RuntimeException("不要试图使用反射来破坏");
     *             }
     *         }
     */
//    @Test
//    public void use_reflection_to_destroy1() throws Exception {
//        LazyMan lazyMan = new LazyMan();
//        LazyMan instance1 = lazyMan.getInstance();
//        Constructor<LazyMan> declaredConstructor = LazyMan.class.getDeclaredConstructor(null); //获取空参构造器
//        declaredConstructor.setAccessible(true); //有一个非常霸道的方法，无视构造器私有化
//        LazyMan instance2 = declaredConstructor.newInstance(); //然后通过反射来创建对象
//
//        System.out.println(instance1);
//        System.out.println(instance2);
//    }

    /**
     * 反射破坏另外一种方式:
     *
     * private static boolean flag = false;
     *
     *         synchronized (LazyMan.class) {
     *             if(flag == false){
     *                 flag = true;
     *             }else{
     *                 throw new RuntimeException("不要试图使用反射来破坏");
     *             }
     *         }
     */
    @Test
    public void use_reflection_to_destroy2() throws Exception {

//        Constructor<LazyMan> declaredConstructor = LazyMan.class.getDeclaredConstructor(null); //获取空参构造器
//        declaredConstructor.setAccessible(true); //有一个非常霸道的方法，无视构造器私有化
//        LazyMan instance2 = declaredConstructor.newInstance(); //然后通过反射来创建对象
//        LazyMan instance1 = declaredConstructor.newInstance();
//
//        System.out.println(instance1);
//        System.out.println(instance2);
    }

    /**
     * 反射破坏继续破坏：
     *          将标识位修改   道高一尺 魔高一丈
     *
     * 解决：
     *      请看源码！newInstance  -> 引出枚举
     *      请看下回解析
     *
     * @throws Exception
     */
//    @Test
//    public void use_reflection_to_destroy3() throws Exception {
//
//        Field flag = LazyMan.class.getDeclaredField("flag");
//        flag.setAccessible(true);
//
//        Constructor<LazyMan> declaredConstructor = LazyMan.class.getDeclaredConstructor(null); //获取空参构造器
//        declaredConstructor.setAccessible(true); //有一个非常霸道的方法，无视构造器私有化
//        LazyMan instance1 = declaredConstructor.newInstance();
//        flag.set(instance1,false);
//
//        LazyMan instance2 = declaredConstructor.newInstance(); //然后通过反射来创建对象
//
//        System.out.println(instance1);
//        System.out.println(instance2);
//    }
}
