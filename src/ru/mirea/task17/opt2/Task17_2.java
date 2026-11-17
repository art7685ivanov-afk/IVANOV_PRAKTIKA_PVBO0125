package ru.mirea.task17.opt2;

import java.io.IOException;
import java.util.Scanner;


public class Task17_2 {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String FILE_NAME = "students_doubly.txt";

    public static void main(String[] args) {
        DoublyStudentList list = new DoublyStudentList();
        boolean running = true;

        while (running) {
            printMenu();
            int choice = readInt("Выберите пункт меню: ");
            switch (choice) {
                case 1 -> addStudent(list);
                case 2 -> removeStudent(list);
                case 3 -> list.printForward();
                case 4 -> list.printBackward();
                case 5 -> {
                    list.clear();
                    System.out.println("Список очищен.");
                }
                case 6 -> System.out.println(list.isEmpty()
                        ? "Список пуст."
                        : "В списке " + list.size() + " элемент(ов).");
                case 7 -> save(list);
                case 8 -> load(list);
                case 0 -> running = false;
                default -> System.out.println("Такого пункта нет.");
            }
        }
        System.out.println("Работа завершена.");
    }

    private static void printMenu() {
        System.out.println();
        System.out.println("=== Картотека студентов (двусвязный список) ===");
        System.out.println("1. Добавить студента");
        System.out.println("2. Удалить студента по ФИО");
        System.out.println("3. Показать студентов (прямой порядок)");
        System.out.println("4. Показать студентов (обратный порядок)");
        System.out.println("5. Очистить список");
        System.out.println("6. Проверить список на пустоту");
        System.out.println("7. Сохранить список в файл");
        System.out.println("8. Загрузить список из файла");
        System.out.println("0. Выход");
    }

    private static void addStudent(DoublyStudentList list) {
        Student student = new Student();
        student.readFromConsole(SCANNER);
        list.add(student);
        System.out.println("Студент добавлен.");
    }

    private static void removeStudent(DoublyStudentList list) {
        System.out.print("Введите ФИО студента для удаления: ");
        String fullName = SCANNER.nextLine().trim();
        if (list.remove(fullName)) {
            System.out.println("Студент удалён.");
        } else {
            System.out.println("Студент с таким ФИО не найден.");
        }
    }

    private static void save(DoublyStudentList list) {
        try {
            list.saveToFile(FILE_NAME);
            System.out.println("Список сохранён в файл " + FILE_NAME + ".");
        } catch (IOException e) {
            System.out.println("Не удалось сохранить файл: " + e.getMessage());
        }
    }

    private static void load(DoublyStudentList list) {
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
