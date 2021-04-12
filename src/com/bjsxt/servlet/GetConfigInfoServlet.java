package com.bjsxt.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * 通过ServletConfig对象读取配置信息
 */
public class GetConfigInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取ServletConfig对象
        ServletConfig servletConfig = this.getServletConfig();
        Enumeration<String> initParameterNames = servletConfig.getInitParameterNames();
        PrintWriter out = resp.getWriter();
        out.println("<!DOCTYPE HTML PUBLIC '-//W3C//DTD HTML 4.0 Transitional//EN'>");
        out.println("<HTML>");
        out.println("<HEAD><TITLE> ITBZ </TITLE></HEAD>");
        out.println("<BODY>");
        while (initParameterNames.hasMoreElements()){
            String key = initParameterNames.nextElement();
            out.println("Key:"+key+" Value:"+servletConfig.getInitParameter(key)+"<br/>");
        }
        out.println("</BODY>");
        out.println("</HTML>");
        out.flush();
        out.close();
    }
}
