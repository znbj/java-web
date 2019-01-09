package com.itheima.web.servlet.liucheng;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cookie/lc2")
public class CookieHello1Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("job".equalsIgnoreCase(cookie.getName())) {
                    System.out.println("job:" + cookie.getName() + cookie.getValue());
                }
            }
        }
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print("做的好");
    }
}
