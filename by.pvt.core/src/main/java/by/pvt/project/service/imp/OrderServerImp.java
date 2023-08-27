package by.pvt.project.service.imp;

import by.pvt.project.domain.Good;
import by.pvt.project.domain.Order;
import by.pvt.project.domain.Status;
import by.pvt.project.repository.FileWorker;
import by.pvt.project.repository.OrderRepository;
import by.pvt.project.service.OrderService;
import org.eclipse.tags.shaded.org.apache.xpath.operations.Or;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class OrderServerImp  implements OrderService {
    OrderRepository orderRepository = new OrderRepository();

    public OrderServerImp(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order addOrder(Order order) {
        return orderRepository.addOrder(order);
    }

    @Override
    public Order CreatOrder(Good good, int userId) {
        Order order = new Order(orderRepository.update().size() + 1, userId, good.getId(), 1, good.getPrice(), Status.UNFORMED);
//        orderRepository.addOrder(order);

        return order;
    }

    @Override
    public List<Order> getOrderbyClient(int userId) {
        List<Order> users = orderRepository.update();
        List<Order> order1 = users.stream().filter(order -> order.getUserId() == userId).toList();
        try {
            if (order1.isEmpty()) {
                throw  new RuntimeException();
            } else {
                System.out.println(order1);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return order1;
    }


    @Override
    public List<Order> getAllOrder() {
        return orderRepository.getAllOrder();
    }

    public List<Order> showAllOrder() {
        return orderRepository.showAllOrder();
    }

    @Override
    public List<Order> getOrderByStatus(Status status) {
        List<Order> users = orderRepository.update();
        List<Order> order1 = users.stream().filter(order -> order.getStatus().equals(status)).toList();
        try {
            if (order1.isEmpty()) {
                throw  new RuntimeException();
            } else {
                System.out.println(order1);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return order1;
    }

    public Order findIDOrder(int id) {
        List<Order> users = orderRepository.update();
        Optional<Order> order12 = users.stream().filter(order -> order.getId() == id).findFirst();
        try {
            if (order12.isEmpty()) {
                throw  new RuntimeException();
            } else {
                System.out.println(order12.get());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return order12.get();
    }

    @Override
    public Order changStatus(Order order, Status status) {
        Order order1 = findIDOrder(order.getId());
        order1.setStatus(status);
        orderRepository.saveOrder();
        return order;
    }

    public List<Order> update() {
        return orderRepository.update();
    }

    public void saveOrder() {
        orderRepository.saveOrder();
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
        List<Order> users = orderRepository.update();
        List<Order> orderList = users.stream().filter(order -> order.getUserId() == userid).
                filter(order -> order.getStatus().equals(status)).collect(Collectors.toList());
        try {
            if (orderList.isEmpty()) {
                throw  new RuntimeException();
            } else {
                System.out.println(orderList);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return orderList;
    }

    public List<Order> delitOrderbyStatus(int userid, Status oldstatus) {
        return orderRepository.delitOrderbyStatus(userid,oldstatus);
    }

    @Override
    public Order findOrderbyid(int id) {
        Optional<Order> order = orderRepository.update().stream().filter(order1 -> order1.getId() == id).findFirst();
        saveOrder();
        return order.get();
    }


    public List<Order> newStatus(int userid, Status oldstatus, Status newstatus) {
        List<Order> orderList = new ArrayList<>();
        for (Order order : orderRepository.update()) {
            if (order.getUserId() == userid && order.getStatus().equals(oldstatus)) {
                orderRepository.deleteOrder(order);
                Order order1 = new Order(order.getId(), order.getUserId(), order.getGoodid(), order.getCount(), order.getCost(), newstatus);
                orderRepository.addfinalOrder(order1);
                orderList.add(order1);
            }
        }
        try {
            for (Order order:orderRepository.update()) {
                delitOrderbyStatus(userid,oldstatus);
                saveOrder();
            }
        }catch (Throwable e){

        }
        return orderList;
    }


}
