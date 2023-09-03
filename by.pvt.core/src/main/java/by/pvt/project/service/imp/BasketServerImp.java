package by.pvt.project.service.imp;

import by.pvt.project.config.ApplicationContext;
import by.pvt.project.domain.Basket;
import by.pvt.project.domain.Order;
import by.pvt.project.domain.Status;
import by.pvt.project.mapping.BasketMapping;
import by.pvt.project.repository.BD.BasketRepositoryBD;
import by.pvt.project.repository.file.BasketRepositoryFile;
import by.pvt.project.service.BasketService;
import by.pvt.project.service.OrderService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BasketServerImp implements BasketService {
    private BasketRepositoryBD basketRepositoryBD;
    private BasketMapping basketMapping;


    public BasketServerImp(BasketRepositoryBD basketRepositoryBD, BasketMapping basketMapping) {
        this.basketRepositoryBD = basketRepositoryBD;
        this.basketMapping = basketMapping;
    }



    @Override
    public Basket creatBasket(int id, int userId,int orderid, int count, double price) {
        Basket basket1 = new Basket(id, userId,price, orderid, count);
        basketRepositoryBD.addBasket(basket1);

        return basket1;
    }


    @Override
    public List<Basket> baketlist() {
        return basketRepositoryBD.getAllBasket();
    }


    @Override
    public Basket findBasketById(int id) {
       return  basketRepositoryBD.findBasketById(id);

    }
    public void removeBasket(Basket basket) {
        basketRepositoryBD.deleteBasket(basket);
    }

}
