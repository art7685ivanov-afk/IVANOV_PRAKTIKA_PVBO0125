package ru.mirea.task4.opt3;

public enum Category {
    ELECTRONICS("Электроника"),
    CLOTHES("Одежда"),
    BOOKS("Книги"),
    FOOD("Продукты");

    private final String title;

    Category(String title) { this.title = title; }

    public String getTitle() { return title; }
}