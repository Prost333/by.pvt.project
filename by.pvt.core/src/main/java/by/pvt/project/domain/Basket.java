package by.pvt.project.domain;

import java.io.Serializable;
import java.util.List;

public class Basket implements Serializable {
    private  int id;
    private int userId;
    private  int orderid;
    private  double price;

    private  int count;


    public Basket(int id, int userId,double price, int orderid, int count) {
        this.id = id;
        this.userId=userId;
        this.price = price;
        this.orderid = orderid;
        this.count = count;
    }

    public Basket() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Basket(int id) {
        this.id = id;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Basket{" +
                "id=" + id +
                ", userId=" + userId +
                ", orderid=" + orderid +
                ", price=" + price +
                ", count=" + count +
                '}';
    }
}
