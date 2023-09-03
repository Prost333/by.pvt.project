package by.pvt.project.repository.serviceRep;

import by.pvt.project.domain.Order;
import by.pvt.project.domain.Status;

import java.util.List;

public interface OrderRepository {
    void addOrder(Order order);
    void deleteOrder(Order order);
    void deleteOrderByStatys(int userid, Status oldstatus);
    Order findOrderById(int id);
    List<Order> getAllOrder();
}
