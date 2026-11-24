package ru.mirea.task18.opt2;

import java.util.Scanner;

public class Task18_2 {
    public void exceptionDemo() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        String intString = scanner.next();
        try {
            int i = Integer.parseInt(intString);
            System.out.println(2 / i);
        } catch (NumberFormatException e) {
            System.out.println("Введено не целое число: " + intString);
        } catch (ArithmeticException e) {
            System.out.println("Деление на ноль");
        }
    }

    public static void main(String[] args) {
        new Task18_2().exceptionDemo();
    }
}
