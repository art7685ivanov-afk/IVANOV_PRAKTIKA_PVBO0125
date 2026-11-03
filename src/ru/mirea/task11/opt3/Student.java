package ru.mirea.task11.opt3;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Задание 3. Класс Student с датой рождения.
 * <p>
 * Переопределён toString(), добавлен метод, возвращающий строковое
 * представление даты рождения в заданном формате (короткий, средний, полный
 * или по собственному шаблону SimpleDateFormat).
 */
public class Student {

    private String name;
    private String surname;
    private String group;
    private Date birthDate;

    public Student(String name, String surname, String group, Date birthDate) {
        this.name = name;
        this.surname = surname;
        this.group = group;
        this.birthDate = birthDate;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * Строковое представление даты рождения в стандартном формате.
     *
     * @param style DateFormat.SHORT, DateFormat.MEDIUM, DateFormat.LONG или DateFormat.FULL
     */
    public String getBirthDateFormatted(int style) {
        if (birthDate == null) {
            return "дата рождения не указана";
        }
        return DateFormat.getDateInstance(style, Locale.getDefault()).format(birthDate);
    }

    /** Строковое представление даты рождения по собственному шаблону, например "dd.MM.yyyy". */
    public String getBirthDateFormatted(String pattern) {
        if (birthDate == null) {
            return "дата рождения не указана";
        }
        return new SimpleDateFormat(pattern).format(birthDate);
    }

    @Override
    public String toString() {
        return surname + " " + name + ", группа: " + group
                + ", дата рождения: " + getBirthDateFormatted("dd.MM.yyyy");
    }
}
