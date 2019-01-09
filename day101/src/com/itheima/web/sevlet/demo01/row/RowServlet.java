package com.itheima.web.sevlet.demo01.row;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/row")
public class RowServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        System.out.println("请求路径" + requestURI);
        String queryString = request.getQueryString();
        System.out.println("请求参数" + queryString);
        String protocol = request.getProtocol();
        System.out.println("协议/版本" + protocol);
        String method = request.getMethod();
        System.out.println("请求方式" + method);
        String contextPath = request.getContextPath();
        System.out.println("项目路径" + contextPath);
        String remoteAddr = request.getRemoteAddr();
        System.out.println("远程ip" + remoteAddr);
        
    }
}
