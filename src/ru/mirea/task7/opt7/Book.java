package ru.mirea.task7.opt7;

public class Book implements Printable {
    private String name;
    private String author;
    private int year;

    public Book(String name, String author, int year) {
        this.name = name;
        this.author = author;
        this.year = year;
    }

    public String getName() { return name; }

    @Override
    public void print() {
        System.out.printf("Книга '%s' (%s, %d)%n", name, author, year);
    }

    // Задание 8: печатает только книги
    public static void printBooks(Printable[] printable) {
        System.out.println("=== Книги ===");
        for (Printable p : printable) {
            if (p instanceof Book) {
                System.out.println(((Book) p).getName());
            }
        }
    }
}