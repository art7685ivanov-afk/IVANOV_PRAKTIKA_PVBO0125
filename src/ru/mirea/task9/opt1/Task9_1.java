package ru.mirea.task9.opt1;

/**
 * Задание 1. Сортировка вставками.
 * <p>
 * Тестовый класс создаёт массив класса Student, сортирует его по полю
 * iDNumber алгоритмом сортировки вставками и выводит результат.
 */
public class Task9_1 {

    static class Student {
        private final String name;
        private final int iDNumber;

        Student(String name, int iDNumber) {
            this.name = name;
            this.iDNumber = iDNumber;
        }

        int getIDNumber() {
            return iDNumber;
        }

        @Override
        public String toString() {
            return name + " (ID: " + iDNumber + ")";
        }
    }

    /**
     * Сортировка вставками: на каждом шаге очередной элемент вставляется
     * в уже отсортированную часть массива.
     */
    public static void insertionSort(Student[] students) {
        for (int i = 1; i < students.length; i++) {
            Student key = students[i];
            int j = i - 1;
            while (j >= 0 && students[j].getIDNumber() > key.getIDNumber()) {
                students[j + 1] = students[j];
                j--;
            }
            students[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        Student[] iDNumber = {
                new Student("Иванов", 105),
                new Student("Петров", 102),
                new Student("Сидоров", 109),
                new Student("Кузнецов", 101),
                new Student("Смирнов", 104)
        };

        System.out.println("До сортировки:");
        for (Student student : iDNumber) {
            System.out.println("  " + student);
        }

        insertionSort(iDNumber);

        System.out.println("После сортировки по iDNumber:");
        for (Student student : iDNumber) {
            System.out.println("  " + student);
        }
    }
}
