package by.pvt.project.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class Authentication implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpSession httpSession = httpServletRequest.getSession(false);

        if (httpSession == null) {
            httpServletRequest.setAttribute("error", "error");
            httpServletRequest.getRequestDispatcher("/loginFailed.jsp").forward(httpServletRequest, servletResponse);
        } else if (httpSession.getAttribute("filter") == null) {
            httpServletRequest.setAttribute("error", "error");
            httpServletRequest.getRequestDispatcher("/loginFailed.jsp").forward(httpServletRequest, servletResponse);
        } else {

            filterChain.doFilter(httpServletRequest, servletResponse);
        }
    }
}




