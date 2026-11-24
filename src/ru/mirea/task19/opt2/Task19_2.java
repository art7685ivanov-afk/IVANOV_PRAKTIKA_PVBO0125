package ru.mirea.task19.opt2;

import java.util.Scanner;

public class Task19_2 {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        LabClass labClass = new LabClass();
        boolean running = true;

        while (running) {
            printMenu();
            int choice = readInt("Выберите пункт меню: ");
            switch (choice) {
                case 1 -> addStudent(labClass);
                case 2 -> labClass.printAll();
                case 3 -> {
                    labClass.sortByGpa();
                    System.out.println("Студенты отсортированы по среднему баллу.");
                }
                case 4 -> findStudent(labClass);
                case 0 -> running = false;
                default -> System.out.println("Такого пункта нет.");
            }
        }
        System.out.println("Работа завершена.");
    }

    private static void printMenu() {
        System.out.println();
        System.out.println("=== LabClass ===");
        System.out.println("1. Добавить студента");
        System.out.println("2. Показать всех студентов");
        System.out.println("3. Сортировать по среднему баллу");
        System.out.println("4. Найти студента по ФИО");
        System.out.println("0. Выход");
    }

    private static void addStudent(LabClass labClass) {
        System.out.print("ФИО: ");
        String fullName = SCANNER.nextLine().trim();
        double gpa = readDouble("Средний балл: ");
        labClass.add(new Student(fullName, gpa));
        System.out.println("Студент добавлен.");
    }

    private static void findStudent(LabClass labClass) {
        System.out.print("ФИО для поиска: ");
        String fullName = SCANNER.nextLine().trim();
        try {
            Student student = labClass.findByFullName(fullName);
            System.out.println("Найден: " + student);
        } catch (StudentNotFoundException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = SCANNER.nextLine().trim();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Введите целое число.");
            }
        }
    }

    private static double readDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = SCANNER.nextLine().trim().replace(',', '.');
            try {
                return Double.parseDouble(line);
            } catch (NumberFormatException e) {
                System.out.println("Введите число.");
            }
        }
    }
}
