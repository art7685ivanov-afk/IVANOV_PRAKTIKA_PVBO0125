package ru.mirea.task17.opt3;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;


public class CircularStudentList {
    private static class Node {
        private final Student data;
        private Node next;

        private Node(Student data) {
            this.data = data;
        }
    }

    private Node tail;
    private int size;


    public CircularStudentList() {
        tail = null;
        size = 0;
    }


    public boolean isEmpty() {
        return tail == null;
    }

    public int size() {
        return size;
    }


    public void add(Student student) {
        Node newNode = new Node(student);
        if (tail == null) {
            tail = newNode;
            newNode.next = newNode;
        } else {
            newNode.next = tail.next;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }


    public boolean remove(String fullName) {
        if (tail == null) {
            return false;
        }
        Node previous = tail;
        Node current = tail.next;
        do {
            if (current.data.getFullName().equalsIgnoreCase(fullName)) {
                if (size == 1) {
                    tail = null;
                } else {
                    previous.next = current.next;
                    if (current == tail) {
                        tail = previous;
                    }
                }
                size--;
                return true;
            }
            previous = current;
            current = current.next;
        } while (current != tail.next);
        return false;
    }

    public void printAll() {
        if (tail == null) {
            System.out.println("Список пуст.");
            return;
        }
        System.out.printf("%-30s %-12s %3s%n", "ФИО", "Группа", "Возраст");
        System.out.println("-".repeat(47));
        Node current = tail.next;
        do {
            current.data.print();
            current = current.next;
        } while (current != tail.next);
    }

    public void clear() {
        tail = null;
        size = 0;
    }

    public void saveToFile(String fileName) throws IOException {
        try (PrintWriter writer = new PrintWriter(new OutputStreamWriter(
                new FileOutputStream(fileName), StandardCharsets.UTF_8))) {
            if (tail != null) {
                Node current = tail.next;
                do {
                    Student student = current.data;
                    writer.println(student.getFullName() + ";" + student.getGroup() + ";" + student.getAge());
                    current = current.next;
                } while (current != tail.next);
            }
        }
    }


    public void loadFromFile(String fileName) throws IOException {
        clear();
        try (Scanner fileScanner = new Scanner(new File(fileName), StandardCharsets.UTF_8)) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine().trim();
                if (line.isEmpty()) {
                    continue;
                }
                String[] parts = line.split(";");
                if (parts.length != 3) {
                    continue;
                }
                try {
                    add(new Student(parts[0], parts[1], Integer.parseInt(parts[2])));
                } catch (NumberFormatException ignored) {
                    // некорректная строка файла пропускается
                }
            }
        }
    }
}
