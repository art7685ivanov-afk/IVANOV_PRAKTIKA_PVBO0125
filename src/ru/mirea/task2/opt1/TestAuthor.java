package ru.mirea.task2.opt1;

public class TestAuthor {
    public static void main(String[] args) {
        Author author = new Author("Иван Петров", "ivan@mail.ru", 'M');
        System.out.println(author);

        System.out.println("Имя: " + author.getName());
        System.out.println("Email: " + author.getEmail());
        System.out.println("Пол: " + author.getGender());

        author.setEmail("new_email@mail.ru");
        System.out.println("\nПосле изменения email:");
        System.out.println(author);
    }
}