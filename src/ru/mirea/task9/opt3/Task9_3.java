package ru.mirea.task9.opt3;

/**
 * Практическая работа 9, задание 3.
 * Объединение двух списков студентов в один отсортированный список
 * с помощью алгоритма сортировки слиянием.
 */
public class Task9_3 {

    static class Student implements Comparable<Student> {
        private final String name;
        private final double gpa;

        Student(String name, double gpa) {
            this.name = name;
            this.gpa = gpa;
        }

        String getName() {
            return name;
        }

        double getGpa() {
            return gpa;
        }

        @Override
        public int compareTo(Student other) {
            // Сортировка по убыванию итогового балла
            return Double.compare(other.gpa, this.gpa);
        }

        @Override
        public String toString() {
            return name + " (GPA: " + gpa + ")";
        }
    }

    /**
     * Сортировка слиянием.
     */
    public static void mergeSort(Student[] students) {
        if (students.length < 2) {
            return;
        }
        Student[] buffer = new Student[students.length];
        mergeSort(students, buffer, 0, students.length - 1);
    }

    private static void mergeSort(Student[] students, Student[] buffer, int left, int right) {
        if (left >= right) {
            return;
        }
        int middle = left + (right - left) / 2;
        mergeSort(students, buffer, left, middle);
        mergeSort(students, buffer, middle + 1, right);
        merge(students, buffer, left, middle, right);
    }

    private static void merge(Student[] students, Student[] buffer, int left, int middle, int right) {
        for (int i = left; i <= right; i++) {
            buffer[i] = students[i];
        }

        int firstIndex = left;
        int secondIndex = middle + 1;
        int resultIndex = left;

        while (firstIndex <= middle && secondIndex <= right) {
            if (buffer[firstIndex].compareTo(buffer[secondIndex]) <= 0) {
                students[resultIndex++] = buffer[firstIndex++];
            } else {
                students[resultIndex++] = buffer[secondIndex++];
            }
        }
        while (firstIndex <= middle) {
            students[resultIndex++] = buffer[firstIndex++];
        }
        while (secondIndex <= right) {
            students[resultIndex++] = buffer[secondIndex++];
        }
    }

    /**
     * Объединяет два отсортированных списка в один отсортированный список.
     */
    public static Student[] merge(Student[] first, Student[] second) {
        Student[] result = new Student[first.length + second.length];
        int firstIndex = 0;
        int secondIndex = 0;
        int resultIndex = 0;

        while (firstIndex < first.length && secondIndex < second.length) {
            if (first[firstIndex].compareTo(second[secondIndex]) <= 0) {
                result[resultIndex++] = first[firstIndex++];
            } else {
                result[resultIndex++] = second[secondIndex++];
            }
        }
        while (firstIndex < first.length) {
            result[resultIndex++] = first[firstIndex++];
        }
        while (secondIndex < second.length) {
            result[resultIndex++] = second[secondIndex++];
        }
        return result;
    }

    private static void print(String title, Student[] students) {
        System.out.println(title);
        for (Student student : students) {
            System.out.println("  " + student);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Student[] first = {
                new Student("Иванов", 4.2),
                new Student("Петров", 3.9),
                new Student("Сидоров", 4.8)
        };
        Student[] second = {
                new Student("Смирнова", 4.5),
                new Student("Кузнецов", 3.6),
                new Student("Волкова", 4.9)
        };

        print("Первый список до сортировки:", first);
        print("Второй список до сортировки:", second);

        mergeSort(first);
        mergeSort(second);

        print("Первый список после сортировки:", first);
        print("Второй список после сортировки:", second);

        Student[] merged = merge(first, second);
        print("Объединённый отсортированный список:", merged);
    }
}
