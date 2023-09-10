package by.pvt.project.domain;

public enum Role {
    ADMIN("Admin"),
    CLIENT("Client");
    String name;

    Role(String name) {
        this.name = name;
    }
}
