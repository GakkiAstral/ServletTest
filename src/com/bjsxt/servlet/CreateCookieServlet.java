package com.bjsxt.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 创建Cookie对象，
 */
public class CreateCookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //创建Cookie对象
        Cookie cookie = new Cookie("name","北京尚学堂");
        //设置Cookie的失效时间，一旦设置了失效时间，该Cookie为持久化Cookie
        cookie.setMaxAge(60);
        resp.addCookie(cookie);
        PrintWriter out = resp.getWriter();
        out.println("<!DOCTYPE HTML PUBLIC '-//W3C//DTD HTML 4.0 Transitional//EN'>");
        out.println("<HTML>");
        out.println("<HEAD><TITLE> ITBZ </TITLE></HEAD>");
        out.println("<BODY>");
        out.println("Create Cookie"+"<br/>");
        out.println("</BODY>");
        out.println("</HTML>");
        out.flush();
        out.close();
    }
}
