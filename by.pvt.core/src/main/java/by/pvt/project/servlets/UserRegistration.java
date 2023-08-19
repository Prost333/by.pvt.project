package by.pvt.project.servlets;

import by.pvt.project.config.ApplicationContext;
import by.pvt.project.domain.Role;
import by.pvt.project.domain.User;
import by.pvt.project.repository.UserRepository;
import by.pvt.project.service.UserService;
import by.pvt.project.service.imp.UserServerImp;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class UserRegistration extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter pw = resp.getWriter();
        resp.setContentType("text/html");
        UserService userService=ApplicationContext.getApplicationContext().getUserService();
        pw.println(userService.showAllUsers());
        pw.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       UserService userService = ApplicationContext.getInstance().getUserService();
        PrintWriter pw =resp.getWriter();
        try {
        User user = userService.cheakPassword(req.getParameter("Login"), req.getParameter("Password"));
       if (user.getRole().equals(Role.ADMIN)){
           req.getRequestDispatcher("/goodRegistration.jsp").forward(req,resp);
       }else {
           req.getRequestDispatcher("/goodMenu.jsp").forward(req,resp);
       }
        pw.print("Welcome "+user.getName()+" "+user.getSurname());
        req.setAttribute("user",user);
        req.getAttribute("/goodMenu.jsp");

        } catch (Throwable e) {
            req.getRequestDispatcher("/loginFailed.jsp").forward(req, resp);
        }


    }
}
