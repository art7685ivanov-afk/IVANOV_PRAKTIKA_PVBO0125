package ru.mirea.task4.opt2;

public class AtelierDemo {
    public static void main(String[] args) {
        Clothes[] clothes = {
                new TShirt(Size.S, 1500, "белый"),
                new Pants(Size.M, 3200, "чёрный"),
                new Skirt(Size.XS, 2100, "красный"),
                new Tie(Size.L, 900, "синий"),
                new TShirt(Size.XXS, 800, "детский голубой")
        };

        Atelier atelier = new Atelier();
        atelier.dressWomen(clothes);
        atelier.dressMan(clothes);
    }
}