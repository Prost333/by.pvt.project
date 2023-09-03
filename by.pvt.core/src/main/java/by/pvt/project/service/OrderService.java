package by.pvt.project.service;

import by.pvt.project.domain.Good;
import by.pvt.project.domain.Order;
import by.pvt.project.domain.Status;

import java.util.List;

public interface OrderService {
    void addOrder(Order order);
    Order CreatOrder(Good good, int userId);
    List<Order> getOrderbyClient (int userId);
    List<Order> getAllOrder();
    void saveOrder();
    double sumPrice(int userid,Status status);
    int sumCount(int userid, Status status);
    List<Order> orderListbyStatus(int userid, Status status);
    void newStatus(int userid,Status oldstatus,Status newstatus);
    List<Order> delitOrderbyStatus(int userid, Status oldstatus);
    Order findOrderbyid(int id);
    void changeStatus(int userId, String oldStatus, String newStatus);
}
