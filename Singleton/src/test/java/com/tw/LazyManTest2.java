package com.tw;

import com.tw.d03_locked.LazyMan;
import org.junit.jupiter.api.Test;

public class LazyManTest2 {

    LazyMan lazyMan = new LazyMan();

    @Test
    public void when_the_condition_is_singlethread_two_results_are_output() {
        new Thread(() -> {
            lazyMan.getInstance();
        }).start();
    }

    @Test
    public void when_the_condition_is_multithreaded_multiple_results_are_output() {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                lazyMan.getInstance();
            }).start();
        }
    }
}
