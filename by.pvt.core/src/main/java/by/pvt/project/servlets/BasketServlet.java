package by.pvt.project.servlets;

import by.pvt.project.config.ApplicationContext;
import by.pvt.project.domain.Basket;
import by.pvt.project.domain.Order;
import by.pvt.project.domain.Status;
import by.pvt.project.domain.User;
import by.pvt.project.filter.Authentication;
import by.pvt.project.service.BasketService;
import by.pvt.project.service.OrderService;
import by.pvt.project.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class BasketServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        OrderService orderService = ApplicationContext.getInstance().getOrderService();
        BasketService basketService = ApplicationContext.getInstance().getBasketService();
        UserService userService = ApplicationContext.getApplicationContext().getUserService();
        int userid = userService.findUserByID(Integer.parseInt(req.getParameter("userId"))).getId();
        try {
            orderService.changeStatus(userid, Status.FORMED.name(), Status.ON_THE_WAY.name());
        } catch (Throwable throwable) {
            req.getRequestDispatcher("/loginFailed.jsp").forward(req, resp);
        }
        try {
            Basket basket = basketService.findBasketByuserIdandSum(userid);
            req.setAttribute("basket", basket);
            req.getRequestDispatcher("/completionBasket").forward(req, resp);
        } catch (Throwable e) {
            Basket basket = basketService.creatBasket(1, userid, 0, orderService.sumCount(userid, Status.FORMED),
                    orderService.sumPrice(userid, Status.FORMED));
            req.setAttribute("basket", basket);
            req.getRequestDispatcher("/completionBasket").forward(req, resp);
        }


    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Authentication authentication = new Authentication();
            OrderService orderService = ApplicationContext.getInstance().getOrderService();
            BasketService basketService = ApplicationContext.getInstance().getBasketService();
            UserService userService = ApplicationContext.getApplicationContext().getUserService();
            int userid = userService.findUserByID(Integer.parseInt(req.getParameter("userId"))).getId();
            orderService.changeStatus(userid, Status.UNFORMED.name(), Status.FORMED.name());
            Basket basket = basketService.creatBasket(1, userid, orderService.orderCount(userid), orderService.sumCount(userid, Status.FORMED),
                    orderService.sumPrice(userid, Status.FORMED));

            req.setAttribute("basket", basket);
            List<Order> allOrder = orderService.getAllOrder().stream().filter(order -> order.getStatus().equals(Status.FORMED)).
                    collect(Collectors.toList());
            User user = userService.findUserByID(Integer.parseInt(req.getParameter("userId")));
            req.setAttribute("allorder", allOrder);
            req.setAttribute("orderclient", orderService.orderListbyStatus(userid, Status.FORMED));
            req.setAttribute("user", user);
            req.getRequestDispatcher("/completionBasket").forward(req, resp);
        } catch (Throwable e) {
            req.getRequestDispatcher("/loginFailed.jsp").forward(req, resp);
        }

    }
}
