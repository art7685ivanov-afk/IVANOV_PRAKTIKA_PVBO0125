package ru.mirea.task19.opt2;

public class Student implements Comparable<Student> {
    private final String fullName;
    private final double gpa;

    public Student(String fullName, double gpa) {
        this.fullName = fullName;
        this.gpa = gpa;
    }

    public String getFullName() {
        return fullName;
    }

    public double getGpa() {
        return gpa;
    }

    @Override
    public int compareTo(Student other) {
        return Double.compare(other.gpa, this.gpa);
    }

    @Override
    public String toString() {
        return fullName + " (GPA: " + gpa + ")";
    }
}
