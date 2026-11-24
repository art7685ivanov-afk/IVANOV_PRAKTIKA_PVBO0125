package ru.mirea.task18.opt7;

import java.util.Scanner;

public class Task18_7 {
    public void getKey() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите ключ: ");
        String key = scanner.nextLine();
        printDetails(key);
    }

    public void printDetails(String key) throws Exception {
        try {
            String message = getDetails(key);
            System.out.println(message);
        } catch (Exception e) {
            throw e;
        }
    }

    private String getDetails(String key) throws Exception {
        if (key.isEmpty()) {
            throw new Exception("Key set to empty string");
        }
        return "data for " + key;
    }

    public static void main(String[] args) {
        Task18_7 demo = new Task18_7();
        try {
            demo.getKey();
        } catch (Exception e) {
            System.out.println("Исключение: " + e.getMessage());
        }
    }
}
