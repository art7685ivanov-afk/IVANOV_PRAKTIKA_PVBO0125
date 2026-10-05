package ru.mirea.task6.opt10;

public class ComputerShop {
    public static void main(String[] args) {
        // Массив компьютеров
        Computer[] computers = {
                new Computer("Lenovo IdeaPad 3", "Intel Core i3-1115G4", 8, 256, 45990.00),
                new Computer("HP Pavilion 15",   "Intel Core i5-1235U", 16, 512, 72990.00),
                new Computer("ASUS ROG Strix",   "AMD Ryzen 7 6800H",  32, 1024, 149990.00),
                new Computer("Apple MacBook Air", "Apple M2",          8, 256, 119990.00),
                new Computer("Acer Aspire 5",    "AMD Ryzen 5 5500U",  16, 512, 58990.00),
        };

        System.out.println("=== Каталог компьютеров ===\n");

        // 1. Вывод через интерфейс Printable
        for (Printable p : computers) {
            p.print();
        }

        // 2. Поиск самого дешёвого и самого дорогого
        Computer cheapest = computers[0];
        Computer mostExpensive = computers[0];

        for (Computer c : computers) {
            if (c.getPrice() < cheapest.getPrice()) cheapest = c;
            if (c.getPrice() > mostExpensive.getPrice()) mostExpensive = c;
        }

        System.out.println("\n=== Статистика ===");
        System.out.println("Самый дешёвый:  " + cheapest.getName()
                + " — " + String.format("%,.2f", cheapest.getPrice()) + " руб.");
        System.out.println("Самый дорогой:  " + mostExpensive.getName()
                + " — " + String.format("%,.2f", mostExpensive.getPrice()) + " руб.");

        // 3. Средняя цена
        double sum = 0;
        for (Priceable p : computers) {
            sum += p.getPrice();
        }
        double avg = sum / computers.length;
        System.out.printf("Средняя цена:   %,.2f руб.%n", avg);
    }
}
