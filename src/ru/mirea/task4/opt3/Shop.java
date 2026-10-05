package ru.mirea.task4.opt3;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    private final List<User> users = new ArrayList<>();
    private final List<Product> catalog = new ArrayList<>();

    public Shop() {
        // Пользователи
        users.add(new User("admin", "admin", Role.ADMIN));
        users.add(new User("ivan", "1234", Role.USER));

        // Каталог
        catalog.add(new Product(1, "Ноутбук", Category.ELECTRONICS, 60000));
        catalog.add(new Product(2, "Смартфон", Category.ELECTRONICS, 30000));
        catalog.add(new Product(3, "Футболка", Category.CLOTHES, 1500));
        catalog.add(new Product(4, "Java. Руководство", Category.BOOKS, 2500));
        catalog.add(new Product(5, "Хлеб", Category.FOOD, 50));
    }

    public User authenticate(String login, String password) {
        for (User u : users) {
            if (u.getLogin().equals(login) && u.checkPassword(password)) {
                return u;
            }
        }
        return null;
    }

    public List<Category> getCategories() {
        return List.of(Category.values());
    }

    public List<Product> getProductsByCategory(Category c) {
        List<Product> result = new ArrayList<>();
        for (Product p : catalog) {
            if (p.getCategory() == c) result.add(p);
        }
        return result;
    }

    public Product findById(int id) {
        for (Product p : catalog) {
            if (p.getId() == id) return p;
        }
        return null;
    }
}