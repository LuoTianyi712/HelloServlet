package com.neusoft.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        this.getInitParameter();      /* 初始化参数 */
//        this.getServletConfig();      /* servlet配置 */
//        this.getServletContext();     /* servlet上下文 */

        /* 代表当前的web应用，这个网站由servletContext来管理 */
        ServletContext context = this.getServletContext();

        String userName = "xxx-abc"; /* 数据 */

        context.setAttribute("username",userName);/* 将一个数据保存在了servlet context中，名字为username */



        System.out.println("hello servlet 02");
    }
}
