package by.pvt.project.service;

import by.pvt.project.domain.Basket;
import by.pvt.project.domain.Order;
import by.pvt.project.domain.Status;

import java.util.ArrayList;
import java.util.List;

public interface BasketService {
    Basket compliteOrder(int id);
    Order cancelOrder(Order order);
    Basket creatBasket(int id, int orderid, int count, double price,List<Long> orderList);
    List<Basket>baketlist();
    double sumPrice(int userid);
   Basket findBasketById(int id);
    void removeBasket(Basket basket);
    List<Long> getIdOrder(List<Order> orderList);

}
