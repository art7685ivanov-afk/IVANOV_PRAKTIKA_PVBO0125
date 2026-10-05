package ru.mirea.task7.opt7;

public class Magazine implements Printable {
    private String name;

    public Magazine(String name) {
        this.name = name;
    }

    public String getName() { return name; }

    @Override
    public void print() {
        System.out.printf("Журнал '%s'%n", name);
    }

    // Задание 7: печатает только журналы
    public static void printMagazines(Printable[] printable) {
        System.out.println("=== Журналы ===");
        for (Printable p : printable) {
            if (p instanceof Magazine) {
                System.out.println(((Magazine) p).getName());
            }
        }
    }
}