package com.bjsxt.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 获取Cookie中的数据
 */
public class GetCookieDataServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //在请求中获取Cookie对象
        Cookie[] cookies = req.getCookies();
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.println("<!DOCTYPE HTML PUBLIC '-//W3C//DTD HTML 4.0 Transitional//EN'>");
        out.println("<HTML>");
        out.println("<HEAD><TITLE> ITBZ </TITLE></HEAD>");
        out.println("<BODY>");
        for (int i = 0;i<cookies.length;i++){
            Cookie cookie = cookies[i];
            out.println("Name:"+cookie.getName()+" Value:"+cookie.getValue()+"<br/>");
        }
        out.println("</BODY>");
        out.println("</HTML>");
        out.flush();
        out.close();
    }
}
