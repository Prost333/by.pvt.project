package by.pvt.project.service.imp;

import by.pvt.project.config.ApplicationContext;
import by.pvt.project.domain.Basket;
import by.pvt.project.domain.Order;
import by.pvt.project.domain.Status;
import by.pvt.project.mapping.BasketMapping;
import by.pvt.project.repository.BasketRepository;
import by.pvt.project.repository.OrderRepository;
import by.pvt.project.service.BasketService;
import by.pvt.project.service.OrderService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BasketServerImp implements BasketService {
    private BasketRepository basketRepository;
    private BasketMapping basketMapping;


    public BasketServerImp(BasketRepository basketRepository, BasketMapping basketMapping) {
        this.basketRepository = basketRepository;
        this.basketMapping = basketMapping;
    }

    @Override
    public Basket compliteOrder(int id) {
//        Optional<Basket> basket = basketRepository.update().stream().filter(order1 -> order1.getId() == id).findFirst();
//        basket.get().setOrderList(orderList);
//        basketRepository.addBasket(basket.get());
//        return basket.get();
        return null;
    }

    @Override
    public Order cancelOrder(Order order) {
        return null;
    }


    @Override
    public Basket creatBasket(int id, int orderid, int count, double price, List<Long> orderList) {
        Basket basket1 = new Basket(id, price, orderid, count, orderList);
        basketRepository.addBasket(basket1);

        return basket1;
    }


    @Override
    public List<Basket> baketlist() {
        return basketRepository.update();
    }

    @Override
    public double sumPrice(int userid) {
        OrderService orderService = ApplicationContext.getInstance().getOrderService();
        List<Order> o1=orderService.orderListbyStatus(userid, Status.FORMED);
        Basket basket = new Basket(userid);
        List<Long> orderList = basket.getOrderList();
        double sum = 0;
        for (Long i : orderList) {
            Order order = orderService.findOrderbyid(Math.toIntExact(i));
            sum += order.getCost();
        }
        return sum;
    }


    @Override
    public Basket findBasketById(int id) {
       Optional<Basket> basket = basketRepository.update().stream().filter(order1 -> order1.getId() == id).findFirst();

       return basket.get();
    }

    public void removeBasket(Basket basket) {
        basketRepository.deleteBasked(basket);
    }

    @Override
    public List<Long> getIdOrder(List<Order> orderList) {
        List<Long> longList = new ArrayList<>();
        for (Order order : orderList) {
            longList.add((long) order.getId());
        }
        return longList;
    }
}
