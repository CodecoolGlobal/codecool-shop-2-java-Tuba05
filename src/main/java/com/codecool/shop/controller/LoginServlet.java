package com.codecool.shop.controller;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uname = request.getParameter("uname");
        String pass = request.getParameter("psw");

        if(uname.equals("User") && pass.equals("asd")) {

        if(uname.equals("Jane Doe") && pass.equals("asd")) {

            HttpSession session = request.getSession();
            session.setAttribute("uname", uname);
            response.sendRedirect("home");
        }
        else {
            response.sendRedirect("index.html");
        }
    }
}
