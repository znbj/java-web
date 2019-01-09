package com.itheima.ServletContext.lizi01;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

@WebServlet(urlPatterns = "/ResourceServlet")
public class ResourceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取管家 ServletContext 上下文
        ServletContext context = this.getServletContext();
        //获取磁盘路径
        String realPath = context.getRealPath("11.jpg");
        System.out.println(realPath);

        //获取资源流
        InputStream asStream = context.getResourceAsStream("11.jpg");
        System.out.println(asStream);

        String mimeType = context.getMimeType("11.jpg");
        System.out.println(mimeType);
    }
}
