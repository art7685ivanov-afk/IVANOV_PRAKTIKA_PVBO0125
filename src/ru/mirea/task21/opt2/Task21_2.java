package ru.mirea.task21.opt2;

import java.util.Arrays;

public class Task21_2 {
    static class AnyArray<T> {
        private final T[] data;

        AnyArray(T[] data) {
            this.data = data;
        }

        T get(int index) {
            return data[index];
        }

        void set(int index, T value) {
            data[index] = value;
        }

        int size() {
            return data.length;
        }

        void print() {
            System.out.println(Arrays.toString(data));
        }
    }

    public static void main(String[] args) {
        AnyArray<Integer> integers = new AnyArray<>(new Integer[]{1, 2, 3});
        AnyArray<Long> longs = new AnyArray<>(new Long[]{10L, 20L, 30L});
        AnyArray<String> strings = new AnyArray<>(new String[]{"one", "two", "three"});

        integers.print();
        longs.print();
        strings.print();

        integers.set(0, 100);
        integers.print();
    }
}
