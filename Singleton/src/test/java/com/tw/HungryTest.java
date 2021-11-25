package com.tw;

import com.tw.d01_hungry.Hungry;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HungryTest {

    @Test
    public void should_init_the_resource_when_called(){
        assertEquals("com.tw.d01_hungry.Hungry",Hungry.getInstance().getClass().getName());
        assertEquals("Hungry",Hungry.getInstance().getClass().getSimpleName());
    }

    @Test
    public void should_init_the_resource_when_not_called(){

    }
}
