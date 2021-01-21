package com.neusoft.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Servlet05 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        /* 此处文件读取不到，为空
        * properties文件应和.class文件在同一目录下 因此无法读取文件
        * getResourceAsStream读取的文件路径只局限与工程的源文件夹中，包括在工程src根目录下，以及类包里面任何位置，
        * 但是如果配置文件路径是在除了源文件夹之外的其他文件夹中时，该方法无法使用 */
        InputStream i = this.getServletContext().getResourceAsStream("/resources/postgresql.properties");

        Properties prop = new Properties();
        prop.load(i);

        String username = prop.getProperty("username");
        String password = prop.getProperty("password");

        resp.getWriter().print(username + ":" + password);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
