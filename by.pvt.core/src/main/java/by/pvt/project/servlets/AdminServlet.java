package by.pvt.project.servlets;

import by.pvt.project.config.ApplicationContext;
import by.pvt.project.domain.*;
import by.pvt.project.service.BasketService;
import by.pvt.project.service.GoodService;
import by.pvt.project.service.OrderService;
import by.pvt.project.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AdminServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GoodService goodService = ApplicationContext.getInstance().getGoodService();
        OrderService orderService = ApplicationContext.getInstance().getOrderService();
        UserService userService = ApplicationContext.getApplicationContext().getUserService();
        Good good = goodService.findGood(Integer.parseInt(req.getParameter("id")));
        try {
            Order order = orderService.CreatOrder(good, userService.findUserByID(Integer.parseInt(req.getParameter("userId"))).getId());
            order.setCount(Double.parseDouble(req.getParameter("count")));
            order.setCost(good.getPrice() * Double.parseDouble(req.getParameter("count")));
            orderService.addOrder(order);

            req.setAttribute("order", order);
            req.getAttribute("/completionBasket.jsp");
            req.getAttribute("/basket.jsp");
            req.getRequestDispatcher("/basket.jsp").forward(req, resp);
        } catch (Throwable e) {
            req.setAttribute("good", good);
            req.getRequestDispatcher("/basket.jsp").forward(req, resp);
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GoodService goodService = ApplicationContext.getInstance().getGoodService();
        req.setAttribute("Goods", goodService.goodList());
        req.getRequestDispatcher("/goodMenu.jsp").forward(req, resp);


    }
}
