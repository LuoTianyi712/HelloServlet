package com.neusoft.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

/***
 * 文件下载
 */
public class FileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 要获取下载文件的路径
        String realPath = "E:\\test.png";
        System.out.println("下载文件的路径" + realPath);

        // 下载的文件名是？
        String fileName = realPath.substring(realPath.lastIndexOf("\\") + 1); /* lastIndexOf(str) 返回此字符串中最后一次出现的索引 */

        // 设置浏览器支持(Content-Disposition)下载我们需要的东西
        resp.setHeader("Content-Disposition","attachment;filename=" + fileName);

        // 获取下载文件的输入流
        FileInputStream fis = new FileInputStream(realPath);

        // 创建缓冲区
        int len = 0;
        byte[] buffer = new byte[1024];

        // 获取OutputStream对象
        ServletOutputStream sos = resp.getOutputStream();

        // 将FileOutputStream流写入到buffer缓冲区，使用OutputStream将缓冲区中的数据输出到客户端
        while ((len = fis.read(buffer)) > 0)
        {
            sos.write(buffer,0,len);
        }

        // 关闭文件输入输出流
        fis.close();
        sos.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
