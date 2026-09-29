package ru.mirea.task2.opt5;

public class Dog {
    private String name;   // кличка
    private int age;       // возраст в "собачьих" годах

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHumanAge() {
        return age * 7;
    }

    @Override
    public String toString() {
        return "Dog{кличка='" + name + "', возраст=" + age +
                " лет (по-человечески " + getHumanAge() + " лет)}";
    }
}