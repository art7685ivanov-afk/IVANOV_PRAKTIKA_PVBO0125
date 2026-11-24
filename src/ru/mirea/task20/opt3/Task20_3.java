package ru.mirea.task20.opt3;

import java.io.Serializable;

public class Task20_3 {
    static class Animal implements Serializable {
        private final String name;

        Animal(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    static class Dog extends Animal {
        Dog(String name) {
            super(name);
        }
    }

    static class ThreeParams<T extends Comparable<T>, V extends Animal & Serializable, K> {
        private final T first;
        private final V second;
        private final K third;

        ThreeParams(T first, V second, K third) {
            this.first = first;
            this.second = second;
            this.third = third;
        }

        void printValues() {
            System.out.println(first);
            System.out.println(second);
            System.out.println(third);
        }

        void printClassNames() {
            System.out.println(first.getClass().getName());
            System.out.println(second.getClass().getName());
            System.out.println(third.getClass().getName());
        }
    }

    public static void main(String[] args) {
        ThreeParams<String, Dog, Integer> params =
                new ThreeParams<>("alpha", new Dog("Rex"), 7);

        params.printValues();
        params.printClassNames();
    }
}
