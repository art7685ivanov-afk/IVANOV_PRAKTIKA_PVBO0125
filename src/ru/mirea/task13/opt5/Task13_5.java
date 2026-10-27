package ru.mirea.task13.opt5;

public class Task13_5 {
    public static void main(String[] args) {
        String phone1 = "+79175655655";
        String phone2 = "89175655655";

        System.out.println("Формат: " + format(phone1));
        System.out.println("Формат: " + format(phone2));
    }

    public static String format(String phone) {
        if (phone.startsWith("8")) {
            phone = "+7" + phone.substring(1);
        }
        String code = phone.substring(0, 2);
        String p1 = phone.substring(2, 5);
        String p2 = phone.substring(5, 8);
        String p3 = phone.substring(8);
        return code + "<" + p1 + "><" + p2 + "><" + p3 + ">";
    }
}