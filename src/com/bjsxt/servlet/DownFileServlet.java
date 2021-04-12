package com.bjsxt.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 文件下载
 */
public class DownFileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取servletContext对象
        ServletContext servletContext = this.getServletContext();
        //路径转换
        String realPath = servletContext.getRealPath("image/尚学堂.jpg");
        System.out.println(realPath);
        //读文件
        File file = new File(realPath);
        FileInputStream fis = new FileInputStream(file);
        byte[] buff = new byte[fis.available()];
        fis.read(buff);

        //在响应中添加附加信息
        resp.addHeader("Content-Disposition","attachment;filename="+new String(file.getName().getBytes("gbk"),"iso-8859-1"));
        //还有一个serHeader方法
        OutputStream os = resp.getOutputStream();
        os.write(buff);
        os.flush();
        os.close();
    }
}
