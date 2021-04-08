package com.bjsxt.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

/**
 * 获取请求数据
 */
public class GetRequestDataServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String username = req.getParameter("username");
        String[] userlikes = req.getParameterValues("userlike");
        List<String> strings =  Arrays.asList(userlikes);

        Enumeration<String> parameterNames = req.getParameterNames();
        List<String> keys = new ArrayList<>();
        while(parameterNames.hasMoreElements()){
            keys.add(parameterNames.nextElement());
        }

        Map<String, String[]> parameterMap = req.getParameterMap();
        resp.setContentType("text/html;charset=utf-8");

        PrintWriter out = resp.getWriter();
        out.println("<!DOCTYPE HTML PUBLIC '-//W3C//DTD HTML 4.0 Transitional//EN'>");
        out.println("<HTML>");
        out.println("<HEAD><TITLE> ITBZ </TITLE></HEAD>");
        out.println("<BODY>");
        out.println("UserName:" + username+"<br/>");
        out.println("UserName:" + strings+"<br/>");
        out.println("Keys:"+keys+"<br/>");
        Iterator<Map.Entry<String,String[]>> iterator = parameterMap.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<String,String[]> entry = iterator.next();
            out.println("Keys:"+entry.getKey()+" Value:"+Arrays.asList(entry.getValue())+"<br/>");
        }
        out.println("</BODY>");
        out.println("</HTML>");
        out.flush();
        out.close();
    }
}
