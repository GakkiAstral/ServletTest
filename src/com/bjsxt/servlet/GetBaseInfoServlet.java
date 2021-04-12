package com.bjsxt.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 获取容器附加信息
 */
public class GetBaseInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        //获取ServletContext对象
        ServletContext servletContext = this.getServletContext();
        String serverInfo = servletContext.getServerInfo();
        int majorVersion = servletContext.getMajorVersion();
        int minorVersion = servletContext.getMinorVersion();
        PrintWriter out = resp.getWriter();
        out.println("<!DOCTYPE HTML PUBLIC '-//W3C//DTD HTML 4.0 Transitional//EN'>");
        out.println("<HTML>");
        out.println("<HEAD><TITLE> ITBZ </TITLE></HEAD>");
        out.println("<BODY>");
        out.println("Servlet容器的名称以及版本号:" + serverInfo + "<br/>");
        out.println("Servlet容器所支持的Servlet的版本号:" + majorVersion + " " + minorVersion + "<br/>");
        out.println("</BODY>");
        out.println("</HTML>");
        out.flush();
        out.close();
    }
}
