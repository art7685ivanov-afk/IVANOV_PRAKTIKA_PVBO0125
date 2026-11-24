package ru.mirea.task18.opt5;

public class Task18_5 {
    public void getDetails(String key) {
        if (key == null) {
            throw new NullPointerException("null key in getDetails");
        }
        System.out.println("data for " + key);
    }

    public static void main(String[] args) {
        Task18_5 demo = new Task18_5();
        try {
            demo.getDetails(null);
        } catch (NullPointerException e) {
            System.out.println("Исключение: " + e.getMessage());
        }
        demo.getDetails("key");
    }
}
