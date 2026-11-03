package ru.mirea.task10.opt2;

import java.util.Comparator;


public class Student {


    public static final Comparator<Student> BY_GPA_DESC =
            (first, second) -> Double.compare(second.gpa, first.gpa);


    public static final Comparator<Student> BY_SURNAME =
            Comparator.comparing(student -> student.surname);

    private String name;
    private String surname;
    private String specialty;
    private int course;
    private String group;
    private double gpa;

    public Student(String name, String surname, String specialty, int course, String group, double gpa) {
        this.name = name;
        this.surname = surname;
        this.specialty = specialty;
        this.course = course;
        this.group = group;
        this.gpa = gpa;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getSpecialty() {
        return specialty;
    }

    public int getCourse() {
        return course;
    }

    public String getGroup() {
        return group;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return String.format("%s %s | %s, %d курс, %s | GPA: %.2f",
                surname, name, specialty, course, group, gpa);
    }
}
