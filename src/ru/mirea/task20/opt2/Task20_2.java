package ru.mirea.task20.opt2;

public class Task20_2 {
    static class ThreeParams<T, V, K> {
        private final T first;
        private final V second;
        private final K third;

        ThreeParams(T first, V second, K third) {
            this.first = first;
            this.second = second;
            this.third = third;
        }

        T getFirst() {
            return first;
        }

        V getSecond() {
            return second;
        }

        K getThird() {
            return third;
        }

        void printClassNames() {
            System.out.println(first.getClass().getName());
            System.out.println(second.getClass().getName());
            System.out.println(third.getClass().getName());
        }
    }

    public static void main(String[] args) {
        ThreeParams<String, Integer, Double> params =
                new ThreeParams<>("text", 10, 3.14);

        System.out.println(params.getFirst());
        System.out.println(params.getSecond());
        System.out.println(params.getThird());
        params.printClassNames();
    }
}
