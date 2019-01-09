package com.itheima.web.servlet.path;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cookie/path")
public class PathServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie cookie=new Cookie("path1","path1111");
        response.addCookie(cookie);//默认路径


        Cookie cookie1 = new Cookie("path2", "path2222");
        cookie1.setPath(request.getContextPath() + "/aa/bb/");
        response.addCookie(cookie1);//自己设置路径

    }
}
