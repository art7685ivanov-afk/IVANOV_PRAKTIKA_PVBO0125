package ru.mirea.task2.opt8;

import java.util.Arrays;
import java.util.Scanner;

public class ReverseStringArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Введите количество строк: ");
        int n = sc.nextInt();
        sc.nextLine(); // съесть перевод строки после nextInt()

        String[] arr = new String[n];

        System.out.println("Введите " + n + " строк:");
        for (int i = 0; i < n; i++) {
            System.out.print("arr[" + i + "] = ");
            arr[i] = sc.nextLine();
        }

        System.out.println("\nИсходный массив: " + Arrays.toString(arr));

        for (int i = 0; i < arr.length / 2; i++) {
            int j = arr.length - 1 - i;
            String temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        System.out.println("Перевёрнутый массив: " + Arrays.toString(arr));

        sc.close();
    }
}