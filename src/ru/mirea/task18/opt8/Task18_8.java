package ru.mirea.task18.opt8;

import java.util.Scanner;

public class Task18_8 {
    public void getKey() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Введите ключ: ");
                String key = scanner.nextLine();
                printDetails(key);
                return;
            } catch (Exception e) {
                System.out.println("Ошибка: " + e.getMessage() + ". Введите ключ ещё раз.");
            }
        }
    }

    public void printDetails(String key) throws Exception {
        System.out.println(getDetails(key));
    }

    private String getDetails(String key) throws Exception {
        if (key.isEmpty()) {
            throw new Exception("Key set to empty string");
        }
        return "data for " + key;
    }

    public static void main(String[] args) {
        new Task18_8().getKey();
    }
}
