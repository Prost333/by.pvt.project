package by.pvt.project.servlets;

import by.pvt.project.config.ApplicationContext;
import by.pvt.project.domain.Role;
import by.pvt.project.domain.User;
import by.pvt.project.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class UserRegistration extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = ApplicationContext.getInstance().getUserService();
        try {
            User user = userService.cheakPassword(req.getParameter("Login"), req.getParameter("Password"));
            HttpSession httpSession = req.getSession(true);
            httpSession.setAttribute("userId", user.getId());
            req.setAttribute("userId", user.getId());

            if (user.getRole().name().equals(Role.ADMIN.name())) {
                httpSession.setAttribute("filter", user);
            }
            if (user.getRole().name().equals(Role.ADMIN.name())) {
                req.getRequestDispatcher("/goodRegistration.jsp").forward(req, resp);
            } else {
                req.getParameter("/goodMenu.jsp");
                req.getRequestDispatcher("/goodMenu.jsp").forward(req, resp);
            }
        } catch (Throwable e) {
            req.getRequestDispatcher("/loginFailed.jsp").forward(req, resp);
        }


    }
}
