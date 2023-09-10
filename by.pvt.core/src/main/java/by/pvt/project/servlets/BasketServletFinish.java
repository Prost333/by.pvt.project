package by.pvt.project.servlets;

import by.pvt.project.config.ApplicationContext;
import by.pvt.project.domain.Basket;
import by.pvt.project.domain.Status;
import by.pvt.project.service.BasketService;
import by.pvt.project.service.OrderService;
import by.pvt.project.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class BasketServletFinish extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            OrderService orderService = ApplicationContext.getInstance().getOrderService();
            UserService userService = ApplicationContext.getApplicationContext().getUserService();
            int userid = userService.findUserByID(Integer.parseInt(req.getParameter("userId"))).getId();
            req.setAttribute("orderclient1", orderService.orderListbyStatus(userid, Status.ON_THE_WAY));
            req.getRequestDispatcher("/completionBasket").forward(req, resp);
        } catch (Throwable e) {
            req.getRequestDispatcher("/loginFailed.jsp").forward(req, resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            OrderService orderService = ApplicationContext.getInstance().getOrderService();
            UserService userService = ApplicationContext.getApplicationContext().getUserService();
            int userid = userService.findUserByID(Integer.parseInt(req.getParameter("userId"))).getId();
            req.setAttribute("orderclientAll", orderService.getOrderbyClient(userid));
            req.getRequestDispatcher("/completionBasket").forward(req, resp);
        } catch (Throwable e) {
            req.getRequestDispatcher("/loginFailed.jsp").forward(req, resp);
        }
    }
}
