package com.itheima.web.download;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

@WebServlet("/DownloadServlet")
public class DownloadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fileName = request.getParameter("fileName");
        ServletContext context = this.getServletContext();
        String name = context.getMimeType("name");
        response.setContentType(name);
        response.setHeader("Content-Disposition","attachment;fileName="+fileName);
        response.setHeader("Content-Disposition", "attachment;fileName=" + URLEncoder.encode(name, "utf-8"));
        ServletOutputStream outputStream = response.getOutputStream();
        InputStream is = context.getResourceAsStream("/web/download/" + name);
        byte[] bytes  = new byte[1024];
        int len =0;
        while ((len = is.read(bytes)) != -1) {
            outputStream.write(bytes, 0, len);
        }
        outputStream.close();
        is.close();

    }
}
