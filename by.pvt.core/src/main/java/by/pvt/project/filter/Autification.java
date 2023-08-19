package by.pvt.project.filter;

import by.pvt.project.dto.UserResponse;
import jakarta.servlet.*;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class Autification implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpSession httpSession=httpServletRequest.getSession(false);
        filterChain.doFilter(servletRequest,servletResponse);
        if ( httpSession==null){
            httpServletRequest.setAttribute("error","error");
            httpServletRequest.getRequestDispatcher("/loginFailed.jsp").forward(httpServletRequest,servletResponse);
        }else {
//        UserResponse userResponse= (UserResponse)httpSession.getAttribute("");
        filterChain.doFilter(httpServletRequest,servletResponse);
    }}


}
