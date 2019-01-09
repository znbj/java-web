package com.itheima.web.servlet.age;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Age2getcookie")
public class Age2Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();//获取cookie
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("test".equalsIgnoreCase(cookie.getName())) {

                    System.out.println("内容" + cookie.getValue());
                }

            }
        }
    }
}
