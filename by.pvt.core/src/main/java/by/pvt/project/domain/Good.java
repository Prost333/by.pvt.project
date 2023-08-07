package by.pvt.project.domain;

import java.io.Serializable;

public class Good implements Serializable {
    private  String name;
    private  int id;
    private  String type;
    private double price;
    private  int code;

    public Good(String name, int id, String type, double price, int code) {
        this.name = name;
        this.id = id;
        this.type = type;
        this.price = price;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Good{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", code=" + code +
                '}';
    }
}
