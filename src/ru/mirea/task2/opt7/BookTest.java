package ru.mirea.task2.opt7;

public class BookTest {
    public static void main(String[] args) {
        Bookshelf shelf = new Bookshelf(10);
        shelf.addBook(new Book("Пушкин А.С.", "Евгений Онегин", 1833));
        shelf.addBook(new Book("Толстой Л.Н.", "Война и мир", 1869));
        shelf.addBook(new Book("Достоевский Ф.М.", "Преступление и наказание", 1866));
        shelf.addBook(new Book("Булгаков М.А.", "Мастер и Маргарита", 1967));
        shelf.addBook(new Book("Гоголь Н.В.", "Мёртвые души", 1842));

        System.out.println("--- Исходный порядок ---");
        shelf.printAll();

        System.out.println("\n--- Крайние по году издания ---");
        System.out.println("Самая ранняя: " + shelf.getEarliestBook());
        System.out.println("Самая поздняя: " + shelf.getLatestBook());

        System.out.println("\n--- После сортировки по году (возрастание) ---");
        shelf.sortByYearAscending();
        shelf.printAll();
    }
}