package ru.mirea.task19.opt1;

import java.util.Scanner;

public class Task19_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("ФИО: ");
        String fullName = scanner.nextLine().trim();

        System.out.print("ИНН: ");
        String inn = scanner.nextLine().trim();

        try {
            if (!isValidInn(inn)) {
                throw new InvalidInnException("недействительный ИНН " + inn);
            }
            System.out.println("Заказ оформлен.");
            System.out.println("Клиент: " + fullName);
            System.out.println("ИНН: " + inn);
        } catch (InvalidInnException e) {
            System.out.println("Ошибка оформления заказа: " + e.getMessage());
        }
    }

    private static boolean isValidInn(String inn) {
        if (!inn.matches("\\d{10}|\\d{12}")) {
            return false;
        }

        int[] digits = inn.chars().map(c -> c - '0').toArray();

        if (digits.length == 10) {
            int[] weights = {2, 4, 10, 3, 5, 9, 4, 6, 8};
            return checksum(digits, weights) == digits[9];
        }

        int[] weights11 = {7, 2, 4, 10, 3, 5, 9, 4, 6, 8};
        int[] weights12 = {3, 7, 2, 4, 10, 3, 5, 9, 4, 6, 8};
        return checksum(digits, weights11) == digits[10]
                && checksum(digits, weights12) == digits[11];
    }

    private static int checksum(int[] digits, int[] weights) {
        int sum = 0;
        for (int i = 0; i < weights.length; i++) {
            sum += digits[i] * weights[i];
        }
        return sum % 11 % 10;
    }
}
