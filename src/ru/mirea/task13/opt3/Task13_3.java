package ru.mirea.task13.opt3;

import java.util.StringTokenizer;


public class Task13_3 {

    static class Address {
        private final String country;
        private final String region;
        private final String city;
        private final String street;
        private final String house;
        private final String corpus;
        private final String flat;

        /** Вариант А: разделитель — только запятая, используется split(). */
        public Address(String source) {
            String[] parts = source.split(",", -1);
            country = valueOf(parts, 0);
            region = valueOf(parts, 1);
            city = valueOf(parts, 2);
            street = valueOf(parts, 3);
            house = valueOf(parts, 4);
            corpus = valueOf(parts, 5);
            flat = valueOf(parts, 6);
        }


        public Address(String source, boolean useStringTokenizer) {
            if (!useStringTokenizer) {
                throw new IllegalArgumentException("Ожидается StringTokenizer");
            }
            StringTokenizer tokenizer = new StringTokenizer(source, ",.;");
            country = nextToken(tokenizer);
            region = nextToken(tokenizer);
            city = nextToken(tokenizer);
            street = nextToken(tokenizer);
            house = nextToken(tokenizer);
            corpus = nextToken(tokenizer);
            flat = nextToken(tokenizer);
        }

        private static String valueOf(String[] parts, int index) {
            return index < parts.length ? parts[index].trim() : "";
        }

        private static String nextToken(StringTokenizer tokenizer) {
            return tokenizer.hasMoreTokens() ? tokenizer.nextToken().trim() : "";
        }

        @Override
        public String toString() {
            return "Страна: " + country + ", регион: " + region + ", город: " + city
                    + ", улица: " + street + ", дом: " + house
                    + ", корпус: " + corpus + ", квартира: " + flat;
        }
    }

    public static void main(String[] args) {
        String[] addresses = {
                "Россия, Московская обл, Москва, Ленина, 5, 1, 42",
                "Россия, Ленинградская обл, Санкт-Петербург, Невский пр, 28, 2, 15",
                "Беларусь, Минская обл, Минск, Независимости, 10, 1, 7",
                "Казахстан, Алматинская обл, Алматы, Абая, 150, 3, 101"
        };

        System.out.println("Вариант А (split по запятой):");
        for (String address : addresses) {
            System.out.println("  " + new Address(address));
        }

        System.out.println();
        System.out.println("Вариант Б (StringTokenizer, разделители ',', '.', ';'):");
        String[] tokenized = {
                "Россия; Московская обл; Москва; Ленина; 5; 1; 42",
                "Россия; Ленинградская обл; Санкт-Петербург; Невский пр; 28; 2; 15",
                "Беларусь; Минская обл; Минск; Независимости; 10; 1; 7",
                "Казахстан; Алматинская обл; Алматы; Абая; 150; 3; 101"
        };
        for (String address : tokenized) {
            System.out.println("  " + new Address(address, true));
        }
    }
}
