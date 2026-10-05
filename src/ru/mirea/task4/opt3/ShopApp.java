package ru.mirea.task4.opt3;

import java.util.List;
import java.util.Scanner;

public class ShopApp {
    public static void main(String[] args) {
        Shop shop = new Shop();
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Интернет-магазин ===");
        System.out.print("Логин: ");
        String login = sc.nextLine();
        System.out.print("Пароль: ");
        String password = sc.nextLine();

        User user = shop.authenticate(login, password);
        if (user == null) {
            System.out.println("Неверный логин или пароль.");
            return;
        }
        System.out.println("Добро пожаловать, " + user.getLogin() + " (" + user.getRole() + ")");

        Cart cart = new Cart();
        boolean running = true;
        while (running) {
            System.out.println("\n--- Меню ---");
            System.out.println("1. Каталог категорий");
            System.out.println("2. Товары категории");
            System.out.println("3. Добавить товар в корзину");
            System.out.println("4. Показать корзину");
            System.out.println("5. Купить");
            System.out.println("0. Выход");
            System.out.print("Выбор: ");

            String choice = sc.nextLine();
            switch (choice) {
                case "1":
                    List<Category> cats = shop.getCategories();
                    for (int i = 0; i < cats.size(); i++) {
                        System.out.println((i + 1) + ". " + cats.get(i).getTitle());
                    }
                    break;
                case "2":
                    System.out.print("Название категории: ");
                    String catName = sc.nextLine().trim().toUpperCase();
                    try {
                        Category cat = Category.valueOf(catName);
                        for (Product p : shop.getProductsByCategory(cat)) {
                            System.out.println(p);
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println("Неизвестная категория.");
                    }
                    break;
                case "3":
                    System.out.print("ID товара: ");
                    try {
                        int id = Integer.parseInt(sc.nextLine());
                        Product p = shop.findById(id);
                        if (p != null) cart.add(p);
                        else System.out.println("Товар не найден.");
                    } catch (NumberFormatException e) {
                        System.out.println("ID должен быть числом.");
                    }
                    break;
                case "4":
                    cart.show();
                    break;
                case "5":
                    double total = cart.checkout();
                    System.out.printf("Покупка совершена. Сумма: %.2f руб.%n", total);
                    break;
                case "0":
                    running = false;
                    System.out.println("Выход.");
                    break;
                default:
                    System.out.println("Неверный пункт меню.");
            }
        }
        sc.close();
    }
}