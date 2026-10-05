package ru.mirea.task4.opt3;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private final List<Product> items = new ArrayList<>();

    public void add(Product p) {
        items.add(p);
        System.out.println("Добавлено в корзину: " + p.getName());
    }

    public void show() {
        if (items.isEmpty()) {
            System.out.println("Корзина пуста.");
            return;
        }
        System.out.println("Содержимое корзины:");
        double sum = 0;
        for (Product p : items) {
            System.out.println("  " + p);
            sum += p.getPrice();
        }
        System.out.printf("Итого: %.2f руб.%n", sum);
    }

    public double checkout() {
        double sum = 0;
        for (Product p : items) sum += p.getPrice();
        items.clear();
        return sum;
    }
}