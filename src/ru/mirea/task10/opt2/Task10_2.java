package ru.mirea.task10.opt2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Student {
    String name;
    int id;
    double gpa;
    Student(String name, int id, double gpa) {
        this.name = name; this.id = id; this.gpa = gpa;
    }
    @Override
    public String toString() { return name + " | ID: " + id + " | GPA: " + gpa; }
}

class SortingStudentsByGPA implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        return Double.compare(s2.gpa, s1.gpa); // по убыванию
    }
}

public class Task10_2 {
    public static void mergeSort(List<Student> list, Comparator<Student> comp) {
        if (list.size() <= 1) return;
        int mid = list.size() / 2;
        List<Student> left = new ArrayList<>(list.subList(0, mid));
        List<Student> right = new ArrayList<>(list.subList(mid, list.size()));

        mergeSort(left, comp);
        mergeSort(right, comp);

        int i = 0, j = 0, k = 0;
        while (i < left.size() && j < right.size()) {
            if (comp.compare(left.get(i), right.get(j)) <= 0) {
                list.set(k++, left.get(i++));
            } else {
                list.set(k++, right.get(j++));
            }
        }
        while (i < left.size()) list.set(k++, left.get(i++));
        while (j < right.size()) list.set(k++, right.get(j++));
    }

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice", 1, 4.5));
        students.add(new Student("Bob", 2, 3.8));
        students.add(new Student("Charlie", 3, 4.9));

        System.out.println("До сортировки:");
        students.forEach(System.out::println);

        mergeSort(students, new SortingStudentsByGPA());

        System.out.println("\nПосле сортировки по GPA (убывание):");
        students.forEach(System.out::println);
    }
}