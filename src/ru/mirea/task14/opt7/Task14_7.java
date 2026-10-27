package ru.mirea.task14.opt7;

import java.util.regex.Pattern;

public class Task14_7 {
    public static void main(String[] args) {
        // 8+ символов, хотя бы 1 цифра, 1 строчная, 1 заглавная. Разрешены буквы, цифры и _
        String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])[a-zA-Z0-9_]{8,}$";
        Pattern p = Pattern.compile(regex);

        System.out.println("F032_Password: " + p.matcher("F032_Password").matches()); // true
        System.out.println("TrySpy1: " + p.matcher("TrySpy1").matches());           // true
        System.out.println("smart_pass: " + p.matcher("smart_pass").matches());     // false (нет заглавной)
        System.out.println("A007: " + p.matcher("A007").matches());                 // false (меньше 8 символов)
    }
}