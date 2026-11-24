package ru.mirea.task19.opt2;

import java.util.Arrays;

public class LabClass {
    private final Student[] students = new Student[100];
    private int size;

    public void add(Student student) {
        if (size == students.length) {
            throw new IllegalStateException("Список студентов заполнен");
        }
        students[size++] = student;
    }

    public void sortByGpa() {
        Arrays.sort(students, 0, size);
    }

    public Student findByFullName(String fullName) throws StudentNotFoundException {
        for (int i = 0; i < size; i++) {
            if (students[i].getFullName().equalsIgnoreCase(fullName)) {
                return students[i];
            }
        }
        throw new StudentNotFoundException("Студент не найден: " + fullName);
    }

    public void printAll() {
        if (size == 0) {
            System.out.println("Список студентов пуст.");
            return;
        }
        for (int i = 0; i < size; i++) {
            System.out.println((i + 1) + ". " + students[i]);
        }
    }

    public int size() {
        return size;
    }
}
