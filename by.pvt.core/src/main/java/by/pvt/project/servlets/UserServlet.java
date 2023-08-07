package by.pvt.project.servlets;


import by.pvt.project.config.ApplicationContext;
import by.pvt.project.domain.User;
import by.pvt.project.repository.UserRepository;
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
        UserRepository userRepository= ApplicationContext.getInstance().getUserRepository();
        pw.println(userRepository.update().size());
        pw.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserRepository userRepository=ApplicationContext.getInstance().getUserRepository();
        Enumeration<String> param = req.getParameterNames();
        PrintWriter printWriter = resp.getWriter();
        User user=ApplicationContext.getInstance().getUserService().createUser(userRepository.update().size()+1,
                req.getParameter("Login"),req.getParameter("Password"),
                req.getParameter("Name"),req.getParameter("Surname"));
        userRepository.addUser(user);
        userRepository.saveUser();
        while (param.hasMoreElements()) {
            String pname = param.nextElement();
            printWriter.print("param name: " + pname);
            printWriter.println("value: " + req.getParameter(pname));
        }
        userRepository.showAllUsers();
        printWriter.close();

    }
}
