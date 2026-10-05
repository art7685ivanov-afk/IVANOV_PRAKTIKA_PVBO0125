package ru.mirea.task4.opt1;

public class SeasonDemo {
    public static void main(String[] args) {
        // 1) Любимое время года
        Season favorite = Season.SUMMER;
        System.out.println("Моё любимое время года: " + favorite);
        System.out.println("Средняя температура: " + favorite.getAverageTemperature() + "°C");
        System.out.println("Описание: " + favorite.getDescription());
        System.out.println();

        // 2) Метод со switch
        printSeasonMessage(Season.WINTER);
        printSeasonMessage(Season.SPRING);
        printSeasonMessage(Season.SUMMER);
        printSeasonMessage(Season.AUTUMN);
        System.out.println();

        // 6) Цикл по всем временам года
        for (Season s : Season.values()) {
            System.out.println(s + " — " + s.getDescription());
        }
    }

    // 2) Метод с оператором switch
    public static void printSeasonMessage(Season season) {
        switch (season) {
            case SUMMER:
                System.out.println("Я люблю лето");
                break;
            case WINTER:
                System.out.println("Я люблю зиму");
                break;
            case SPRING:
                System.out.println("Я люблю весну");
                break;
            case AUTUMN:
                System.out.println("Я люблю осень");
                break;
        }
    }
}