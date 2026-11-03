package ru.mirea.task8.opt9;


public class Task8_9 {


    public static long countSequences(int zeros, int ones, boolean previousIsZero) {
        // Базовый случай: нули закончились — оставшиеся единицы образуют единственный вариант
        if (zeros == 0) {
            return 1;
        }
        // Единиц больше нет: вариант возможен, только если нулей остался один
        // и он не окажется рядом с предыдущим нулём
        if (ones == 0) {
            return (zeros == 1 && !previousIsZero) ? 1 : 0;
        }

        // Ставим единицу — ограничение на следующий символ не действует
        long variants = countSequences(zeros, ones - 1, false);
        // Ставим ноль — только если предыдущий символ не ноль
        if (!previousIsZero) {
            variants += countSequences(zeros - 1, ones, true);
        }
        return variants;
    }

    public static void main(String[] args) {
        int a = 2; // нули
        int b = 3; // единицы
        long result = countSequences(a, b, false);
        System.out.println("Последовательностей из " + a + " нулей и " + b
                + " единиц без двух нулей подряд: " + result);
    }
}
