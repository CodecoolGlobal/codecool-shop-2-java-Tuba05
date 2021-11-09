package com.codecool.shop.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter pr = response.getWriter();

        HttpSession session = request.getSession(false);

        if(session != null) {
            String uname = (String) session.getAttribute("uname");
            response.sendRedirect("home.html");
//            pr.print("Welcome " + uname);
//            pr.print("<br/><a href=\"logout\">Logout</a>");
        }
        else {
            response.sendRedirect("index.html");
        }
        pr.close();
    }
}
