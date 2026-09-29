package ru.mirea.task2.opt4;

public class Shop {
    private Computer[] computers;
    private int count;

    public Shop(int capacity) {
        this.computers = new Computer[capacity];
        this.count = 0;
    }

    public boolean addComputer(Computer c) {
        if (count >= computers.length) {
            System.out.println("Магазин переполнен, нельзя добавить компьютер.");
            return false;
        }
        computers[count] = c;
        count++;
        return true;
    }

    public boolean removeComputer(int index) {
        if (index < 0 || index >= count) {
            System.out.println("Неверный индекс. Допустимо от 0 до " + (count - 1));
            return false;
        }

        for (int i = index; i < count - 1; i++) {
            computers[i] = computers[i + 1];
        }
        computers[count - 1] = null;
        count--;
        return true;
    }

    public void search(String brand, String model,
                       int minRam, int minSsd, double maxPrice) {
        boolean found = false;
        System.out.println("\n--- Результаты поиска ---");
        for (int i = 0; i < count; i++) {
            Computer c = computers[i];

            if (brand != null && !brand.isEmpty()
                    && !c.getBrand().equalsIgnoreCase(brand)) continue;
            if (model != null && !model.isEmpty()
                    && !c.getModel().toLowerCase().contains(model.toLowerCase())) continue;
            if (minRam > 0 && c.getRamGb() < minRam) continue;
            if (minSsd > 0 && c.getSsdGb() < minSsd) continue;
            if (maxPrice > 0 && c.getPrice() > maxPrice) continue;

            System.out.println("[" + i + "] " + c);
            found = true;
        }
        if (!found) {
            System.out.println("Ничего не найдено по заданным критериям.");
        }
    }

    public void printAll() {
        if (count == 0) {
            System.out.println("Магазин пуст.");
            return;
        }
        System.out.println("\n--- Компьютеры в магазине (" + count + " шт.) ---");
        for (int i = 0; i < count; i++) {
            System.out.println("[" + i + "] " + computers[i]);
        }
    }

    public int getCount() {
        return count;
    }
}