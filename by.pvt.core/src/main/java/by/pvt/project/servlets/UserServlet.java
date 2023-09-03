package by.pvt.project.servlets;


import by.pvt.project.config.ApplicationContext;
import by.pvt.project.domain.Order;
import by.pvt.project.domain.User;
import by.pvt.project.service.OrderService;
import by.pvt.project.service.imp.UserServerImp;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      OrderService orderService= ApplicationContext.getInstance().getOrderService();
     List<Order> orderlis= orderService.getAllOrder();
      req.getRequestDispatcher("/goodMenu.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserServerImp userServerImp= (UserServerImp) ApplicationContext.getInstance().getUserService();


        User user=ApplicationContext.getInstance().getUserService().createUser(1,
                req.getParameter("Name"),req.getParameter("Surname"),
                req.getParameter("Password"),req.getParameter("Login"));
        userServerImp.addUser(user);
        req.setAttribute("user",user);
        req.getRequestDispatcher("regist.jsp").forward(req,resp);

        userServerImp.showAllUsers();


    }
}
