package ru.mirea.task3.opt3;
import java.util.Random;
public class Increasing {
    public static void main(String[] args) {
        Random rand = new Random();
        int[] arr = new int[4];

        for (int i = 0; i < 4; i++) {
            arr[i] = rand.nextInt(90) + 10;
        }

        System.out.print("Массив: ");
        for (int x : arr) {
            System.out.print(x + " ");
        }
        System.out.println();

        boolean increasing = true;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] <= arr[i - 1]) {
                increasing = false;
                break;
            }
        }

        if (increasing) {
            System.out.println("Массив является строго возрастающей последовательностью");
        } else {
            System.out.println("Массив НЕ является строго возрастающей последовательностью");
        }
    }
}