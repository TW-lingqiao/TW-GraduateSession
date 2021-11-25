package com.tw.d05_reflex;

import org.junit.jupiter.api.Test;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.*;

public class LazyManTest {

    /**
     * 反射破坏的第一种方法：
     * 解决：在LazyMan的构造方法做一个判断即可：
     */
    @Test
    public void not_equal_when_use_reflex_destory_to_create_object() throws Exception {
        LazyMan instance1 = LazyMan.getInstance();
        Constructor<LazyMan> declaredConstructor = LazyMan.class.getDeclaredConstructor(new Class[0]); //通过反射的方式去获取空参构造器
        declaredConstructor.setAccessible(true); //有一个非常霸道的方法，无视构造器私有化
        LazyMan instance2 = declaredConstructor.newInstance(); //然后通过反射来创建对象
        assertNotEquals(instance1, instance2);
    }

    @Test
    public void should_throw_exception_when_use_judge_to_forbid_reflex() throws Exception {
        LazyMan1 instance1 = LazyMan1.getInstance();
        Constructor<LazyMan1> declaredConstructor = LazyMan1.class.getDeclaredConstructor(new Class[0]); //获取空参构造器
        declaredConstructor.setAccessible(true);
        //LazyMan1 instance2 = declaredConstructor.newInstance();
        assertThrows(InvocationTargetException.class, ()-> declaredConstructor.newInstance());
    }

    /**
     * 反射破坏第二种方法:
     * 解决：在构造器中加入标签位判断
     */
    @Test
    public void not_equal_when_use_reflex_create_different_object() throws Exception {
        Constructor<LazyMan1> declaredConstructor = LazyMan1.class.getDeclaredConstructor(new Class[0]); //获取空参构造器
        declaredConstructor.setAccessible(true); //无视构造器私有化
        LazyMan1 instance2 = declaredConstructor.newInstance(); //然后通过反射来创建对象
        LazyMan1 instance1 = declaredConstructor.newInstance();
        assertNotEquals(instance1, instance2);
    }

    @Test
    public void should_throw_exception_when_use_flag_judge_to_forbid_reflex() throws Exception {
        Constructor<LazyMan2> declaredConstructor = LazyMan2.class.getDeclaredConstructor(new Class[0]); //获取空参构造器
        declaredConstructor.setAccessible(true); //有一个非常霸道的方法，无视构造器私有化
        LazyMan2 instance2 = declaredConstructor.newInstance(); //然后通过反射来创建对象
        // LazyMan2 instance1 = declaredConstructor.newInstance();
        assertThrows(InvocationTargetException.class, ()-> declaredConstructor.newInstance());

    }

    /**
     * 反射破坏第三种方法：将标识位修改   道高一尺 魔高一丈
     * 解决： 请看源码！newInstance  -> 引出枚举
     *
     * @throws Exception
     */
    @Test
    public void not_equal_when_use_reflex_to_modify_flag() throws Exception {

        Field flag = LazyMan2.class.getDeclaredField("flag");
        flag.setAccessible(true);

        Constructor<LazyMan2> declaredConstructor = LazyMan2.class.getDeclaredConstructor(new Class[0]); //获取空参构造器
        declaredConstructor.setAccessible(true); //有一个非常霸道的方法，无视构造器私有化
        LazyMan2 instance1 = declaredConstructor.newInstance();
        flag.set(instance1, false);

        LazyMan2 instance2 = declaredConstructor.newInstance(); //然后通过反射来创建对象
        assertNotEquals(instance1, instance2);
    }
}
