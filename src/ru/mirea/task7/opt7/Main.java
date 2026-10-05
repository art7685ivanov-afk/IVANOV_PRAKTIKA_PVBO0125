package ru.mirea.task7.opt7;

public class Main {
    public static void main(String[] args) {
        Printable[] items = {
                new Book("Война и мир", "Л. Н. Толстой", 1863),
                new Magazine("Хакер"),
                new Book("Отцы и дети", "И. Тургенев", 1862),
                new Magazine("Компьютерра"),
                new Magazine("Наука и жизнь"),
                new Book("Преступление и наказание", "Ф. М. Достоевский", 1866)
        };

        // Задание 7: только журналы
        Magazine.printMagazines(items);

        System.out.println();

        // Задание 8: только книги
        Book.printBooks(items);

        System.out.println("\n=== Всё вместе (полиморфизм) ===");
        for (Printable p : items) {
            p.print();   // каждый объект сам решает, как печататься
        }
    }
}