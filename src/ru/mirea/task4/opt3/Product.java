package ru.mirea.task4.opt3;

public class Product {
    private final int id;
    private final String name;
    private final Category category;
    private final double price;

    public Product(int id, String name, Category category, double price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public Category getCategory() { return category; }
    public double getPrice() { return price; }

    @Override
    public String toString() {
        return String.format("[%d] %s — %.2f руб. (%s)", id, name, price, category.getTitle());
    }
}
