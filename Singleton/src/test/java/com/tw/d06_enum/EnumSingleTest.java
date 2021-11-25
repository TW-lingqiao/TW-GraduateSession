package com.tw.d06_enum;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.lang.reflect.Constructor;

public class EnumSingleTest {

    @Test
    public void should_equal_when_use_enum_to_create() {
        EnumSingle instance1 = EnumSingle.INSTANCE;
        EnumSingle instance2 = EnumSingle.INSTANCE;
        assertEquals(instance1,instance2);
    }

    @Test
    public void should_throw_no_such_method_exceptipn_when_no_args() throws Exception {
        EnumSingle instance1 = EnumSingle.INSTANCE;
//        Constructor<EnumSingle> declaredConstructor = EnumSingle.class.getDeclaredConstructor(new Class[0]);
//        declaredConstructor.setAccessible(true);
//        EnumSingle instance2 = declaredConstructor.newInstance();
        assertThrows(NoSuchMethodException.class, () -> EnumSingle.class.getDeclaredConstructor(new Class[0]));
    }

    //反射没法破坏枚举的单例
    @Test
    public void should_throw_illegal_argument_exception_when_two_args() throws Exception {
        EnumSingle instance1 = EnumSingle.INSTANCE;

        Constructor<EnumSingle> declaredConstructor = EnumSingle.class.getDeclaredConstructor(String.class,int.class);
        declaredConstructor.setAccessible(true);
        // EnumSingle instance2 = declaredConstructor.newInstance();
        assertThrows(IllegalArgumentException.class, () -> declaredConstructor.newInstance());
    }
}
