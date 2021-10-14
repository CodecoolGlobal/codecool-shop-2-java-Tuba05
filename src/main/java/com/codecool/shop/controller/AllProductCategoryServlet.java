package com.codecool.shop.controller;

import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.implementation.ProductCategoryDaoMem;
import com.codecool.shop.dao.implementation.ProductDaoMem;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "AllProductCategoryServlet", urlPatterns = "/api/get_all_category")
public class AllProductCategoryServlet extends HttpServlet {
    ProductCategoryDao productCategoryDao = ProductCategoryDaoMem.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Set response content type
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        String department = request.getParameter("department");
        System.out.println(department);
        List<ProductCategory> categories = productCategoryDao.find(department);
        Gson gson = new Gson();
        System.out.println(gson.toJson(categories));
        PrintWriter out = response.getWriter();
        out.println(gson.toJson(categories));
    }
}
