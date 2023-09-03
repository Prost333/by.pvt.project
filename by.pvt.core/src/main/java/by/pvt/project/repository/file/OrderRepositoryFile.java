package by.pvt.project.repository.file;

import by.pvt.project.domain.Order;
import by.pvt.project.domain.Status;
import by.pvt.project.repository.FileWorker;

import java.util.ArrayList;
import java.util.List;

public class OrderRepositoryFile extends FileWorker {
    public static List<Order> orderList = new ArrayList<>();
    public static String way = "C:\\Project Java\\by.pvt.project\\by.pvt.core\\src\\main\\java\\by\\pvt\\project\\data\\Order.txt";
    public Order addOrder(Order order) {
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

