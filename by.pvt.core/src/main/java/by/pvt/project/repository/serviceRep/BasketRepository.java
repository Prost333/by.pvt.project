package by.pvt.project.repository.serviceRep;

import by.pvt.project.domain.Basket;

import java.util.List;

public interface BasketRepository {
    void addBasket(Basket basket);
    void deleteBasket(Basket basket);
    Basket findBasketById(int id);
    List<Basket> getAllBasket();
    void changeOrder(int userid, double price, int count);
}
