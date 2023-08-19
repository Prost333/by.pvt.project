package by.pvt.project.servlets;

import by.pvt.project.config.ApplicationContext;
import by.pvt.project.service.GoodService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class GoodFunctionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GoodService goodService = ApplicationContext.getInstance().getGoodService();
        goodService.deliteGood((int) Double.parseDouble(req.getParameter("id")));
    }
}
