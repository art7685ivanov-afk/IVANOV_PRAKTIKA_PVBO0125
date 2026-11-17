package ru.mirea.task17.opt2;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;


public class DoublyStudentList {
    private static class Node {
        private final Student data;
        private Node prev;
        private Node next;

        private Node(Student data) {
            this.data = data;
        }
    }

    private Node head;
    private Node tail;
    private int size;


    public DoublyStudentList() {
        head = null;
        tail = null;
        size = 0;
    }


    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return size;
    }


    public void add(Student student) {
        Node newNode = new Node(student);
        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }


    public boolean remove(String fullName) {
        Node current = head;
        while (current != null) {
            if (current.data.getFullName().equalsIgnoreCase(fullName)) {
                if (current.prev != null) {
                    current.prev.next = current.next;
                } else {
                    head = current.next;
                }
                if (current.next != null) {
                    current.next.prev = current.prev;
                } else {
                    tail = current.prev;
                }
                size--;
                return true;
            }
            current = current.next;
        }
        return false;
    }


    public void printForward() {
        if (isEmpty()) {
            System.out.println("Список пуст.");
            return;
        }
        printHeader();
        for (Node current = head; current != null; current = current.next) {
            current.data.print();
        }
    }


    public void printBackward() {
        if (isEmpty()) {
            System.out.println("Список пуст.");
            return;
        }
        printHeader();
        for (Node current = tail; current != null; current = current.prev) {
            current.data.print();
        }
    }

    private void printHeader() {
        System.out.printf("%-30s %-12s %3s%n", "ФИО", "Группа", "Возраст");
        System.out.println("-".repeat(47));
    }


    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }


    public void saveToFile(String fileName) throws IOException {
        try (PrintWriter writer = new PrintWriter(new OutputStreamWriter(
                new FileOutputStream(fileName), StandardCharsets.UTF_8))) {
            for (Node current = head; current != null; current = current.next) {
                Student student = current.data;
                writer.println(student.getFullName() + ";" + student.getGroup() + ";" + student.getAge());
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
