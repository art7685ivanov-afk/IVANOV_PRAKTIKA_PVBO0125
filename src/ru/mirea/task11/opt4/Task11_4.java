package ru.mirea.task11.opt4;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Task11_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите Год Месяц Число (через пробел):");
        int y = sc.nextInt();
        int m = sc.nextInt() - 1;
        int d = sc.nextInt();
        System.out.println("Введите Часы Минуты:");
        int h = sc.nextInt();
        int min = sc.nextInt();

        // Calendar
        Calendar cal = new GregorianCalendar(y, m, d, h, min);

        // Date из миллисекунд Calendar
        Date date = cal.getTime();

        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        System.out.println("Сформированная дата: " + sdf.format(date));
    }
}