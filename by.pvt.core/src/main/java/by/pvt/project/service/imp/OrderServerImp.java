package by.pvt.project.service.imp;

import by.pvt.project.domain.Good;
import by.pvt.project.domain.Order;
import by.pvt.project.domain.Status;
import by.pvt.project.repository.BD.OrderRepositoryBD;
import by.pvt.project.service.OrderService;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OrderServerImp  implements OrderService {
    OrderRepositoryBD orderRepositoryBD;

    public OrderServerImp(OrderRepositoryBD orderRepositoryBD) {
        this.orderRepositoryBD = orderRepositoryBD;
    }

    @Override
    public void addOrder(Order order) {
         orderRepositoryBD.addOrder(order);
    }

    @Override
    public Order CreatOrder(Good good, int userId) {
        Order order = new Order(orderRepositoryBD.getAllOrder().size() + 1, userId, good.getId(),
                1, good.getPrice(), Status.UNFORMED);
        return order;
    }

    @Override
    public List<Order> getOrderbyClient(int userId) {
        List<Order> users = orderRepositoryBD.getAllOrder();
        List<Order> order1 = users.stream().filter(order -> order.getUserId() == userId).toList();
        return order1;
    }


    @Override
    public List<Order> getAllOrder() {
        return orderRepositoryBD.getAllOrder();
    }

    @Override
    public void saveOrder() {

    }

    @Override
    public double sumPrice(int userid,Status status) {
        List<Order> orderList = getOrderbyClient(userid).stream().filter
                (order -> order.getStatus().equals(status)).collect(Collectors.toList());
        double sum = 0;
        for (Order order : orderList) {
            sum += order.getCost();
        }
        return sum;
    }

    public int sumCount(int userid, Status status) {
        List<Order> orderList = getOrderbyClient(userid);
        int sum = 0;
        for (Order order : orderList) {
            if (order.getStatus().equals(status)) {
                sum += order.getCount();
            }
        }
        return sum;
    }

    public List<Order> orderListbyStatus(int userid, Status status) {
        List<Order> orderList =orderRepositoryBD.findOrderByIdAndStatus(userid,status);
        return orderList;
    }

    public List<Order> delitOrderbyStatus(int userid, Status oldstatus) {
        List<Order>orderList=orderRepositoryBD.getAllOrder();
        for (Order order:orderList) {
            if (order.getStatus().equals(oldstatus)){
                orderRepositoryBD.deleteOrder(order);
            }
        }
        return orderList;
    }
    @Override
    public Order findOrderbyid(int id) {
       return orderRepositoryBD.findOrderById(id);
    }

    public void changeStatus(int userId, String oldStatus, String newStatus){
        orderRepositoryBD.changeOrder(userId,oldStatus,newStatus);
    }

    @Override
    public int orderCount(int userId) {
        return orderRepositoryBD.orderCount(userId);
    }

    @Override
    public void deleteOrder(int userid,int orderid) {
      Order order=  orderRepositoryBD.findOrderById(orderid);
      if (order.getUserId()==userid){
        orderRepositoryBD.deleteOrder(order);
      }
    }


}
