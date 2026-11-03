package ru.mirea.task10.opt1;


public class Task10_1 {

    public static void main(String[] args) {
        Student student = new Student("Артём", "Иванов", "Информатика и вычислительная техника", 2, "ПВБО-01-25");

        System.out.println("Создан студент:");
        System.out.println("  " + student);
        System.out.println("  имя: " + student.getName());
        System.out.println("  фамилия: " + student.getSurname());
        System.out.println("  специальность: " + student.getSpecialty());
        System.out.println("  курс: " + student.getCourse());
        System.out.println("  группа: " + student.getGroup());

        student.setCourse(3);
        student.setGroup("ПВБО-02-25");

        System.out.println("После изменения курса и группы через сеттеры:");
        System.out.println("  " + student);
    }
}
