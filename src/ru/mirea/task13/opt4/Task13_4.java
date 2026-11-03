package ru.mirea.task13.opt4;


public class Task13_4 {

    static class Shirt {
        private final String id;
        private final String name;
        private final String color;
        private final String size;

        Shirt(String description) {
            String[] parts = description.split(",");
            this.id = parts[0].trim();
            this.name = parts[1].trim();
            this.color = parts[2].trim();
            this.size = parts[3].trim();
        }

        @Override
        public String toString() {
            return "Идентификатор: " + id + System.lineSeparator()
                    + "  Название: " + name + System.lineSeparator()
                    + "  Цвет: " + color + System.lineSeparator()
                    + "  Размер: " + size;
        }
    }

    public static void main(String[] args) {
        String[] shirts = {
                "S001,Black Polo Shirt,Black,XL",
                "S002,Black Polo Shirt,Black,L",
                "S003,Blue Polo Shirt,Blue,XL",
                "S004,Blue Polo Shirt,Blue,M",
                "S005,Tan Polo Shirt,Tan,XL",
                "S006,Black T-Shirt,Black,XL",
                "S007,White T-Shirt,White,XL",
                "S008,White T-Shirt,White,L",
                "S009,Green T-Shirt,Green,S",
                "S010,Orange T-Shirt,Orange,S",
                "S011,Maroon Polo Shirt,Maroon,S"
        };

        Shirt[] shirtObjects = new Shirt[shirts.length];
        for (int i = 0; i < shirts.length; i++) {
            shirtObjects[i] = new Shirt(shirts[i]);
        }

        for (Shirt shirt : shirtObjects) {
            System.out.println(shirt);
            System.out.println();
        }
    }
}
