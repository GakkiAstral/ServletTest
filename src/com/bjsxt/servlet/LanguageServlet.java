package com.bjsxt.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 需求：编写一个Servlet，如果浏览器的语言是zh-CN，显示"你好，聪明的中国人！"
 * 如果浏览器的语言设置为en-US,那么则显示"Hello，American"。
 */
public class LanguageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String header = req.getHeader("accept-language");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.println("<!DOCTYPE HTML PUBLIC '-//W3C//DTD HTML 4.0 Transitional//EN'>");
        out.println("<HTML>");
        out.println("<HEAD><TITLE> ITBZ </TITLE></HEAD>");
        out.println("<BODY>");
        if (header.indexOf("zh-CN") != -1){
            out.println("你好！中文");
        }else if (header.indexOf("en-US") != -1){
            out.println("Hello,American!");
        }else {
            out.println("不支持该语言！");
        }
        out.println("</BODY>");
        out.println("</HTML>");
        out.flush();
        out.close();
    }
}
