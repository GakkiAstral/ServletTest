package com.bjsxt.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 需求：当客户端浏览器第一次访问Servlet 时返回“您好，欢迎您第一次访问！”，第二次访问时返回“欢迎您回来！”。
 */
public class WelcomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取Cookie
        Cookie[] cookies = req.getCookies();
        boolean flag = false;
        if (cookies != null){
            for (Cookie cookie:cookies) {
                if ("first".equals(cookie.getName())){
                    flag = true;
                }
            }
        }
        resp.setContentType("text/html;charset=utf-8");

        PrintWriter out = resp.getWriter();
        out.println("<!DOCTYPE HTML PUBLIC '-//W3C//DTD HTML 4.0 Transitional//EN'>");
        out.println("<HTML>");
        out.println("<HEAD><TITLE> ITBZ </TITLE></HEAD>");
        out.println("<BODY>");
        if (flag == true){
            out.println("欢迎您回来！");
        }else {
            out.println("您好！欢迎第一次访问！");
            Cookie cookie = new Cookie("first","first");
            cookie.setMaxAge(60);
            resp.addCookie(cookie);
        }
        out.println("</BODY>");
        out.println("</HTML>");
        out.flush();
        out.close();
    }
}
