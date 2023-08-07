package by.pvt.project.domain;

import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable {
    private int id;
    private  String name;
    private  String surname;
    private  String password;
    private String login;
    private  Role role;

    public User() {
    }

    public User(int id, String name, String surname, String password, String login, Role role) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.login = login;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", password='" + password + '\'' +
                ", login='" + login + '\'' +
                ", role=" + role +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && Objects.equals(name, user.name) && Objects.equals(surname, user.surname) && Objects.equals(password, user.password) && Objects.equals(login, user.login) && role == user.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, password, login, role);
    }
}
