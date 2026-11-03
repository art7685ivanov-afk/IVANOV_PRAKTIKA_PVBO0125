package ru.mirea.task13.opt2;

/**
 * Задание 2. Класс Person.
 * <p>
 * Функция возвращает «Фамилия И.О.» и корректно работает при отсутствии
 * имени или отчества. Для быстродействия используется StringBuilder
 * с заранее заданной ёмкостью (без лишних промежуточных строк).
 */
public class Person {

    private final String surname;
    private final String name;
    private final String patronymic;

    public Person(String surname, String name, String patronymic) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
    }

    /** Фамилия с инициалами: «Иванов А.С.», «Иванов А.», «Иванов». */
    public String getShortName() {
        StringBuilder result = new StringBuilder(32);
        result.append(surname);

        if (isPresent(name)) {
            result.append(' ').append(Character.toUpperCase(name.charAt(0))).append('.');
        }
        if (isPresent(patronymic)) {
            if (!isPresent(name)) {
                result.append(' ');
            }
            result.append(Character.toUpperCase(patronymic.charAt(0))).append('.');
        }
        return result.toString();
    }

    private static boolean isPresent(String value) {
        return value != null && !value.isBlank();
    }

    @Override
    public String toString() {
        return getShortName();
    }
}
