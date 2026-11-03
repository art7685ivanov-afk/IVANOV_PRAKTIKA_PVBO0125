package ru.mirea.task9.opt2;

import java.util.Comparator;

/**
 * Задание 2. Быстрая сортировка с компаратором.
 * <p>
 * Класс SortingStudentsByGPA реализует интерфейс Comparator и сортирует
 * список студентов по итоговым баллам в порядке убывания с использованием
 * алгоритма быстрой сортировки.
 */
public class Task9_2 {

    static class Student {
        private final String name;
        private final double gpa;

        Student(String name, double gpa) {
            this.name = name;
            this.gpa = gpa;
        }

        String getName() {
            return name;
        }

        double getGpa() {
            return gpa;
        }

        @Override
        public String toString() {
            return name + " (GPA: " + gpa + ")";
        }
    }

    /** Компаратор: по убыванию среднего балла. */
    static class SortingStudentsByGPA implements Comparator<Student> {
        @Override
        public int compare(Student first, Student second) {
            return Double.compare(second.getGpa(), first.getGpa());
        }
    }

    public static void quickSort(Student[] students, int low, int high, Comparator<Student> comparator) {
        if (low < high) {
            int pivotIndex = partition(students, low, high, comparator);
            quickSort(students, low, pivotIndex - 1, comparator);
            quickSort(students, pivotIndex + 1, high, comparator);
        }
    }

    private static int partition(Student[] students, int low, int high, Comparator<Student> comparator) {
        Student pivot = students[high];
        int smallerIndex = low - 1;

        for (int current = low; current < high; current++) {
            if (comparator.compare(students[current], pivot) <= 0) {
                smallerIndex++;
                Student buffer = students[smallerIndex];
                students[smallerIndex] = students[current];
                students[current] = buffer;
            }
        }

        Student buffer = students[smallerIndex + 1];
        students[smallerIndex + 1] = students[high];
        students[high] = buffer;

        return smallerIndex + 1;
    }

    public static void main(String[] args) {
        Student[] students = {
                new Student("Алиса", 4.5),
                new Student("Борис", 3.8),
                new Student("Чарли", 4.9),
                new Student("Дарья", 4.1)
        };

        System.out.println("До сортировки:");
        for (Student student : students) {
            System.out.println("  " + student);
        }

        quickSort(students, 0, students.length - 1, new SortingStudentsByGPA());

        System.out.println("После сортировки по GPA (по убыванию):");
        for (Student student : students) {
            System.out.println("  " + student);
        }
    }
}
