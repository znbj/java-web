package com.itheima.web.servlet;

import com.itheima.dao.KWDao;
import com.itheima.domain.Usery;
import com.itheima.service.KWService;
import com.itheima.utils.BeanFactory;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebServlet("/KeyWordAjax")
public class ServletKeyword extends HttpServlet {
    private KWService kwService = BeanFactory.newInstance(KWService.class);
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String content = request.getParameter("kw");
        List<Usery> list = kwService.findByKW(content);

        JSONArray jsonArray = JSONArray.fromObject(list);
        String string = jsonArray.toString();
       response.getWriter().print(string);

    }
}
