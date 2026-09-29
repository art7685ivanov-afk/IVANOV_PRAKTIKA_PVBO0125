package ru.mirea.task2.opt7;

public class Bookshelf {
    private Book[] books;
    private int count;

    public Bookshelf(int capacity) {
        this.books = new Book[capacity];
        this.count = 0;
    }
    public boolean addBook(Book book) {
        if (count >= books.length) {
            System.out.println("Полка переполнена, нельзя добавить книгу.");
            return false;
        }
        books[count] = book;
        count++;
        return true;
    }
    public Book getEarliestBook() {
        if (count == 0) return null;
        Book earliest = books[0];
        for (int i = 1; i < count; i++) {
            if (books[i].getYear() < earliest.getYear()) {
                earliest = books[i];
            }
        }
        return earliest;
    }
    public Book getLatestBook() {
        if (count == 0) return null;
        Book latest = books[0];
        for (int i = 1; i < count; i++) {
            if (books[i].getYear() > latest.getYear()) {
                latest = books[i];
            }
        }
        return latest;
    }
    public void sortByYearAscending() {
        for (int i = 0; i < count - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < count; j++) {
                if (books[j].getYear() < books[minIndex].getYear()) {
                    minIndex = j;
                }
            }
            // Меняем местами books[i] и books[minIndex]
            Book temp = books[i];
            books[i] = books[minIndex];
            books[minIndex] = temp;
        }
    }
    public void printAll() {
        if (count == 0) {
            System.out.println("Полка пуста.");
            return;
        }
        System.out.println("На полке " + count + " книг(и):");
        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + ") " + books[i]);
        }
    }

    public int getCount() {
        return count;
    }
}
