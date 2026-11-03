package ru.mirea.task13.opt2;

public class Task13_2 {

    public static void main(String[] args) {
        Person[] people = {
                new Person("Иванов", "Артём", "Сергеевич"),
                new Person("Петрова", "Мария", null),
                new Person("Сидоров", null, "Иванович"),
                new Person("Кузнецов", "", "  ")
        };

        for (Person person : people) {
            System.out.println(person.getShortName());
        }
    }
}
