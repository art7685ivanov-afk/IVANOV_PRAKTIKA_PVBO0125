package ru.mirea.task9.opt2;

class Student {
    String name;
    double gpa;
    Student(String name, double gpa) {
        this.name = name;
        this.gpa = gpa;
    }
    @Override
    public String toString() { return name + " (" + gpa + ")"; }
}

public class Task9_2 {
    public static void quickSort(Student[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(Student[] arr, int low, int high) {
        double pivot = arr[high].gpa;
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            // Сортировка по убыванию (если текущий больше опорного)
            if (arr[j].gpa >= pivot) {
                i++;
                Student temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        Student temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    public static void main(String[] args) {
        Student[] students = {
                new Student("Alice", 4.5),
                new Student("Bob", 3.8),
                new Student("Charlie", 4.9)
        };
        quickSort(students, 0, students.length - 1);
        for (Student s : students) System.out.println(s);
    }
}
