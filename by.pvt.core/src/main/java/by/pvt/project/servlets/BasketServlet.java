package by.pvt.project.servlets;

import by.pvt.project.config.ApplicationContext;
import by.pvt.project.domain.Basket;
import by.pvt.project.domain.Order;
import by.pvt.project.domain.Status;
import by.pvt.project.domain.User;
import by.pvt.project.repository.file.BasketRepositoryFile;
import by.pvt.project.service.BasketService;
import by.pvt.project.service.OrderService;
import by.pvt.project.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class BasketServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        OrderService orderService = ApplicationContext.getInstance().getOrderService();
        UserService userService = ApplicationContext.getApplicationContext().getUserService();
        int userid = userService.findUserByID(Integer.parseInt(req.getParameter("userId"))).getId();
            orderService.newStatus(userid,Status.FORMED,Status.ON_THE_WAY);
        req.setAttribute("orderclient", orderService.orderListbyStatus(userid, Status.ON_THE_WAY));
        req.getRequestDispatcher("/completionBasket").forward(req, resp);

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        OrderService orderService = ApplicationContext.getInstance().getOrderService();
        BasketService basketService = ApplicationContext.getInstance().getBasketService();
        UserService userService = ApplicationContext.getApplicationContext().getUserService();
        int userid = userService.findUserByID(Integer.parseInt(req.getParameter("userId"))).getId();
        orderService.newStatus(userid, Status.UNFORMED, Status.FORMED);
        Basket basket=basketService.creatBasket(1,userid,1,orderService.sumCount(userid,Status.FORMED),
                orderService.sumPrice(userid,Status.FORMED));

        req.setAttribute("basket", basket);
        List<Order> allOrder = orderService.orderListbyStatus(userid,Status.FORMED);
        User user = userService.findUserByID(Integer.parseInt(req.getParameter("userId")));
        req.setAttribute("allorder", allOrder);
        req.setAttribute("orderclient", orderService.orderListbyStatus(userid, Status.FORMED));
        req.setAttribute("user", user);
        req.getRequestDispatcher("/completionBasket").forward(req, resp);

    }
}
