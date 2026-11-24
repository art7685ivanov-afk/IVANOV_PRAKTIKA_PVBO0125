package ru.mirea.task21.opt5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Task21_5 {
    @SafeVarargs
    public static <T> ArrayList<T> newArrayList(T... elements) {
        return new ArrayList<>(Arrays.asList(elements));
    }

    @SafeVarargs
    public static <T> HashSet<T> newHashSet(T... elements) {
        return new HashSet<>(Arrays.asList(elements));
    }

    public static <K, V> HashMap<K, V> newHashMap(K key, V value) {
        HashMap<K, V> map = new HashMap<>();
        map.put(key, value);
        return map;
    }

    public static void main(String[] args) {
        ArrayList<String> list = newArrayList("one", "two", "three");
        HashSet<Integer> set = newHashSet(1, 2, 3, 2, 1);
        HashMap<String, Integer> map = newHashMap("key", 42);

        System.out.println(list);
        System.out.println(set);
        System.out.println(map);
    }
}
