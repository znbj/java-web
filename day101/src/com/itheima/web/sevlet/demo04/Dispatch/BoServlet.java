package com.itheima.web.sevlet.demo04.Dispatch;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Bo")
public class   BoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String money = request.getParameter("money");
        System.out.println("借我元" + money);
        System.out.println("稍等");
        request.setAttribute("jieqianren","张三");
        request.getRequestDispatcher("/xj").forward(request, response);
    }
}
