package com.codecool.shop.controller;

import com.codecool.shop.dao.DatabaseManager;
import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.SetUpMemOrSql;
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
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "GetAllProductByCategoryServlet", urlPatterns = "/api/get_all_product_by_category")
public class GetAllProductByCategoryServlet extends HttpServlet {
    ProductDao productDao = ProductDaoMem.getInstance();
    DatabaseManager databaseManager = DatabaseManager.getInstance();
    SetUpMemOrSql setUpMemOrSql = new SetUpMemOrSql();
    boolean daoTypeIsSql;

    public GetAllProductByCategoryServlet() throws SQLException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.daoTypeIsSql = setUpMemOrSql.readResource();
        // Set response content type
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        String category = request.getParameter("category");

        List<Product> productList;
        if(daoTypeIsSql){productList=databaseManager.getProductsByProductCategory(category);}
        else {productList=productDao.getBy(category);}
                 productDao.getBy(category);
        Gson gson = new Gson();
        PrintWriter out = response.getWriter();
        out.println(gson.toJson(productList));
    }
}
