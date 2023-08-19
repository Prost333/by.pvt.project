package by.pvt.project.servlets;

import by.pvt.project.config.ApplicationContext;
import by.pvt.project.domain.Good;
import by.pvt.project.repository.GoodRepository;
import by.pvt.project.service.GoodService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class GoodRegistrationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GoodService goodService = ApplicationContext.getInstance().getGoodService();
        PrintWriter pw = resp.getWriter();
        resp.setContentType("text/html");
        try {
        if (!req.getParameter("change_name").isEmpty()) {
            try {
                goodService.updateGood((int) Double.parseDouble(req.getParameter("change_id")),
                        req.getParameter("change_name"),
                        req.getParameter("change_type"),
                        Double.parseDouble(req.getParameter("change_price")));

            } catch (Throwable e) {
                req.getRequestDispatcher("/loginFailed.jsp").forward(req, resp);
            }}

        } catch (Throwable e) {
            pw.println(goodService.goodList());
        }

            pw.close();
        }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GoodService goodService = ApplicationContext.getInstance().getGoodService();
        Enumeration<String> param = req.getParameterNames();
        PrintWriter printWriter = resp.getWriter();
            try {
                req.getParameter("Name").isEmpty();
                try {
                    Good good = ApplicationContext.getInstance().getGoodService().createGood(req.getParameter("Name"),
                            goodService.SizeGood() + 1,
                            req.getParameter("type"),
                            Double.parseDouble(req.getParameter("price")),
                            (int) (req.getParameter("Name").hashCode() +
                                    goodService.goodList().size() + 1 +
                                    req.getParameter("type").hashCode() +
                                    Double.parseDouble(req.getParameter("price"))));
                    goodService.addGood(good);
                    req.setAttribute("list", good);
                    req.getRequestDispatcher("/goodMenu.jsp").forward(req, resp);
                } catch (Throwable e) {
                    req.getRequestDispatcher("/loginFailed.jsp").forward(req, resp);
                }
            } catch (Throwable e) {
                try {
                    goodService.deliteGood((int) Double.parseDouble(req.getParameter("id")));
                } catch (Throwable el) {
                    req.getRequestDispatcher("/loginFailed.jsp").forward(req, resp);
                }
            }



            while (param.hasMoreElements()) {
                String pname = param.nextElement();
                printWriter.print("param name: " + pname);
                printWriter.println(" value: " + req.getParameter(pname));
            }
            printWriter.close();



        }
    }


