package ru.mirea.task2.opt4;

import java.util.Scanner;

public class ShopTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Shop shop = new Shop(20);

        // Стартовое наполнение, чтобы было с чем работать
        shop.addComputer(new Computer("Apple",  "MacBook Pro 14", 3.5, 16, 512, 199990));
        shop.addComputer(new Computer("Apple",  "MacBook Air 13", 3.2, 8,  256, 119990));
        shop.addComputer(new Computer("ASUS",   "ROG Zephyrus G14", 4.2, 32, 1024, 189990));
        shop.addComputer(new Computer("Lenovo", "IdeaPad 3", 2.4, 8, 256, 45990));
        shop.addComputer(new Computer("HP",     "Pavilion 15", 2.8, 16, 512, 72990));

        while (true) {
            System.out.println("\n===== МЕНЮ =====");
            System.out.println("1. Показать все компьютеры");
            System.out.println("2. Добавить компьютер (ввод с клавиатуры)");
            System.out.println("3. Удалить компьютер по индексу");
            System.out.println("4. Найти компьютер по параметрам");
            System.out.println("0. Выход");
            System.out.print("Выбор: ");

            int choice = sc.nextInt();
            sc.nextLine(); // съесть перевод строки

            switch (choice) {
                case 1:
                    shop.printAll();
                    break;

                case 2:
                    System.out.print("Производитель: ");
                    String brand = sc.nextLine();
                    System.out.print("Модель: ");
                    String model = sc.nextLine();
                    System.out.print("Частота CPU (ГГц): ");
                    double cpu = sc.nextDouble();
                    System.out.print("RAM (ГБ): ");
                    int ram = sc.nextInt();
                    System.out.print("SSD (ГБ): ");
                    int ssd = sc.nextInt();
                    System.out.print("Цена (руб.): ");
                    double price = sc.nextDouble();
                    sc.nextLine();
                    shop.addComputer(new Computer(brand, model, cpu, ram, ssd, price));
                    System.out.println("Компьютер добавлен.");
                    break;

                case 3:
                    shop.printAll();
                    System.out.print("Индекс для удаления: ");
                    int idx = sc.nextInt();
                    sc.nextLine();
                    if (shop.removeComputer(idx)) {
                        System.out.println("Компьютер удалён.");
                    }
                    break;

                case 4:
                    System.out.println("Введите критерии поиска (0 или пусто — не учитывать):");
                    System.out.print("Производитель: ");
                    String sb = sc.nextLine();
                    System.out.print("Модель (часть названия): ");
                    String sm = sc.nextLine();
                    System.out.print("Минимум RAM (ГБ): ");
                    int sRam = sc.nextInt();
                    System.out.print("Минимум SSD (ГБ): ");
                    int sSsd = sc.nextInt();
                    System.out.print("Максимум цены (руб., 0 — без ограничения): ");
                    double sPrice = sc.nextDouble();
                    sc.nextLine();
                    shop.search(sb, sm, sRam, sSsd, sPrice);
                    break;

                case 0:
                    System.out.println("Выход.");
                    sc.close();
                    return;

                default:
                    System.out.println("Неверный пункт меню.");
            }
        }
    }
}