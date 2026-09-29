package ru.mirea.task2.opt2;

public class TestBall {
    public static void main(String[] args) {
        Ball b1 = new Ball();
        System.out.println("b1 (по умолчанию): " + b1);

        Ball b2 = new Ball(3.5, 4.5);
        System.out.println("b2 (с параметрами): " + b2);

        System.out.println("b2.x = " + b2.getX() + ", b2.y = " + b2.getY());

        b2.setX(10.0);
        b2.setY(20.0);
        System.out.println("b2 после setX/setY: " + b2);

        b2.setXY(1.0, 2.0);
        System.out.println("b2 после setXY: " + b2);

        b2.move(5.0, -3.0);
        System.out.println("b2 после move(5, -3): " + b2);

        b2.move(-2.0, 7.0);
        System.out.println("b2 после move(-2, 7): " + b2);
    }
}