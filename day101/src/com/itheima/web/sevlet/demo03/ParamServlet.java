package com.itheima.web.sevlet.demo03;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

@WebServlet("/Param")
public class ParamServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        System.out.println("单值参数 username=" + username);
        String[] hobbies = request.getParameterValues("hobby");
        System.out.println("多值参数 hobby=" + Arrays.toString(hobbies));

        System.out.println("++++++++++++++++++++++++++++++++++++++++");
        Map<String, String[]> parameterMap = request.getParameterMap();
        Set<String> set = parameterMap.keySet();
        for (String s : set) {
            System.out.println("参数名"+s + "  参数值 " +Arrays.toString(parameterMap.get(s)) );

        }
    }
}
