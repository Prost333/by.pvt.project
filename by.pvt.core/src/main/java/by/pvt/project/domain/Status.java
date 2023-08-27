package by.pvt.project.domain;

public enum Status {

    UNFORMED("Не сформирован"),
    FORMED("Сформирован"),
    ON_THE_WAY("В пути"),
    DELIVERED("Доставлен");

    String name;

    Status(String name) {
        this.name = name;
    }
}

