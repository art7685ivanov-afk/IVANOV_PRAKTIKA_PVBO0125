package ru.mirea.task18.opt1;

public class Task18_1 {
    public void exceptionDemo() {
        try {
            System.out.println(2 / 0);
        } catch (ArithmeticException e) {
            System.out.println("Attempted division by zero");
        }
    }

    public void doubleDivisionDemo() {
        System.out.println(2.0 / 0.0);
    }

    public static void main(String[] args) {
        Task18_1 demo = new Task18_1();
        demo.exceptionDemo();
        demo.doubleDivisionDemo();
    }
}
