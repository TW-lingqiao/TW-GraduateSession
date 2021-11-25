package com.tw.d02_lazyman;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LazyManTest {

    @Test
    public void should_init_the_resource_when_called() {
        assertEquals("com.tw.d02_lazyman.LazyMan", LazyMan.getInstance().getClass().getName());
        assertEquals("LazyMan", LazyMan.getInstance().getClass().getSimpleName());
    }

    //单线程
    @Test
    public void when_the_condition_is_singlethread_one_results_are_output() {
        new Thread(() -> {
            String canonicalName = LazyMan.getInstance().getClass().getCanonicalName();
            int modifiers = LazyMan.getInstance().getClass().getModifiers();
            assertEquals("com.tw.d02_lazyman.LazyMan", canonicalName);
            assertEquals(1, modifiers);
        }).start();
    }

    //多线程-每次输出都不一样
    @Test
    public void when_the_condition_is_multithreaded_many_different_results_are_output() {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                LazyMan.getInstance();
            }).start();
        }
    }
}
