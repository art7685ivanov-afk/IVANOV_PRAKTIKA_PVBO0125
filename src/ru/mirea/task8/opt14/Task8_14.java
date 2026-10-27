package ru.mirea.task8.opt14;

public class Task8_14 {
    public static void printDigits(int n) {
        if (n < 10) {
            System.out.print(n + " ");
            return;
        }
        printDigits(n / 10);
        System.out.print(n % 10 + " ");
    }

    public static void main(String[] args) {
        int n = 98765;
        System.out.print("Цифры: ");
        printDigits(n);
    }
}