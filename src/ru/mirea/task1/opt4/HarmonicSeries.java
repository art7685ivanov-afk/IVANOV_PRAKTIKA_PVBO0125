package ru.mirea.task1.opt4;

public class HarmonicSeries {
    public static void main(String[] args) {
        System.out.println("Первые 10 чисел гармонического ряда:");
        System.out.printf("%-5s %-15s %-15s%n", "№", "Дробь", "Значение");
        System.out.println("-------------------------------------");

        for (int i = 1; i <= 10; i++) {
            double value = 1.0 / i;
            System.out.printf("%-5d 1/%-13d %-15.6f%n", i, i, value);
        }
    }
}