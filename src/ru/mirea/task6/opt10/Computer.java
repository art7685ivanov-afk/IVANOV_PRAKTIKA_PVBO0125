package ru.mirea.task6.opt10;

public class Computer implements Nameable, Priceable, Printable {
    private String name;        // модель
    private String cpu;         // процессор
    private int ram;            // ОЗУ, ГБ
    private int ssd;            // SSD, ГБ
    private double price;       // цена, руб.

    public Computer(String name, String cpu, int ram, int ssd, double price) {
        this.name = name;
        this.cpu = cpu;
        this.ram = ram;
        this.ssd = ssd;
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void print() {
        System.out.printf(
                "Компьютер: %-20s | CPU: %-15s | RAM: %2d ГБ | SSD: %3d ГБ | Цена: %,.2f руб.%n",
                name, cpu, ram, ssd, price
        );
    }

    @Override
    public String toString() {
        return "Computer{" +
                "name='" + name + '\'' +
                ", cpu='" + cpu + '\'' +
                ", ram=" + ram +
                ", ssd=" + ssd +
                ", price=" + price +
                '}';
    }
}