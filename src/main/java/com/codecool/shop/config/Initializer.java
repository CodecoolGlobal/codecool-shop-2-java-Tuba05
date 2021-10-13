package com.codecool.shop.config;

import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.SupplierDao;
import com.codecool.shop.dao.DepartmentDao;
import com.codecool.shop.dao.implementation.DepartmentDaoMem;
import com.codecool.shop.dao.implementation.ProductCategoryDaoMem;
import com.codecool.shop.dao.implementation.ProductDaoMem;
import com.codecool.shop.dao.implementation.SupplierDaoMem;
import com.codecool.shop.model.Department;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.math.BigDecimal;

@WebListener
public class Initializer implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ProductDao productDataStore = ProductDaoMem.getInstance();
        ProductCategoryDao productCategoryDataStore = ProductCategoryDaoMem.getInstance();
        SupplierDao supplierDataStore = SupplierDaoMem.getInstance();
        DepartmentDao departmentDataStore = DepartmentDaoMem.getInstance();

        //setting up a new supplier
        Supplier hotStuff = new Supplier("HotStuff", "Glasses");
        supplierDataStore.add(hotStuff);
        Supplier flash = new Supplier("Flash", "Jewelery");
        supplierDataStore.add(flash);
        Supplier flux = new Supplier("FluxMax", "Fluxus");
        supplierDataStore.add(flux);



        //setting up a new department

        Department accessories = new Department("Accessories");
        Department clothes = new Department("Cloths");
        Department shoes = new Department("Shoes");

        //setting up a new product category

        ProductCategory glasses = new ProductCategory("Glasses", "Accessories", "Glasses for everyone.");
        ProductCategory jewelery = new ProductCategory("Jewelery", "Accessories", "Bling-bling.");
        ProductCategory other = new ProductCategory("Other", "Accessories", "Everything else.");
        productCategoryDataStore.add(glasses);

        //setting up products and printing it
        productDataStore.add(new Product("Striped sunglasses", new BigDecimal("2.9"), "USD", "Super trendy party glasses.", glasses, hotStuff));
        productDataStore.add(new Product("Earrings", new BigDecimal("9.9"), "USD", "Neon earrings.", jewelery, flash));
        productDataStore.add(new Product("Fluxus capacitor", new BigDecimal("1985.0"), "USD", "Takes you back to the future.", other, flux));


        departmentDataStore.add(accessories);
        departmentDataStore.add(clothes);
        departmentDataStore.add(shoes);
    }
}
