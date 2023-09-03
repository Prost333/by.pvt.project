package by.pvt.project.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class Order implements Serializable {

    private int id;
    private  int userId;
    private int goodid;
    private  double count;
    private  double cost;
    private Status status;

    public Order(int id, int userId, int goodid, double count, double cost, Status status) {
        this.id = id;
        this.userId = userId;
        this.goodid = goodid;
        this.count=count;
        this.cost = cost;
        this.status = status;
    }

    public Order() {
    }

    public double getCount() {
        return count;
    }

    public void setCount(double count) {
        this.count = count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getGoodid() {
        return goodid;
    }

    public void setGoodid(int goodid) {
        this.goodid = goodid;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", userId=" + userId +
                ", goodid=" + goodid +
                ", count=" + count +
                ", cost=" + cost +
                ", status=" + status +
                '}';
    }
}
