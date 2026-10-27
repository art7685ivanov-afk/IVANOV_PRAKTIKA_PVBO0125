package ru.mirea.task13.opt4;

class Shirt {
    String id, name, color, size;

    public Shirt(String s) {
        String[] p = s.split(",");
        id = p[0].trim(); name = p[1].trim(); color = p[2].trim(); size = p[3].trim();
    }

    @Override
    public String toString() {
        return "Shirt{" + "id='" + id + '\'' + ", name='" + name + '\'' + ", color='" + color + '\'' + ", size='" + size + '\'' + '}';
    }
}

public class Task13_4 {
    public static void main(String[] args) {
        String[] shirts = {
                "S001,Black Polo Shirt,Black,XL",
                "S002,Black Polo Shirt,Black,L",
                "S003,Blue Polo Shirt,Blue,XL"
        };

        Shirt[] shirtObjs = new Shirt[shirts.length];
        for (int i = 0; i < shirts.length; i++) {
            shirtObjs[i] = new Shirt(shirts[i]);
            System.out.println(shirtObjs[i]);
        }
    }
}