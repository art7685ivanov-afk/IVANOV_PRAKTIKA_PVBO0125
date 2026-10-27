package ru.mirea.task14.opt5;

import java.util.regex.Pattern;

public class Task14_5 {
    public static void main(String[] args) {
        // Регулярка проверяет: день (01-31), месяц (01-12), год (1900-9999)
        String regex = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/(19\\d{2}|[2-9]\\d{3})$";
        Pattern p = Pattern.compile(regex);

        System.out.println("29/02/2000: " + p.matcher("29/02/2000").matches()); // true
        System.out.println("30-04-2003: " + p.matcher("30-04-2003").matches()); // false (дефисы)
        System.out.println("1/1/1899: " + p.matcher("1/1/1899").matches());     // false (формат и год)
    }
}