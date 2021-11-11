package com.codecool.shop.controller;

import com.codecool.shop.dao.*;
import com.codecool.shop.dao.implementation.DepartmentDaoMem;
import com.codecool.shop.dao.implementation.ProductCategoryDaoMem;
import com.codecool.shop.dao.implementation.ProductDaoMem;
import com.codecool.shop.model.Department;
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

@WebServlet(name = "AllDepartmentServlet", urlPatterns = "/api/get_all_department")
public class AllDepartmentServlet extends HttpServlet {
    DepartmentDao departmentDao = DepartmentDaoMem.getInstance();
    DatabaseManager databaseManager = DatabaseManager.getInstance();
    SetUpMemOrSql setUpMemOrSql = new SetUpMemOrSql();
    boolean daoTypeIsSql;

    public AllDepartmentServlet() throws SQLException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.daoTypeIsSql = setUpMemOrSql.readResource();

        // Set response content type
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        List<Department> departments;
        if(daoTypeIsSql){departments=databaseManager.getAllDepartment();}
        else {departments=departmentDao.getAll();}
        Gson gson = new Gson();
        System.out.println(gson.toJson(departments));
        PrintWriter out = response.getWriter();
        out.println(gson.toJson(departments));
    }
}

