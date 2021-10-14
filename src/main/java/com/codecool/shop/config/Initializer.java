package com.codecool.shop.config;

import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.ShoppingCartDao;
import com.codecool.shop.dao.SupplierDao;
import com.codecool.shop.dao.DepartmentDao;
import com.codecool.shop.dao.implementation.DepartmentDaoMem;
import com.codecool.shop.dao.implementation.ProductCategoryDaoMem;
import com.codecool.shop.dao.implementation.ProductDaoMem;
import com.codecool.shop.dao.implementation.ShoppingCartDaoMem;
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
        Supplier flash = new Supplier("Flash", "Jewellery");
        supplierDataStore.add(flash);
        Supplier flux = new Supplier("FluxMax", "Fluxus");
        supplierDataStore.add(flux);



        //setting up a new department

        Department accessories = new Department("Accessories");
        Department clothes = new Department("Clothes");
        Department shoes = new Department("Shoes");

        //setting up a new product category

        ProductCategory glasses = new ProductCategory("Glasses", new Department("Accessories"), "Glasses for everyone.");
        ProductCategory jewelery = new ProductCategory("Jewellery",  new Department("Accessories"), "Bling-bling.");
        ProductCategory other = new ProductCategory("Other",  new Department("Accessories"), "Everything else.");

        ProductCategory coat = new ProductCategory("Coat",  new Department("Clothes"), "Fashionable items.");
        ProductCategory tShirt = new ProductCategory("T-shirt",  new Department("Clothes"), "Everything starts here.");
        ProductCategory denim = new ProductCategory("Denim",  new Department("Clothes"), "Items for every occasion.");

        ProductCategory heels = new ProductCategory("Heels",  new Department("Shoes"), "Items for every occasion.");
        ProductCategory sneakers = new ProductCategory("Sneakers",  new Department("Shoes"), "Everything starts here..");
        ProductCategory boots = new ProductCategory("Boots",  new Department("Shoes"), "Fashionable items.");
        productCategoryDataStore.add(glasses);
        productCategoryDataStore.add(jewelery);
        productCategoryDataStore.add(other);
        productCategoryDataStore.add(coat);
        productCategoryDataStore.add(tShirt);
        productCategoryDataStore.add(denim);
        productCategoryDataStore.add(heels);
        productCategoryDataStore.add(sneakers);
        productCategoryDataStore.add(boots);

        //setting up products and printing it
        productDataStore.add(new Product("Striped sunglasses", new BigDecimal("2.9"), "USD", "Super trendy party glasses.", glasses, hotStuff));
        productDataStore.add(new Product("Break sunglasses", new BigDecimal("4.9"), "USD", "Must-have party accessory.", glasses, hotStuff));
        productDataStore.add(new Product("Sophia Loren glasses", new BigDecimal("19.9"), "USD", "Classy glasses.", glasses, flash));
        productDataStore.add(new Product("Earrings", new BigDecimal("9.9"), "USD", "Neon earrings.", jewelery, flash));
        productDataStore.add(new Product("Bracelet", new BigDecimal("5.9"), "USD", "Bracelet with animal printing.", jewelery, hotStuff));
        productDataStore.add(new Product("Scrunchie", new BigDecimal("0.9"), "USD", "Colorful scrunchies.", jewelery, hotStuff));
        productDataStore.add(new Product("Fluxus capacitor", new BigDecimal("1985.0"), "USD", "Takes you back to the future.", other, flux));


        departmentDataStore.add(accessories);
        departmentDataStore.add(clothes);
        departmentDataStore.add(shoes);
    }
}
