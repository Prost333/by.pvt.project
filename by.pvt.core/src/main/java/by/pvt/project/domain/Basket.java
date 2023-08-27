package by.pvt.project.domain;

import java.io.Serializable;
import java.util.List;

public class Basket implements Serializable {
    private  int id;
    private  double price;
    private  int orderid;
    private  int count;
    private List<Long> orderList;

    public Basket(int id, double price, int orderid, int count) {
        this.id = id;
        this.price = price;
        this.orderid = orderid;
        this.count = count;
    }

    public Basket(int id, double price, int orderid, int count, List<Long> orderList) {
        this.id = id;
        this.price = price;
        this.orderid = orderid;
        this.count = count;
        this.orderList = orderList;
    }

    public Basket(int id) {
        this.id = id;
    }

    public List<Long> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Long> orderList) {
        this.orderList = orderList;
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
                ", price=" + price +
                ", Basketid=" + orderid +
                ", count=" + count +
                ", orderList=" + orderList +
                '}';
    }
}
