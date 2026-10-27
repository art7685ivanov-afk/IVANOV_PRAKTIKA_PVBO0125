package ru.mirea.task14.opt2;

import java.util.regex.Pattern;

public class Task14_2 {
    public static void main(String[] args) {
        String regex = "^abcdefghijklmnopqrstuv18340$";
        Pattern p = Pattern.compile(regex);

        System.out.println("Правильная строка: " + p.matcher("abcdefghijklmnopqrstuv18340").matches());
        System.out.println("Неправильная строка: " + p.matcher("abcdefghijklmnoasdfasdpqrstuv18340").matches());
    }
}