package ru.mirea.task8.opt12;

import java.util.Scanner;

public class Task8_12 {
    public static void printOdd() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n == 0) return;
        if (n % 2 != 0) System.out.print(n + " ");
        printOdd();
    }

    public static void main(String[] args) {
        System.out.println("Введите последовательность (0 - конец):");
        printOdd();
    }
}