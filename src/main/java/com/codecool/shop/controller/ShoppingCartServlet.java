package com.codecool.shop.controller;

import com.codecool.shop.config.HttpRequestJava;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.ShoppingCartDao;
import com.codecool.shop.dao.implementation.ProductDaoMem;
import com.codecool.shop.dao.implementation.ShoppingCartDaoMem;
import com.codecool.shop.model.Product;
import com.google.gson.Gson;
//import com.google.gson.reflect.TypeToken;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ShoppingCartServlet", urlPatterns = "/shoppingcart")
public class ShoppingCartServlet extends HttpServlet {
    ProductDao productDao = ProductDaoMem.getInstance();
    ShoppingCartDao shoppingCartDataStore = ShoppingCartDaoMem.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Set response content type
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        String responsId = request.getParameter("id");
        int id = Integer.parseInt(responsId);

        Product product = productDao.find(id);

        // add Mem
        shoppingCartDataStore.add(product);

        Gson gson = new Gson();
        System.out.println(gson.toJson(shoppingCartDataStore.getAll()));
        PrintWriter out = response.getWriter();
        out.println(gson.toJson(product));
    }
}