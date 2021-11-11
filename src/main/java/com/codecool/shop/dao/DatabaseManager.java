package com.codecool.shop.dao;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

import com.codecool.shop.dao.*;
import com.codecool.shop.dao.implementation.ProductCategoryDaoJdbc;
import com.codecool.shop.dao.implementation.ProductCategoryDaoMem;
import com.codecool.shop.dao.implementation.ProductDaoJdbc;
import com.codecool.shop.dao.implementation.SupplierDaoJdbc;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;
import org.postgresql.ds.PGSimpleDataSource;

public class DatabaseManager {

    public DepartmentDao departmentDao;
    public ProductDao productDao;
    public ProductCategoryDao productCategoryDao;
    public ShoppingCartDao shoppingCartDao;
    public SupplierDao supplierDao;
    private static DatabaseManager instance = null;

    public DatabaseManager() throws SQLException {
        DataSource dataSource = connect();
        productDao = new ProductDaoJdbc(dataSource);
        productCategoryDao = new ProductCategoryDaoJdbc(dataSource);
        supplierDao = new SupplierDaoJdbc(dataSource);
//        shoppingCartDao = new ShoppingCartDaoJdbc(dataSource);
    }

    public static DatabaseManager getInstance() throws SQLException {
        if (instance == null) {
            instance = new DatabaseManager();
            return instance;
        }
        else throw new SQLException();
    }

    public void setup() throws SQLException {
        DataSource dataSource = connect();
        productDao = new ProductDaoJdbc(dataSource);
        productCategoryDao = new ProductCategoryDaoJdbc(dataSource);
        supplierDao = new SupplierDaoJdbc(dataSource);
//        shoppingCartDao = new ShoppingCartDaoJdbc(dataSource);
    }

    //Saves

    public void saveProduct(Product product){
        productDao.add(product);
    }

    public void saveSupplier(Supplier supplier){
        supplierDao.add(supplier);
    }


    public List<Product> getAllProducts(){
        return productDao.getAll();
    }

    public List<Supplier> getAllSupplier(){
        return supplierDao.getAll();
    }

    public List<Product> getProductsBySupplier(Supplier supplier){
        return productDao.getBy(supplier);
    };

    public List<Product> getProductsBySupplier(String supplier){
        return productDao.getBySupplier(supplier);
    };

    public List<Product> getProductsByProductCategory(ProductCategory productCategory){
        return productDao.getBy(productCategory);
    }

    public List<Product> getProductsByProductCategory(String productCategory){
        return productDao.getBy(productCategory);
    }

    public ProductCategory findProductCategoryById(int id){
        return productCategoryDao.find(id);
    }
    public ProductCategory findProductCategoryByName(String name){
        return productCategoryDao.findByName(name);
    }
    public List <ProductCategory> findProductCategoryByDepartment(String department){
        return productCategoryDao.find(department);
    }
    public void removeProductCategory(int id){
        productCategoryDao.remove(id);
    }

    public List<ProductCategory> getAllProductCategory(){
        return productCategoryDao.getAll();
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