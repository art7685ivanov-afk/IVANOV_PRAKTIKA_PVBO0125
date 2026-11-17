package ru.mirea.task17.opt1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;


public class StudentList {
    private static class Node {
        private final Student data;
        private Node next;

        private Node(Student data) {
            this.data = data;
        }
    }

    private Node head;
    private int size;


    public StudentList() {
        head = null;
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
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }


    public boolean remove(String fullName) {
        if (head == null) {
            return false;
        }
        if (head.data.getFullName().equalsIgnoreCase(fullName)) {
            head = head.next;
            size--;
            return true;
        }
        Node current = head;
        while (current.next != null) {
            if (current.next.data.getFullName().equalsIgnoreCase(fullName)) {
                current.next = current.next.next;
                size--;
                return true;
            }
            current = current.next;
        }
        return false;
    }


    public void printAll() {
        if (isEmpty()) {
            System.out.println("Список пуст.");
            return;
        }
        System.out.printf("%-30s %-12s %3s%n", "ФИО", "Группа", "Возраст");
        System.out.println("-".repeat(47));
        for (Node current = head; current != null; current = current.next) {
            current.data.print();
        }
    }


    public void clear() {
        head = null;
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

                }
            }
        }
    }
}
