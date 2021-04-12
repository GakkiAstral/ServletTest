package com.bjsxt.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * ServletContext对象读取web.xml文件中的信息
 */
public class ContextReadInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取ServletContext
        ServletContext servletContext = this.getServletContext();
        Enumeration<String> initParameter = servletContext.getInitParameterNames();
        PrintWriter out = resp.getWriter();
        out.println("<!DOCTYPE HTML PUBLIC '-//W3C//DTD HTML 4.0 Transitional//EN'>");
        out.println("<HTML>");
        out.println("<HEAD><TITLE> ITBZ </TITLE></HEAD>");
        out.println("<BODY>");
        while (initParameter.hasMoreElements()){
            String name = initParameter.nextElement();
            out.println("Name:"+name+" Value:"+servletContext.getInitParameter(name));
        }

        out.println("</BODY>");
        out.println("</HTML>");
        out.flush();
        out.close();
    }
}
