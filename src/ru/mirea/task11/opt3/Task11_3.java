package ru.mirea.task11.opt3;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Демонстрация класса Student с датой рождения: toString() и разные форматы даты.
 */
public class Task11_3 {

    public static void main(String[] args) {
        Calendar calendar = new GregorianCalendar(2005, Calendar.MARCH, 17);
        Student student = new Student("Артём", "Иванов", "ПВБО-01-25", calendar.getTime());

        System.out.println("toString(): " + student);
        System.out.println("Короткий формат:  " + student.getBirthDateFormatted(DateFormat.SHORT));
        System.out.println("Средний формат:   " + student.getBirthDateFormatted(DateFormat.MEDIUM));
        System.out.println("Полный формат:    " + student.getBirthDateFormatted(DateFormat.FULL));
        System.out.println("Свой шаблон:      " + student.getBirthDateFormatted("dd MMMM yyyy"));
    }
}
