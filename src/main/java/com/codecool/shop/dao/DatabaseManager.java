package com.codecool.shop.dao;

import javax.sql.DataSource;
import java.sql.SQLException;

import com.codecool.shop.dao.*;
import com.codecool.shop.dao.implementation.ProductCategoryDaoJdbc;
import com.codecool.shop.dao.implementation.ProductDaoJdbc;
import com.codecool.shop.dao.implementation.SupplierDaoJdbc;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;
import org.postgresql.ds.PGSimpleDataSource;

public class DatabaseManager {

    private DepartmentDao departmentDao;
    private ProductDao productDao;
    private ProductCategoryDao productCategoryDao;
    private ShoppingCartDao shoppingCartDao;
    private SupplierDao supplierDao;

    public DatabaseManager() throws SQLException {
        DataSource dataSource = connect();
        productDao = new ProductDaoJdbc(dataSource);
        productCategoryDao = new ProductCategoryDaoJdbc(dataSource);
        supplierDao = new SupplierDaoJdbc(dataSource);
//        shoppingCartDao = new ShoppingCartDaoJdbc(dataSource);
    }

    public void setup() throws SQLException {
        DataSource dataSource = connect();
        productDao = new ProductDaoJdbc(dataSource);
        productCategoryDao = new ProductCategoryDaoJdbc(dataSource);
        supplierDao = new SupplierDaoJdbc(dataSource);
//        shoppingCartDao = new ShoppingCartDaoJdbc(dataSource);
    }

    public void saveProduct(Product product){
        productDao.add(product);
    }

    public void saveProductCategory(ProductCategory productCategory){
        productCategoryDao.add(productCategory);
    }

    public void saveSupplier(Supplier supplier){
        supplierDao.add(supplier);
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