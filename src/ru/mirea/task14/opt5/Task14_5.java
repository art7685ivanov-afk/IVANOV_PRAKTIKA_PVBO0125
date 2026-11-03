package ru.mirea.task14.opt5;

import java.util.regex.Pattern;

/**
 * Задание 5. Дата в формате dd/mm/yyyy (с 1900 по 9999 год).
 * <p>
 * Регулярное выражение учитывает разное количество дней в месяцах
 * и високосные годы (в том числе правило «год, кратный 100, високосный
 * только если кратен 400»).
 */
public class Task14_5 {

    private static final String DAY_31 = "(0[1-9]|[12]\\d|3[01])";
    private static final String DAY_30 = "(0[1-9]|[12]\\d|30)";
    private static final String DAY_FEBRUARY = "(0[1-9]|1\\d|2[0-8])";
    private static final String MONTH_31 = "(0[13578]|1[02])";
    private static final String MONTH_30 = "(0[469]|11)";
    private static final String YEAR = "(19\\d{2}|[2-9]\\d{3})";
    private static final String LEAP_YEAR =
            "((?:19|[2-9]\\d)(?:0[48]|[2468][048]|[13579][26])|(?:[2-9][048]|[13579][26])00)";

    /** Дата записывается как день/месяц/год. */
    private static final String DATE_REGEX =
            "^(?:(?:" + DAY_31 + "/" + MONTH_31
                    + ")|(?:" + DAY_30 + "/" + MONTH_30
                    + ")|(?:" + DAY_FEBRUARY + "/02))/" + YEAR + "$"
                    + "|^29/02/" + LEAP_YEAR + "$";

    public static boolean isDate(String value) {
        return Pattern.matches(DATE_REGEX, value);
    }

    public static void main(String[] args) {
        String[] correct = {"29/02/2000", "30/04/2003", "01/01/2003"};
        String[] incorrect = {"29/02/2001", "30-04-2003", "1/1/1899", "31/04/2003", "29/02/1900"};

        System.out.println("Корректные даты:");
        for (String date : correct) {
            System.out.println("  " + date + " -> " + isDate(date));
        }

        System.out.println("Некорректные даты:");
        for (String date : incorrect) {
            System.out.println("  " + date + " -> " + isDate(date));
        }
    }
}
