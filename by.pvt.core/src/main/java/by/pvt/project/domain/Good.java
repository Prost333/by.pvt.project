package by.pvt.project.domain;

import java.io.Serializable;
import java.util.Objects;

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
        return " id= " + id +
                " имя='" + name + '\'' +
                ", тип='" + type + '\'' +
                ", цена=" + price +
                ", код=" + code ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Good good = (Good) o;
        return id == good.id && Double.compare(good.price, price) == 0 && code == good.code && Objects.equals(name, good.name) && Objects.equals(type, good.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id, type, price, code);
    }
}
