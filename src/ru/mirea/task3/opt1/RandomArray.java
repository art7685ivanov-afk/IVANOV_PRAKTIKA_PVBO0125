package ru.mirea.task3.opt1;

import java.util.Arrays;
import java.util.Random;

public class RandomArray {
    public static void main(String[] args) {
        int n = 10;

        // ===== Подход 1: Math.random() =====
        System.out.println("=== Подход 1: Math.random() ===");
        double[] arr1 = new double[n];
        for (int i = 0; i < n; i++) {
            arr1[i] = Math.random() * 100; // диапазон [0; 100)
        }
        System.out.println("До сортировки:    " + Arrays.toString(arr1));
        Arrays.sort(arr1);
        System.out.println("После сортировки: " + Arrays.toString(arr1));

        // ===== Подход 2: класс Random =====
        System.out.println("\n=== Подход 2: класс Random ===");
        Random rand = new Random();
        double[] arr2 = new double[n];
        for (int i = 0; i < n; i++) {
            arr2[i] = rand.nextDouble() * 100; // диапазон [0; 100)
        }
        System.out.println("До сортировки:    " + Arrays.toString(arr2));
        Arrays.sort(arr2);
        System.out.println("После сортировки: " + Arrays.toString(arr2));
    }
}