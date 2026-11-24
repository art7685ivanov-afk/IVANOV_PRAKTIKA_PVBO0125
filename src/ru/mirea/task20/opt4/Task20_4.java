package ru.mirea.task20.opt4;

public class Task20_4 {
    static class MinMax<T extends Comparable<T>> {
        private final T[] array;

        MinMax(T[] array) {
            if (array.length == 0) {
                throw new IllegalArgumentException("Массив не должен быть пустым");
            }
            this.array = array;
        }

        T min() {
            T result = array[0];
            for (T value : array) {
                if (value.compareTo(result) < 0) {
                    result = value;
                }
            }
            return result;
        }

        T max() {
            T result = array[0];
            for (T value : array) {
                if (value.compareTo(result) > 0) {
                    result = value;
                }
            }
            return result;
        }
    }

    static class Calculator {
        static <T extends Number, U extends Number> double sum(T first, U second) {
            return first.doubleValue() + second.doubleValue();
        }

        static <T extends Number, U extends Number> double multiply(T first, U second) {
            return first.doubleValue() * second.doubleValue();
        }

        static <T extends Number, U extends Number> double divide(T first, U second) {
            if (second.doubleValue() == 0) {
                throw new ArithmeticException("Division by zero");
            }
            return first.doubleValue() / second.doubleValue();
        }

        static <T extends Number, U extends Number> double subtraction(T first, U second) {
            return first.doubleValue() - second.doubleValue();
        }
    }

    public static void main(String[] args) {
        Integer[] numbers = {5, 2, 9, 1, 7};
        MinMax<Integer> minMax = new MinMax<>(numbers);
        System.out.println("Min: " + minMax.min());
        System.out.println("Max: " + minMax.max());

        System.out.println("Sum: " + Calculator.sum(5, 2.5));
        System.out.println("Multiply: " + Calculator.multiply(5, 2.5));
        System.out.println("Divide: " + Calculator.divide(5.0, 2));
        System.out.println("Subtraction: " + Calculator.subtraction(5, 2.5));
    }
}
