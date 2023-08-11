package by.pvt.project.servlets;

import by.pvt.project.config.ApplicationContext;
import by.pvt.project.domain.User;
import by.pvt.project.repository.UserRepository;
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
        UserRepository userRepository = ApplicationContext.getInstance().getUserRepository();
        pw.println(userRepository.showAllUsers());
        pw.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserServerImp userServerImp = (UserServerImp) ApplicationContext.getInstance().getUserService();
        try {
        User user = userServerImp.cheakPassword(req.getParameter("Login"), req.getParameter("Password"));
        PrintWriter pw =resp.getWriter();
        pw.print("Welcome "+user.getName()+" "+user.getSurname());

        } catch (Throwable e) {
            req.getRequestDispatcher("/loginFailed.jsp").forward(req, resp);
        }


    }
}
