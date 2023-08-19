package by.pvt.project.servlets;


import by.pvt.project.config.ApplicationContext;
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

public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter pw=resp.getWriter();
        resp.setContentType("text/html");
       UserService userService = ApplicationContext.getInstance().getUserService();
        pw.println(userService.showAllUsers().size());
        pw.println(userService.showAllUsers());
        pw.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserServerImp userServerImp= (UserServerImp) ApplicationContext.getInstance().getUserService();
        Enumeration<String> param = req.getParameterNames();
        PrintWriter printWriter = resp.getWriter();
        User user=ApplicationContext.getInstance().getUserService().createUser(userServerImp.countlist() +1,
                req.getParameter("Name"),req.getParameter("Surname"),
                req.getParameter("Password"),req.getParameter("Login"));
        userServerImp.addUser(user);
        while (param.hasMoreElements()) {
            String pname = param.nextElement();
            printWriter.print("param name: " + pname);
            printWriter.println(" value: " + req.getParameter(pname));

        }
        userServerImp.showAllUsers();
        printWriter.close();

    }
}
