package com.codecool.shop.dao.implementation;

import javax.sql.DataSource;
import java.sql.SQLException;

import com.codecool.shop.dao.*;
import org.postgresql.ds.PGSimpleDataSource;

public class DatabaseManager {

    private DepartmentDao departmentDao;
    private ProductDao productDao;
    private ProductCategoryDao productCategoryDao;
    private ShoppingCartDao shoppingCartDao;
    private SupplierDao supplierDao;

    public void setup() throws SQLException {
        DataSource dataSource = connect();
        departmentDao = new DepartmentDao(dataSource);
        gameStateDao = new GameStateDaoJdbc(dataSource, playerDao);
    }

    private DataSource connect() throws SQLException {
        PGSimpleDataSource dataSource = new PGSimpleDataSource();
        String dbName = System.getenv("databaseName");
        String user = System.getenv("user");
        String password = System.getenv("password");

        dataSource.setDatabaseName(dbName);
        dataSource.setUser(user);
        dataSource.setPassword(password);

        System.out.println("Trying to connect");
        dataSource.getConnection().close();
        System.out.println("Connection ok.");

        return dataSource;
    }
}