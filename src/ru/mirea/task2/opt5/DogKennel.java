package ru.mirea.task2.opt5;

public class DogKennel {
    private Dog[] dogs;
    private int count;   // сколько собак реально добавлено

    public DogKennel(int capacity) {
        this.dogs = new Dog[capacity];
        this.count = 0;
    }

    public boolean addDog(Dog dog) {
        if (count >= dogs.length) {
            System.out.println("Питомник переполнен, нельзя добавить собаку.");
            return false;
        }
        dogs[count] = dog;
        count++;
        return true;
    }

    public void printAll() {
        System.out.println("В питомнике " + count + " собак:");
        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + ") " + dogs[i]);
        }
    }

    public int getCount() {
        return count;
    }

    public static void main(String[] args) {
        DogKennel kennel = new DogKennel(10);

        kennel.addDog(new Dog("Рекс", 3));
        kennel.addDog(new Dog("Бобик", 5));
        kennel.addDog(new Dog("Шарик", 1));
        kennel.addDog(new Dog("Лайка", 7));
        kennel.addDog(new Dog("Мухтар", 2));

        kennel.printAll();

        System.out.println("\n--- Проверка аксессоров ---");
        Dog d = new Dog("Тузик", 4);
        System.out.println("До изменения: " + d);
        d.setName("Тузик-старший");
        d.setAge(10);
        System.out.println("После изменения: " + d);
        System.out.println("Кличка через геттер: " + d.getName());
        System.out.println("Возраст через геттер: " + d.getAge());
        System.out.println("Человеческий возраст: " + d.getHumanAge());
    }
}