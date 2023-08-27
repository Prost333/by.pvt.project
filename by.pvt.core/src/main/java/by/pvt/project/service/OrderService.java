package by.pvt.project.service;

import by.pvt.project.domain.Good;
import by.pvt.project.domain.Order;
import by.pvt.project.domain.Status;

import java.util.List;

public interface OrderService {
    Order addOrder(Order order);
    Order CreatOrder(Good good, int userId);
    List<Order> getOrderbyClient (int userId);
    List<Order> getAllOrder();
    List<Order> getOrderByStatus(Status status);
    Order changStatus(Order order, Status status);
    List<Order> showAllOrder();
     List<Order> update() ;
    void saveOrder();
    double sumPrice(int userid,Status status);
    int sumCount(int userid, Status status);
    List<Order> orderListbyStatus(int userid, Status status);
    List<Order> newStatus(int userid,Status oldstatus,Status newstatus);
    List<Order> delitOrderbyStatus(int userid, Status oldstatus);
    Order findOrderbyid(int id);
}
