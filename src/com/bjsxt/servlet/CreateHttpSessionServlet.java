package com.bjsxt.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * HttpSession创建过程
 */
public class CreateHttpSessionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.setAttribute("key", "BJSXt");
        String id = session.getId();
        System.out.println(session + " " + id);
        PrintWriter out = resp.getWriter();
        out.println("<!DOCTYPE HTML PUBLIC '-//W3C//DTD HTML 4.0 Transitional//EN'>");
        out.println("<HTML>");
        out.println("<HEAD><TITLE> ITBZ </TITLE></HEAD>");
        out.println("<BODY>");
        out.println("Create HttpSession");
        out.println("</BODY>");
        out.println("</HTML>");
        out.flush();
        out.close();
    }
}
