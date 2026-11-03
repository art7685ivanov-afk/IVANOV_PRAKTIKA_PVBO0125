package ru.mirea.task8.opt11;

import java.io.IOException;


public class Task8_11 {


    private static int readInt() {
        try {
            int symbol;
            do {
                symbol = System.in.read();
                if (symbol == -1) {
                    return 0;
                }
            } while (Character.isWhitespace(symbol));

            int sign = 1;
            if (symbol == '-') {
                sign = -1;
                symbol = System.in.read();
            }
            int value = 0;
            while (symbol >= '0' && symbol <= '9') {
                value = value * 10 + (symbol - '0');
                symbol = System.in.read();
            }
            return sign * value;
        } catch (IOException e) {
            throw new IllegalStateException("Ошибка чтения с клавиатуры", e);
        }
    }


    public static int countOnes() {
        int value = readInt();

        if (value == 0) {

            int next = readInt();
            if (next == 0) {
                return 0;
            }

            return (next == 1 ? 1 : 0) + countOnes();
        }

        return (value == 1 ? 1 : 0) + countOnes();
    }

    public static void main(String[] args) {
        System.out.println("Введите последовательность (одно число в строке, конец — два нуля подряд):");
        System.out.println("Количество единиц: " + countOnes());
    }
}
