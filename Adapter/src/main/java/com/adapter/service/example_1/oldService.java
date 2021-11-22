package com.adapter.service.example_1;

import java.util.Arrays;
import java.util.List;

public class oldService<T> {
    public void listAll(T[] array) {
        Arrays.stream(array).forEach(a -> System.out.print((String) a));
    }

    public void listAll(List<T> array) {
        array.forEach(a -> System.out.print((String) a));
    }
}
