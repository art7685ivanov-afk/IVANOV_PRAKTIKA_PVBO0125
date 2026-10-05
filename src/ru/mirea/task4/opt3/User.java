package ru.mirea.task4.opt3;

public class User {
    private final String login;
    private final String password;
    private final Role role;

    public User(String login, String password, Role role) {
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public String getLogin() { return login; }
    public Role getRole() { return role; }

    public boolean checkPassword(String input) {
        return password.equals(input);
    }
}