package ru.mirea.task18.opt3;

import java.util.Scanner;

public class Task18_3 {
    public void exceptionDemo() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        String intString = scanner.next();
        try {
            int i = Integer.parseInt(intString);
            System.out.println(2 / i);
        } catch (Exception e) {
            System.out.println("Перехвачено общее исключение: " + e);
        }
    }

    public static void main(String[] args) {
        new Task18_3().exceptionDemo();
    }
}
