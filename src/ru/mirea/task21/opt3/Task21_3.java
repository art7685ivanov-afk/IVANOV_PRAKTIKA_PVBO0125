package ru.mirea.task21.opt3;

public class Task21_3 {
    public static <T> T getElement(T[] array, int index) {
        if (index < 0 || index >= array.length) {
            throw new IndexOutOfBoundsException(
                    "Index: " + index + ", Size: " + array.length);
        }
        return array[index];
    }

    public static void main(String[] args) {
        String[] strings = {"one", "two", "three"};
        Integer[] numbers = {10, 20, 30};

        System.out.println(getElement(strings, 1));
        System.out.println(getElement(numbers, 2));

        try {
            System.out.println(getElement(strings, 5));
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}
