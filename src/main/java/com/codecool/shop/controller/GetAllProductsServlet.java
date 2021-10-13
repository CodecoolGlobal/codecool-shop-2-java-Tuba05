package com.codecool.shop.controller;

import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.implementation.ProductDaoMem;
import com.codecool.shop.model.Product;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


@WebServlet(name = "GetAllProductsServlet", urlPatterns = "/api/get_all_products")
public class GetAllProductsServlet extends HttpServlet {
    ProductDao productDao = ProductDaoMem.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Set response content type
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        List<Product> productList = productDao.getAll();
        Gson gson = new Gson();
        System.out.println(gson.toJson(productList));
        PrintWriter out = response.getWriter();
        out.println(gson.toJson(productList));
    }
}