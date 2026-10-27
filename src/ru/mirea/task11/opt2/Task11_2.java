package ru.mirea.task11.opt2;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Task11_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите год, месяц (1-12) и день:");
        int y = sc.nextInt();
        int m = sc.nextInt() - 1; // В Calendar месяцы с 0
        int d = sc.nextInt();

        Calendar userDate = new GregorianCalendar(y, m, d);
        Calendar currentDate = Calendar.getInstance();

        int result = userDate.compareTo(currentDate);
        if (result < 0) {
            System.out.println("Введенная дата уже прошла.");
        } else if (result > 0) {
            System.out.println("Введенная дата в будущем.");
        } else {
            System.out.println("Даты совпадают.");
        }
    }
}