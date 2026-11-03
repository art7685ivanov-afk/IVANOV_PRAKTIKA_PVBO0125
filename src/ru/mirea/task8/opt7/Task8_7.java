package ru.mirea.task8.opt7;


public class Task8_7 {


    public static void factorize(int n, int divisor) {
        if (n == 1) {
            return;
        }
        if (n % divisor == 0) {
            System.out.print(divisor + " ");
            factorize(n / divisor, divisor);
        } else {
            factorize(n, divisor + 1);
        }
    }

    public static void main(String[] args) {
        int n = 3960;
        System.out.print("Простые множители числа " + n + ": ");
        factorize(n, 2);
        System.out.println();
    }
}
