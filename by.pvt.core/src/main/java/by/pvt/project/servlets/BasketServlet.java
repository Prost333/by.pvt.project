package by.pvt.project.servlets;

import by.pvt.project.config.ApplicationContext;
import by.pvt.project.domain.Basket;
import by.pvt.project.domain.Order;
import by.pvt.project.domain.Status;
import by.pvt.project.domain.User;
import by.pvt.project.repository.BasketRepository;
import by.pvt.project.repository.OrderRepository;
import by.pvt.project.service.BasketService;
import by.pvt.project.service.GoodService;
import by.pvt.project.service.OrderService;
import by.pvt.project.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BasketServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        OrderService orderService = ApplicationContext.getInstance().getOrderService();
        BasketService basketService = ApplicationContext.getInstance().getBasketService();
        UserService userService = ApplicationContext.getApplicationContext().getUserService();
        int userid = userService.findUserByID(Integer.parseInt(req.getParameter("userId"))).getId();


    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        OrderService orderService = ApplicationContext.getInstance().getOrderService();
        BasketService basketService = ApplicationContext.getInstance().getBasketService();
        UserService userService = ApplicationContext.getApplicationContext().getUserService();
        BasketRepository basketRepository = new BasketRepository();
        int userid = userService.findUserByID(Integer.parseInt(req.getParameter("userId"))).getId();
        List<Order> statusOrder = orderService.newStatus(userid, Status.UNFORMED, Status.FORMED);
        try {
            Basket basket = basketService.findBasketById(userid);
            basket.setOrderList(basketService.getIdOrder(orderService.orderListbyStatus(userid, Status.FORMED)));
            basket.setPrice(orderService.sumPrice(userid,Status.FORMED));
            basket.setCount(orderService.sumCount(userid, Status.FORMED));
            basketRepository.serialize(basket);
            req.setAttribute("basket", basket);
            req.setAttribute("price", orderService.sumPrice(userid,Status.FORMED));
        } catch (Exception e) {
            Basket basket1 = basketService.creatBasket(userid,
                    basketService.baketlist().size() + 1,
                    orderService.sumCount(userid, Status.FORMED)
                    , orderService.sumPrice(userid,Status.FORMED),
                    basketService.getIdOrder(orderService.orderListbyStatus(userid, Status.FORMED)));
            req.setAttribute("basket", basket1);
        }

        List<Order> allOrder = orderService.orderListbyStatus(userid,Status.FORMED);
        User user = userService.findUserByID(Integer.parseInt(req.getParameter("userId")));
        req.setAttribute("allorder", allOrder);
        req.setAttribute("orderclient", orderService.orderListbyStatus(userid, Status.FORMED));
        req.setAttribute("user", user);
        req.getRequestDispatcher("/completionBasket").forward(req, resp);

    }
}
