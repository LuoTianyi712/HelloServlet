package com.neusoft.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/***
 * 令牌验证器
 */
public class ImageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("refresh","3"); /* 可以换其他的刷新方式？ */
        BufferedImage image = new BufferedImage(80,20,BufferedImage.TYPE_INT_RGB);

        Graphics2D g = (Graphics2D) image.getGraphics();

        g.setColor(Color.WHITE);
        g.fillRect(0,0,80,80);

        g.setColor(Color.BLUE);
        g.setFont(new Font(null,Font.BOLD,20));

        g.drawString(randomNum(),0,20);

        resp.setContentType("image/png");
        /* 禁止缓存 */
        resp.setDateHeader("expires",-1);
        resp.setHeader("Cache-Control","no-cache");
        resp.setHeader("Pragma","no-cache");

        ImageIO.write(image,"png",resp.getOutputStream());
    }

    private String randomNum(){
        Random random = new Random();
        String num = String.valueOf(random.nextInt(9999999));

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 7-num.length(); i++) { /* 如果随机数不满7位，就补零，缺几位补几位 */
//            sb.append("0");
            sb.append(random.nextInt(9));
        }
        num = sb.toString() + num;
        return num;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
