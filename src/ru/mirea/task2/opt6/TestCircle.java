package ru.mirea.task2.opt6;

public class TestCircle {
    public static void main(String[] args) {
        // 1. Создаём несколько окружностей
        Circle c1 = new Circle(5.0, "red");
        Circle c2 = new Circle(5.0, "red");
        Circle c3 = new Circle(3.0, "blue");
        Circle c4 = new Circle(5.0, "green");

        // 2. Выводим информацию о каждой
        System.out.println("c1: " + c1);
        System.out.println("c2: " + c2);
        System.out.println("c3: " + c3);
        System.out.println("c4: " + c4);

        // 3. Проверяем площадь и длину отдельно
        System.out.printf("%nПлощадь c1 = %.4f%n", c1.getArea());
        System.out.printf("Длина c1   = %.4f%n", c1.getLength());

        // 4. Сравнение окружностей
        System.out.println("\n--- Сравнение окружностей ---");
        System.out.println("c1.equals(c2) = " + c1.equals(c2));  // true — одинаковые
        System.out.println("c1.equals(c3) = " + c1.equals(c3));  // false — разный радиус
        System.out.println("c1.equals(c4) = " + c1.equals(c4));  // false — разный цвет

        // 5. Изменение свойств через сеттеры
        System.out.println("\n--- Изменение свойств ---");
        c3.setRadius(5.0);
        c3.setColor("red");
        System.out.println("c3 после изменения: " + c3);
        System.out.println("Теперь c1.equals(c3) = " + c1.equals(c3)); // true
    }
}