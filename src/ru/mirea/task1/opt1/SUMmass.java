package ru.mirea.task1.opt1;

public class SUMmass {
    public static void main(String[] args) {
        int[] numbers = {5, 12, 8, 23, 4, 17, 9, 30, 11, 6};
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }
        double average = (double) sum / numbers.length;
        System.out.println("Сумма элементов массива: " + sum);
        System.out.println("Среднее арифметическое: " + average);
    }
}