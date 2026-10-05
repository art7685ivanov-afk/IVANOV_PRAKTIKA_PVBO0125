package ru.mirea.task7.opt4;

public interface MathCalculable {
    double PI = 3.14159265358979;   // константа (public static final по умолчанию)

    double power(double base, double exponent);   // возведение в степень
    double modulus(double real, double imag);     // модуль комплексного числа
}