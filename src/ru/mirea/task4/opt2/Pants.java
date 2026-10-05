package ru.mirea.task4.opt2;

public class Pants extends Clothes implements MenClothing, WomenClothing {
    public Pants(Size size, double cost, String color) {
        super(size, cost, color);
    }
    @Override
    public void dressMan() {
        System.out.println("Одеваем мужчину: " + this);
    }
    @Override
    public void dressWomen() {
        System.out.println("Одеваем женщину: " + this);
    }
}
