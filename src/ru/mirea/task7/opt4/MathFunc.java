package ru.mirea.task7.opt4;

public class MathFunc implements MathCalculable {

    @Override
    public double power(double base, double exponent) {
        return Math.pow(base, exponent);
    }

    @Override
    public double modulus(double real, double imag) {
        // |a + bi| = √(a² + b²)
        return Math.sqrt(real * real + imag * imag);
    }

    // Длина окружности: C = 2·π·R, где π берётся из интерфейса
    public double circleLength(double radius) {
        return 2 * PI * radius;
    }
}