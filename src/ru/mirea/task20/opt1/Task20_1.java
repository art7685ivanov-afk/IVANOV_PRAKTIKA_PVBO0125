package ru.mirea.task20.opt1;

public class Task20_1 {
    static class ThreeParams<T, V, K> {
        private final T first;
        private final V second;
        private final K third;

        ThreeParams(T first, V second, K third) {
            this.first = first;
            this.second = second;
            this.third = third;
        }
    }

    public static void main(String[] args) {
        ThreeParams<String, Integer, Double> params =
                new ThreeParams<>("text", 10, 3.14);

        System.out.println(params.first);
        System.out.println(params.second);
        System.out.println(params.third);
    }
}
