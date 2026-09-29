package ru.mirea.task2.opt4;

public class Computer {
    private String brand;      // производитель, например "Apple"
    private String model;      // модель, например "MacBook Pro 14"
    private double cpuGhz;     // частота процессора
    private int ramGb;         // объём ОЗУ в ГБ
    private int ssdGb;         // объём SSD в ГБ
    private double price;      // цена в рублях

    public Computer(String brand, String model, double cpuGhz,
                    int ramGb, int ssdGb, double price) {
        this.brand = brand;
        this.model = model;
        this.cpuGhz = cpuGhz;
        this.ramGb = ramGb;
        this.ssdGb = ssdGb;
        this.price = price;
    }

    public String getBrand()  { return brand; }
    public String getModel()  { return model; }
    public double getCpuGhz() { return cpuGhz; }
    public int getRamGb()     { return ramGb; }
    public int getSsdGb()     { return ssdGb; }
    public double getPrice()  { return price; }

    public void setPrice(double price) { this.price = price; }

    @Override
    public String toString() {
        return String.format("%-10s %-20s CPU %.1f ГГц, RAM %d ГБ, SSD %d ГБ, %.2f руб.",
                brand, model, cpuGhz, ramGb, ssdGb, price);
    }
}