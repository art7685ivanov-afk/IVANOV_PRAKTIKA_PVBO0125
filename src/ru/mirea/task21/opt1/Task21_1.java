package ru.mirea.task21.opt1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task21_1 {
    public static <T> List<T> toList(T[] array) {
        return new ArrayList<>(Arrays.asList(array));
    }

    public static void main(String[] args) {
        List<String> strings = toList(new String[]{"one", "two", "three"});
        List<Integer> numbers = toList(new Integer[]{1, 2, 3});

        System.out.println(strings);
        System.out.println(numbers);
    }
}
