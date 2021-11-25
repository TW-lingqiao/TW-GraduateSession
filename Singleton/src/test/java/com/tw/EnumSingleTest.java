package com.tw;


import com.tw.D05_enum.EnumSingle;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.lang.reflect.Constructor;

public class EnumSingleTest {


    @Test
    public void test1() {
        EnumSingle instance1 = EnumSingle.INSTANCE;
        EnumSingle instance2 = EnumSingle.INSTANCE;

        System.out.println(instance1);
        System.out.println(instance2);
    }

    @Test
    public void test2() throws Exception {
        EnumSingle instance1 = EnumSingle.INSTANCE;


        assertThrows(NoSuchMethodException.class, () -> EnumSingle.class.getDeclaredConstructor(null));

//        Constructor<EnumSingle> declaredConstructor = EnumSingle.class.getDeclaredConstructor(null);
//        declaredConstructor.setAccessible(true);
//        EnumSingle instance2 = declaredConstructor.newInstance();
//
//        System.out.println(instance1);
//        System.out.println(instance2);
    }

    //反射没法破坏枚举的单例
    @Test
    public void test3() throws Exception {
        EnumSingle instance1 = EnumSingle.INSTANCE;

        Constructor<EnumSingle> declaredConstructor = EnumSingle.class.getDeclaredConstructor(String.class,int.class);
        declaredConstructor.setAccessible(true);

        assertThrows(IllegalArgumentException.class, () -> declaredConstructor.newInstance());

//        EnumSingle instance2 = declaredConstructor.newInstance();
//        System.out.println(instance1);
//        System.out.println(instance2);
    }
}
