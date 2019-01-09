package com.itheima.web.sevlet.demo02.header;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/header")
public class HeaderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String header = request.getHeader("User-agent");
        System.out.println("浏览器的牌子" + header);
        String referer = request.getHeader("Referer");
        System.out.println("请求来源" + referer);

        Enumeration<String> headerNames = request.getHeaders("Accept-Encoding");
        while (headerNames.hasMoreElements()) {
            System.out.println(headerNames.nextElement());

        }

        Enumeration<String> headers = request.getHeaderNames();
        while (headers.hasMoreElements()) {
            System.out.println(headers.nextElement());

        }

    }
}
