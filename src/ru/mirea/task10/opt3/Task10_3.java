package ru.mirea.task10.opt3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Student implements Comparable<Student> {
    String name;
    int id;
    Student(String name, int id) {
        this.name = name; this.id = id;
    }
    @Override
    public int compareTo(Student other) {
        return Integer.compare(this.id, other.id);
    }
    @Override
    public String toString() { return name + " (ID: " + id + ")"; }
}

public class Task10_3 {
    public static void main(String[] args) {
        List<Student> list1 = new ArrayList<>();
        list1.add(new Student("Alice", 3));
        list1.add(new Student("Charlie", 1));
        Collections.sort(list1); // Сортируем первый список

        List<Student> list2 = new ArrayList<>();
        list2.add(new Student("Bob", 4));
        list2.add(new Student("Dave", 2));
        Collections.sort(list2); // Сортируем второй список

        // Слияние двух отсортированных списков
        List<Student> merged = new ArrayList<>();
        int i = 0, j = 0;
        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i).compareTo(list2.get(j)) <= 0) {
                merged.add(list1.get(i++));
            } else {
                merged.add(list2.get(j++));
            }
        }
        while (i < list1.size()) merged.add(list1.get(i++));
        while (j < list2.size()) merged.add(list2.get(j++));

        System.out.println("Объединенный отсортированный список:");
        merged.forEach(System.out::println);
    }
}