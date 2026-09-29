package ru.mirea.task2.opt3;

public class Tester {
    private Circle[] circles;
    private int n;

    public Tester(int size) {
        this.circles = new Circle[size];
        this.n = 0;
    }

    public void addCircle(Circle circle) {
        if (n < circles.length) {
            circles[n] = circle;
            n++;
        } else {
            System.out.println("Массив заполнен, нельзя добавить больше окружностей.");
        }
    }

    public void printAll() {
        System.out.println("Всего окружностей: " + n);
        for (int i = 0; i < n; i++) {
            System.out.println((i + 1) + ") " + circles[i]
                    + ", площадь = " + String.format("%.4f", circles[i].getArea())
                    + ", длина = " + String.format("%.4f", circles[i].getLength()));
        }
    }

    public int getN() {
        return n;
    }
}