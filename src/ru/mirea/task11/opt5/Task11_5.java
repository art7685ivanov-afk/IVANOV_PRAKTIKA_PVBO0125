package ru.mirea.task11.opt5;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

/**
 * Задание 5. Сравнение производительности ArrayList и LinkedList.
 * <p>
 * Сравниваются операции добавления в конец, вставки в середину,
 * удаления из начала и поиска по образцу.
 */
public class Task11_5 {

    private static final int ADD_COUNT = 200_000;
    private static final int INSERT_COUNT = 10_000;
    private static final int REMOVE_COUNT = 10_000;

    public static void main(String[] args) {
        System.out.println("Размер для добавления: " + ADD_COUNT
                + ", для вставки/удаления: " + INSERT_COUNT);
        System.out.println();

        compare("Добавление в конец", Task11_5::addToEnd);
        compare("Вставка в середину", Task11_5::insertToMiddle);
        compare("Удаление из начала", Task11_5::removeFromStart);
        compare("Поиск по образцу", Task11_5::searchBySample);
    }

    private static void compare(String operation, Consumer<List<Integer>> action) {
        long arrayListTime = measure(new ArrayList<>(), action);
        long linkedListTime = measure(new LinkedList<>(), action);

        System.out.printf("%-22s ArrayList: %6d мс | LinkedList: %6d мс%n",
                operation, arrayListTime, linkedListTime);
    }

    private static long measure(List<Integer> list, Consumer<List<Integer>> action) {
        long start = System.nanoTime();
        action.accept(list);
        return (System.nanoTime() - start) / 1_000_000;
    }

    private static void addToEnd(List<Integer> list) {
        for (int i = 0; i < ADD_COUNT; i++) {
            list.add(i);
        }
    }

    private static void insertToMiddle(List<Integer> list) {
        for (int i = 0; i < INSERT_COUNT; i++) {
            list.add(list.size() / 2, i);
        }
    }

    private static void removeFromStart(List<Integer> list) {
        for (int i = 0; i < REMOVE_COUNT; i++) {
            list.add(i);
        }
        for (int i = 0; i < REMOVE_COUNT; i++) {
            list.remove(0);
        }
    }

    private static void searchBySample(List<Integer> list) {
        for (int i = 0; i < ADD_COUNT; i++) {
            list.add(i);
        }
        for (int i = 0; i < 20; i++) {
            list.contains(ADD_COUNT - 1);
        }
    }
}
