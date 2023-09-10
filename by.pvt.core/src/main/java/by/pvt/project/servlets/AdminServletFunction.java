package by.pvt.project.servlets;

import by.pvt.project.config.ApplicationContext;
import by.pvt.project.domain.Order;
import by.pvt.project.service.OrderService;
import by.pvt.project.service.UserService;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

public class AdminServletFunction extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        OrderService orderService= ApplicationContext.getInstance().getOrderService();
        try {

            List<Order>orderList=orderService.getOrderbyClient(Integer.parseInt(req.getParameter("listID")));
            req.setAttribute("orderlistbyClient", orderList);
            req.getRequestDispatcher("/goodRegistration.jsp").forward(req, resp);
        }catch (Throwable e){
            req.getRequestDispatcher("/loginFailed.jsp").forward(req,resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = ApplicationContext.getInstance().getUserService();
        req.setAttribute("allUsers",userService.userlist());
        req.getRequestDispatcher("/goodRegistration.jsp").forward(req,resp);

    }
}
