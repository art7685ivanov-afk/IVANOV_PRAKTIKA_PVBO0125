package ru.mirea.task20.opt5;

public class Task20_5 {
    static class Matrix<T extends Number> {
        private final T[][] data;
        private final int rows;
        private final int columns;

        Matrix(T[][] data) {
            if (data.length == 0) {
                throw new IllegalArgumentException("Матрица не должна быть пустой");
            }
            this.rows = data.length;
            this.columns = data[0].length;
            for (T[] row : data) {
                if (row.length != columns) {
                    throw new IllegalArgumentException("Матрица должна быть прямоугольной");
                }
            }
            this.data = data;
        }

        Matrix<Double> add(Matrix<T> other) {
            checkSameSize(other);
            Double[][] result = new Double[rows][columns];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    result[i][j] = data[i][j].doubleValue() + other.data[i][j].doubleValue();
                }
            }
            return new Matrix<>(result);
        }

        Matrix<Double> subtract(Matrix<T> other) {
            checkSameSize(other);
            Double[][] result = new Double[rows][columns];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    result[i][j] = data[i][j].doubleValue() - other.data[i][j].doubleValue();
                }
            }
            return new Matrix<>(result);
        }

        Matrix<Double> multiply(Matrix<T> other) {
            if (columns != other.rows) {
                throw new IllegalArgumentException("Несовместимые размеры матриц");
            }
            Double[][] result = new Double[rows][other.columns];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < other.columns; j++) {
                    double sum = 0;
                    for (int k = 0; k < columns; k++) {
                        sum += data[i][k].doubleValue() * other.data[k][j].doubleValue();
                    }
                    result[i][j] = sum;
                }
            }
            return new Matrix<>(result);
        }

        void print(String title) {
            System.out.println(title);
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    System.out.printf("%8.2f", data[i][j].doubleValue());
                }
                System.out.println();
            }
        }

        private void checkSameSize(Matrix<T> other) {
            if (rows != other.rows || columns != other.columns) {
                throw new IllegalArgumentException("Размеры матриц должны совпадать");
            }
        }
    }

    public static void main(String[] args) {
        Integer[][] firstData = {{1, 2}, {3, 4}};
        Integer[][] secondData = {{5, 6}, {7, 8}};

        Matrix<Integer> first = new Matrix<>(firstData);
        Matrix<Integer> second = new Matrix<>(secondData);

        first.add(second).print("Сложение:");
        first.subtract(second).print("Вычитание:");
        first.multiply(second).print("Умножение:");
    }
}
