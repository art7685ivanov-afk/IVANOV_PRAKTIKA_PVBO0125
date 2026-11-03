package ru.mirea.task13.opt5;

public class Task13_5 {

    public static String format(String phone) {
        String digits = phone.replaceAll("\\D", "");

        // Российский формат 8XXXXXXXXXX приводим к коду страны 7
        if (digits.length() == 11 && digits.charAt(0) == '8') {
            digits = "7" + digits.substring(1);
        }

        if (digits.length() < 11) {
            throw new IllegalArgumentException("Некорректный номер: " + phone);
        }

        String countryCode = digits.substring(0, digits.length() - 10);
        String number = digits.substring(digits.length() - 10);

        return "+" + countryCode
                + number.substring(0, 3) + "-"
                + number.substring(3, 6) + "-"
                + number.substring(6);
    }

    public static void main(String[] args) {
        String[] phones = {"+79175655655", "+104289652211", "89175655655"};

        for (String phone : phones) {
            System.out.println(phone + " -> " + format(phone));
        }
    }
}
