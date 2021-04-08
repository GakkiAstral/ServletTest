package com.bjsxt.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * 重定向响应
 */
public class RedirectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String search = req.getParameter("search");
        resp.sendRedirect("https://www.baidu.com/s?wd="+ URLEncoder.encode(search,"utf-8"));
        //resp.sendRedirect("https://www.baidu.com/s?wd="+search);
        //这里不对search做处理的话，浏览器是无法显示中文的，会在重定向响应时候显示乱码
    }
}
