package ru.mirea.task4.opt2;

public class Tie extends Clothes implements MenClothing {
    public Tie(Size size, double cost, String color) {
        super(size, cost, color);
    }
    @Override
    public void dressMan() {
        System.out.println("Одеваем мужчину: " + this);
    }
}