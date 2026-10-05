package ru.mirea.task7.opt4;

public class Main {
    public static void main(String[] args) {
        // Правильно: ссылка типа интерфейса на объект класса
        MathCalculable mc1 = new MathFunc();

        System.out.println("2^10 = " + mc1.power(2, 10));
        System.out.println("|3 + 4i| = " + mc1.modulus(3, 4));

        // Длина окружности — метод класса, поэтому нужен приведённый тип
        MathFunc mf = (MathFunc) mc1;
        System.out.println("Длина окружности R=5: " + mf.circleLength(5));

        // Проверка константы из интерфейса
        System.out.println("PI = " + MathCalculable.PI);

        // Ошибка (закомментировано):
        // MathCalculable mc2 = new MathCalculable();  // нельзя создавать интерфейс
    }
}