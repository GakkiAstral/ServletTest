package com.bjsxt.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 全局容器
 */
public class GlobalContainerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取ServletContext对象
        ServletContext servletContext = this.getServletContext();
        servletContext.setAttribute("key1","Oldlu");
        servletContext.setAttribute("key2","Kevin");
        PrintWriter out = resp.getWriter();
        out.println("<!DOCTYPE HTML PUBLIC '-//W3C//DTD HTML 4.0 Transitional//EN'>");
        out.println("<HTML>");
        out.println("<HEAD><TITLE> ITBZ </TITLE></HEAD>");
        out.println("<BODY>");
        String value1 = (String) servletContext.getAttribute("key1");
        String value2 = (String) servletContext.getAttribute("key2");
        out.println("Value1:"+value1+"<br/>");
        out.println("Value2:"+value2+"<br/>");
        out.println("</BODY>");
        out.println("</HTML>");
        out.flush();
        out.close();


    }
}
