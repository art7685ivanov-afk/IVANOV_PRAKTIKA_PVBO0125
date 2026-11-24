package ru.mirea.task18.opt6;

public class Task18_6 {
    public void printMessage(String key) {
        try {
            System.out.println(getDetails(key));
        } catch (NullPointerException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    public String getDetails(String key) {
        if (key == null) {
            throw new NullPointerException("null key in getDetails");
        }
        return "data for " + key;
    }

    public static void main(String[] args) {
        Task18_6 demo = new Task18_6();
        demo.printMessage("key");
        demo.printMessage(null);
    }
}
