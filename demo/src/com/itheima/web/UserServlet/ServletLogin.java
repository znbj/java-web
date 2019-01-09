package com.itheima.web.UserServlet;

import com.itheima.domain.user;
import com.itheima.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/ServletLogin")
public class ServletLogin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        HttpSession session = request.getSession();
        String yzm = request.getParameter("yzm");

        if (yzm == null || yzm.trim().length() == 0) {
            session.setAttribute("msg", "验证码不能为空");
            response.sendRedirect(request.getContextPath()+"/login.jsp");
            return;
        }
        String yzmCode = (String) session.getAttribute("yzmCode");
        session.removeAttribute("yzmCode");
        if (yzmCode == null) {
            session.setAttribute("msg","验证码只能用一次");
            response.sendRedirect(request.getContextPath()+"/login.jsp");
            return;
        }
        if (!yzmCode.equalsIgnoreCase(yzm)) {
            session.setAttribute("msg", "验证码错误");
            response.sendRedirect(request.getContextPath() + "/login.jsp");
            return;
        }



        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UserService us = new UserService();
        user use= us.login(username,password);

        if (use == null) {
            session.setAttribute("msg","密码错误");
            response.sendRedirect(request.getContextPath()+"/login.jsp");
            return;
        } else {
            session.setAttribute("user", use);
            response.sendRedirect(request.getContextPath() + "/index.jsp");

        }
    }
}
