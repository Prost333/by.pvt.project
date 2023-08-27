package by.pvt.project.repository;

import by.pvt.project.domain.Order;
import by.pvt.project.domain.Status;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OrderRepository extends  FileWorker{
    public static List<Order> orderList = new ArrayList<>();
    public static String way = "C:\\Project Java\\by.pvt.project\\by.pvt.core\\src\\main\\java\\by\\pvt\\project\\data\\Order.txt";
    public Order addOrder(Order order) {
        orderList= update();
        orderList.add(order);
        serializeObject(orderList, way);
        saveOrder();
        return order;
    }
    public Order addfinalOrder(Order order) {
        orderList= update();
        orderList.add(order);
        serializeObject(orderList, way);
        saveOrder();
        return order;
    }
    public  List<Order> getAllOrder(){
        orderList= (List<Order>) deserializeObject(way);
        return orderList;
    }
    public void deleteAllOrder(List<Order>order) {
        orderList = update();
        orderList.removeAll(order);
//        saveOrder();
    }
    public List<Order> delitOrderbyStatus(int userid, Status oldstatus) {
        orderList=((List<Order>) deserializeObject(way));
        for (Order order:orderList) {
            if (order.getUserId()==userid&&order.getStatus().equals(oldstatus)){

            orderList.remove(order);
            serializeObject(orderList,way);
        }}
        return orderList;
    }
    public void serialaiz(Order order){
        serializeObject(order,way);
    }


    public void deleteOrder(Order order) {

        orderList.remove(order);
        serializeObject(orderList,way);

    }

    public List<Order> showAllOrder() {
        orderList= (List<Order>) deserializeObject(way);

        return orderList;
    }


    public void saveOrder() {
        serializeObject(orderList, way);
        update();

    }

    public List<Order> update() {
        Object object = deserializeObject(way);
        List<Order> orders = new ArrayList<>();
        if (object instanceof List<?>) {
            orders = (List<Order>) object;
        }
        return orders;
    }
}

