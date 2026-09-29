package ru.mirea.task1.opt5;
import java.util.Scanner;
public class Factorial {

    public static long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Факториал не определён для отрицательных чисел");
        }

        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Введите целое неотрицательное число: ");
        int n = sc.nextInt();


        long fact = factorial(n);
        System.out.println(n + "! = " + fact);


        System.out.println("\nПроверка метода на нескольких значениях:");
        for (int i = 0; i <= 10; i++) {
            System.out.printf("%2d! = %d%n", i, factorial(i));
        }
        sc.close();
    }
}