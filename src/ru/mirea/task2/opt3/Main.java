package ru.mirea.task2.opt3;

public class Main {
    public static void main(String[] args) {
        Tester tester = new Tester(5);

        tester.addCircle(new Circle(new Point(0, 0), 1.0));
        tester.addCircle(new Circle(new Point(2, 3), 4.5));
        tester.addCircle(new Circle(new Point(-1, -2), 10.0));

        tester.printAll();

        Circle c = new Circle(new Point(5, 5), 2.0);
        System.out.println("\nДо изменения центра: " + c);
        c.setCenter(new Point(100, 200));
        c.setRadius(7.5);
        System.out.println("После изменения центра и радиуса: " + c);
    }
}
