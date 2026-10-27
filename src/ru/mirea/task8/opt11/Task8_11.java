package ru.mirea.task8.opt11;

import java.util.Scanner;

public class Task8_11 {
    public static int countOnes(int prev, int current) {
        Scanner sc = new Scanner(System.in);
        if (prev == 0 && current == 0) return 0;
        if (current == 1) return 1 + countOnes(current, sc.nextInt());
        return countOnes(current, sc.nextInt());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите последовательность (завершается 0 0):");
        // Считываем первое число, чтобы запустить рекурсию
        int first = sc.nextInt();
        int second = sc.nextInt();
        System.out.println("Количество единиц: " + countOnes(first, second));
    }
}
