package ru.mirea.task17.opt2;

import java.util.Scanner;


public class Student {
    private String fullName;
    private String group;
    private int age;

    public Student() {
        this("", "", 0);
    }

    public Student(String fullName, String group, int age) {
        this.fullName = fullName;
        this.group = group;
        this.age = age;
    }

    public String getFullName() {
        return fullName;
    }

    public String getGroup() {
        return group;
    }

    public int getAge() {
        return age;
    }


    public void readFromConsole(Scanner scanner) {
        System.out.print("ФИО: ");
        fullName = scanner.nextLine().trim();
        System.out.print("Группа: ");
        group = scanner.nextLine().trim();
        System.out.print("Возраст: ");
        age = readAge(scanner);
    }

    private int readAge(Scanner scanner) {
        while (true) {
            String line = scanner.nextLine().trim();
            try {
                int value = Integer.parseInt(line);
                if (value > 0) {
                    return value;
                }
            } catch (NumberFormatException ignored) {
                // ниже выводим подсказку и повторяем ввод
            }
            System.out.print("Введите корректный возраст: ");
        }
    }


    public void print() {
        System.out.printf("%-30s %-12s %3d%n", fullName, group, age);
    }

    @Override
    public String toString() {
        return fullName + " (" + group + ", " + age + " лет)";
    }
}
