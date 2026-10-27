package ru.mirea.task13.opt3;

import java.util.StringTokenizer;

class Address {
    String country, region, city, street, house, corpus, flat;

    public Address(String str, boolean useSplit) {
        if (useSplit) {
            // Вариант А: split()
            String[] parts = str.split(",");
            country = parts[0].trim();
            region = parts[1].trim();
            city = parts[2].trim();
            street = parts[3].trim();
            house = parts[4].trim();
            corpus = parts[5].trim();
            flat = parts[6].trim();
        } else {
            // Вариант Б: StringTokenizer
            StringTokenizer st = new StringTokenizer(str, ",.;");
            country = st.nextToken().trim();
            region = st.nextToken().trim();
            city = st.nextToken().trim();
            street = st.nextToken().trim();
            house = st.nextToken().trim();
            corpus = st.nextToken().trim();
            flat = st.nextToken().trim();
        }
    }

    @Override
    public String toString() {
        return country + ", " + region + ", " + city + ", " + street + ", " + house + ", " + corpus + ", " + flat;
    }
}

public class Task13_3 {
    public static void main(String[] args) {
        String addrStr = "Россия, Московская обл, Москва, Ленина, 5, 1, 42";
        Address addr1 = new Address(addrStr, true);
        Address addr2 = new Address("Россия; Московская обл; Москва; Ленина; 5; 1; 42", false);

        System.out.println("Через split: " + addr1);
        System.out.println("Через StringTokenizer: " + addr2);
    }
}