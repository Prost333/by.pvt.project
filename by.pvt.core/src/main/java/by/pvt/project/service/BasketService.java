package by.pvt.project.service;

import by.pvt.project.domain.Basket;
import by.pvt.project.domain.Order;
import by.pvt.project.domain.Status;

import java.util.ArrayList;
import java.util.List;

public interface BasketService {


    Basket creatBasket(int id, int userid,int orderid, int count, double price);
    List<Basket>baketlist();
   Basket findBasketById(int id);
    void removeBasket(Basket basket);


}
