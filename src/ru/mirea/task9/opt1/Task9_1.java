package ru.mirea.task9.opt1;

public class Task9_1 {
    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] idNumbers = {105, 102, 109, 101, 104};
        System.out.println("До сортировки: ");
        for (int i : idNumbers) System.out.print(i + " ");

        insertionSort(idNumbers);

        System.out.println("\nПосле сортировки: ");
        for (int i : idNumbers) System.out.print(i + " ");
    }
}