package ru.mirea.task11.opt1;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Task11_1 {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        Date now = new Date();
        System.out.println("Разработчик: Иванов А.С.");
        System.out.println("Дата получения: " + sdf.format(now));
        System.out.println("Дата сдачи: " + sdf.format(now));
    }
}