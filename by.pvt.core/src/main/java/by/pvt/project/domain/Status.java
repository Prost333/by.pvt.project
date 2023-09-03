package by.pvt.project.domain;

public enum Status {

    UNFORMED("UNFORMED"),
    FORMED("FORMED"),
    ON_THE_WAY("ON_THE_WAY"),
    DELIVERED("DELIVERED");

    String name;

    Status(String name) {
        this.name = name;
    }
}

