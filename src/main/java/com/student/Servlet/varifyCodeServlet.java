package com.student.Servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet("/varifyCodeServlet")
public class varifyCodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedImage bf= new BufferedImage(80,35,BufferedImage.TYPE_INT_RGB);
        Graphics2D gp = (Graphics2D) bf.getGraphics();
        gp.setColor(Color.yellow);
        gp.fillRect(0,0,80,35);
        StringBuilder sb1 = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            sb1.append((char)(i+'a'));
            sb1.append((char)(i+'A'));
        }
        for (int i = 0; i < 10; i++) {
            sb1.append(i);
        }
        String strAll = sb1.toString();
        StringBuilder sb = new StringBuilder();
        Random rd= new Random();
        for (int i = 0; i < 5; i++) {
            int r = rd.nextInt(strAll.length());
            sb.append(strAll.charAt(r));
        }
        String varify = sb.toString();
        request.getSession().setAttribute("varify",varify);

        gp.setColor(Color.black);
        gp.drawString(varify,25,22);
        ImageIO.write(bf,"JPEG",response.getOutputStream());

    }
}
