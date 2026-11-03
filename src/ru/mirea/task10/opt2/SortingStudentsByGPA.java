package ru.mirea.task10.opt2;

import java.util.Comparator;

/**
 * Задание 2. Класс SortingStudentsByGPA.
 * <p>
 * Содержит поле-массив объектов Student с именем iDNumber и методы:
 * setArray(), quicksort(), mergeSort(), outArray(), а также сортировку
 * по другому полю (по фамилии).
 */
public class SortingStudentsByGPA {

    private Student[] iDNumber;

    /** Заполнение массива студентов тестовыми данными (метод setArray). */
    public void setArray() {
        iDNumber = new Student[]{
                new Student("Артём", "Иванов", "ИВТ", 2, "ПВБО-01-25", 4.50),
                new Student("Мария", "Петрова", "ИВТ", 2, "ПВБО-01-25", 4.90),
                new Student("Никита", "Сидоров", "ИБ", 1, "ПБИО-01-25", 3.80),
                new Student("Ольга", "Кузнецова", "ИВТ", 3, "ПВБО-02-24", 4.10),
                new Student("Павел", "Смирнов", "ИБ", 1, "ПБИО-01-25", 4.75)
        };
    }

    public void setArray(Student[] students) {
        this.iDNumber = students;
    }

    /** Быстрая сортировка по среднему баллу (по убыванию). */
    public void quicksort() {
        quicksort(0, iDNumber.length - 1, Student.BY_GPA_DESC);
    }

    /** Быстрая сортировка с произвольным компаратором. */
    public void quicksort(Comparator<Student> comparator) {
        quicksort(0, iDNumber.length - 1, comparator);
    }

    private void quicksort(int low, int high, Comparator<Student> comparator) {
        if (low >= high) {
            return;
        }
        int pivotIndex = partition(low, high, comparator);
        quicksort(low, pivotIndex - 1, comparator);
        quicksort(pivotIndex + 1, high, comparator);
    }

    private int partition(int low, int high, Comparator<Student> comparator) {
        Student pivot = iDNumber[high];
        int smaller = low - 1;

        for (int current = low; current < high; current++) {
            if (comparator.compare(iDNumber[current], pivot) <= 0) {
                smaller++;
                swap(smaller, current);
            }
        }
        swap(smaller + 1, high);
        return smaller + 1;
    }

    private void swap(int first, int second) {
        Student buffer = iDNumber[first];
        iDNumber[first] = iDNumber[second];
        iDNumber[second] = buffer;
    }

    /** Сортировка слиянием по среднему баллу (по убыванию). */
    public void mergeSort() {
        iDNumber = mergeSort(iDNumber, Student.BY_GPA_DESC);
    }

    /** Сортировка слиянием с произвольным компаратором. */
    public void sortByOtherField(Comparator<Student> comparator) {
        iDNumber = mergeSort(iDNumber, comparator);
    }

    private Student[] mergeSort(Student[] array, Comparator<Student> comparator) {
        if (array.length <= 1) {
            return array;
        }

        int middle = array.length / 2;
        Student[] left = new Student[middle];
        Student[] right = new Student[array.length - middle];
        System.arraycopy(array, 0, left, 0, middle);
        System.arraycopy(array, middle, right, 0, array.length - middle);

        left = mergeSort(left, comparator);
        right = mergeSort(right, comparator);

        return merge(left, right, comparator);
    }

    private Student[] merge(Student[] left, Student[] right, Comparator<Student> comparator) {
        Student[] result = new Student[left.length + right.length];
        int leftIndex = 0;
        int rightIndex = 0;
        int resultIndex = 0;

        while (leftIndex < left.length && rightIndex < right.length) {
            if (comparator.compare(left[leftIndex], right[rightIndex]) <= 0) {
                result[resultIndex++] = left[leftIndex++];
            } else {
                result[resultIndex++] = right[rightIndex++];
            }
        }
        while (leftIndex < left.length) {
            result[resultIndex++] = left[leftIndex++];
        }
        while (rightIndex < right.length) {
            result[resultIndex++] = right[rightIndex++];
        }
        return result;
    }

    /** Вывод массива студентов (метод outArray). */
    public void outArray() {
        for (Student student : iDNumber) {
            System.out.println("  " + student);
        }
    }

    public static void main(String[] args) {
        SortingStudentsByGPA sorter = new SortingStudentsByGPA();
        sorter.setArray();

        System.out.println("Исходный массив:");
        sorter.outArray();

        sorter.quicksort();
        System.out.println("\nПосле быстрой сортировки по GPA (по убыванию):");
        sorter.outArray();

        sorter.mergeSort();
        System.out.println("\nПосле сортировки слиянием по GPA (по убыванию):");
        sorter.outArray();

        sorter.sortByOtherField(Student.BY_SURNAME);
        System.out.println("\nСортировка по другому полю (по фамилии):");
        sorter.outArray();
    }
}
