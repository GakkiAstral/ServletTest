package com.bjsxt.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 设置字节型响应
 */
public class RespByteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //读取文件图片
        File file = new File("D:\\Edge下载数据\\尚学堂\\尚学堂\\2018IT视频备份\\IT百战视频\\百战_Java\\网站上传\\05第五阶段：JAVAEE 和项目开发\\JavaEE\\02_Servlet技术详解\\源码\\demo\\demo\\web\\images\\尚学堂.jpg");
        FileInputStream fis = new FileInputStream(file);
        byte[] buff = new byte[fis.available()];
        fis.read(buff);

        //设置响应类型
        resp.setContentType("image/jpeg");
        //从HttpServletResponse对象中获取字节输出流对象
        OutputStream os = resp.getOutputStream();
        os.write(buff);
        os.flush();
        os.close();
    }
}
