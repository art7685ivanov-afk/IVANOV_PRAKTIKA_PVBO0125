package ru.mirea.task17.opt3;

import java.io.IOException;
import java.util.Scanner;

public class Task17_3 {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String FILE_NAME = "students_circular.txt";

    public static void main(String[] args) {
        CircularStudentList list = new CircularStudentList();
        boolean running = true;

        while (running) {
            printMenu();
            int choice = readInt("Выберите пункт меню: ");
            switch (choice) {
                case 1 -> addStudent(list);
                case 2 -> removeStudent(list);
                case 3 -> list.printAll();
                case 4 -> {
                    list.clear();
                    System.out.println("Список очищен.");
                }
                case 5 -> System.out.println(list.isEmpty()
                        ? "Список пуст."
                        : "В списке " + list.size() + " элемент(ов).");
                case 6 -> save(list);
                case 7 -> load(list);
                case 0 -> running = false;
                default -> System.out.println("Такого пункта нет.");
            }
        }
        System.out.println("Работа завершена.");
    }

    private static void printMenu() {
        System.out.println();
        System.out.println("=== Картотека студентов (кольцевой список) ===");
        System.out.println("1. Добавить студента");
        System.out.println("2. Удалить студента по ФИО");
        System.out.println("3. Показать всех студентов");
        System.out.println("4. Очистить список");
        System.out.println("5. Проверить список на пустоту");
        System.out.println("6. Сохранить список в файл");
        System.out.println("7. Загрузить список из файла");
        System.out.println("0. Выход");
    }

    private static void addStudent(CircularStudentList list) {
        Student student = new Student();
        student.readFromConsole(SCANNER);
        list.add(student);
        System.out.println("Студент добавлен.");
    }

    private static void removeStudent(CircularStudentList list) {
        System.out.print("Введите ФИО студента для удаления: ");
        String fullName = SCANNER.nextLine().trim();
        if (list.remove(fullName)) {
            System.out.println("Студент удалён.");
        } else {
            System.out.println("Студент с таким ФИО не найден.");
        }
    }

    private static void save(CircularStudentList list) {
        try {
            list.saveToFile(FILE_NAME);
            System.out.println("Список сохранён в файл " + FILE_NAME + ".");
        } catch (IOException e) {
            System.out.println("Не удалось сохранить файл: " + e.getMessage());
        }
    }

    private static void load(CircularStudentList list) {
        try {
            list.loadFromFile(FILE_NAME);
            System.out.println("Список загружен из файла " + FILE_NAME + ".");
        } catch (IOException e) {
            System.out.println("Не удалось прочитать файл: " + e.getMessage());
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
}
