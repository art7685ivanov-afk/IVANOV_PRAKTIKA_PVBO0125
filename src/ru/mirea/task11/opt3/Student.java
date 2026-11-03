package ru.mirea.task11.opt3;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


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


    public String getBirthDateFormatted(int style) {
        if (birthDate == null) {
            return "дата рождения не указана";
        }
        return DateFormat.getDateInstance(style, Locale.getDefault()).format(birthDate);
    }


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
