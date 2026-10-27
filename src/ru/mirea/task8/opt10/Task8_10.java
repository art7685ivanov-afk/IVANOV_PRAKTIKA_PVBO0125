package ru.mirea.task8.opt10;

public class Task8_10 {
    public static int reverse(int n, int reversed) {
        if (n == 0) return reversed;
        return reverse(n / 10, reversed * 10 + n % 10);
    }

    public static void main(String[] args) {
        int n = 12345;
        System.out.println("Результат: " + reverse(n, 0));
    }
}
