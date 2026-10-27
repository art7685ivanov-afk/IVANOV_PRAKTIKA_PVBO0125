package ru.mirea.task8.opt13;

import java.util.Scanner;

public class Task8_13 {
    public static void printOddIndex(int index) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n == 0) return;
        if (index % 2 != 0) System.out.print(n + " ");
        printOddIndex(index + 1);
    }

    public static void main(String[] args) {
        System.out.println("Введите последовательность (0 - конец):");
        printOddIndex(1);
    }
}