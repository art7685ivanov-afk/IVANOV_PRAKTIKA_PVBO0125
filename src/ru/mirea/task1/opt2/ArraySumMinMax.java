package ru.mirea.task1.opt2;
import java.util.Scanner;
public class ArraySumMinMax {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите количество элементов массива: ");
        int n = sc.nextInt();
        int[] numbers = new int[n];
        System.out.println("Введите " + n + " целых чисел:");
        for (int i = 0; i < n; i++) {
            System.out.print("numbers[" + i + "] = ");
            numbers[i] = sc.nextInt();
        }
        int sumWhile = 0;
        int i = 0;
        while (i < numbers.length) {
            sumWhile += numbers[i];
            i++;
        }
        System.out.println("\nСумма элементов (while): " + sumWhile);
        int sumDoWhile = 0;
        int j = 0;
        if (numbers.length > 0) {
            do {
                sumDoWhile += numbers[j];
                j++;
            } while (j < numbers.length);
        }
        System.out.println("Сумма элементов (do while): " + sumDoWhile);
        int max = numbers[0];
        int min = numbers[0];
        for (int k = 1; k < numbers.length; k++) {
            if (numbers[k] > max) {
                max = numbers[k];
            }
            if (numbers[k] < min) {
                min = numbers[k];
            }
        }
        System.out.println("Максимальный элемент: " + max);
        System.out.println("Минимальный элемент: " + min);

        sc.close();
    }
}
