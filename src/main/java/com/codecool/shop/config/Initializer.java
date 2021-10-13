package com.codecool.shop.config;

import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.ShoppingCartDao;
import com.codecool.shop.dao.SupplierDao;
import com.codecool.shop.dao.implementation.ProductCategoryDaoMem;
import com.codecool.shop.dao.implementation.ProductDaoMem;
import com.codecool.shop.dao.implementation.ShoppingCartDaoMem;
import com.codecool.shop.dao.implementation.SupplierDaoMem;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;

import javax.imageio.ImageIO;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;

@WebListener
public class Initializer implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ProductDao productDataStore = ProductDaoMem.getInstance();
        ProductCategoryDao productCategoryDataStore = ProductCategoryDaoMem.getInstance();
        SupplierDao supplierDataStore = SupplierDaoMem.getInstance();


        //setting up a new supplier
        Supplier hotStuff = new Supplier("HotStuff", "Glasses");
        supplierDataStore.add(hotStuff);
        Supplier flash = new Supplier("Flash", "Jewelery");
        supplierDataStore.add(flash);
        Supplier flux = new Supplier("FluxMax", "Fluxus");
        supplierDataStore.add(flux);



        //setting up a new product category

        ProductCategory glasses = new ProductCategory("Glasses", "Accessories", "Glasses for everyone.");
        ProductCategory jewelery = new ProductCategory("Jewelery", "Accessories", "Bling-bling.");
        ProductCategory other = new ProductCategory("Other", "Accessories", "Everything else.");
        productCategoryDataStore.add(glasses);

        //setting up products and printing it
        productDataStore.add(new Product("Striped sunglasses", new BigDecimal("2.9"), "USD", "Super trendy party glasses.", glasses, hotStuff));
        productDataStore.add(new Product("Earrings", new BigDecimal("9.9"), "USD", "Neon earrings.", jewelery, flash));
        productDataStore.add(new Product("Fluxus capacitor", new BigDecimal("1985.0"), "USD", "Takes you back to the future.", other, flux));

        ProductCategory accessories = new ProductCategory("Glasses", "Accessories", "A thing which can be added to something else in order to make it more useful, versatile, or attractive.");
        ProductCategory clothes = new ProductCategory("Denim", "Clothes", "Items worn to cover the body..");
        ProductCategory shoes = new ProductCategory("Sneakers", "Shoes", "A covering for the foot, typically made of leather, having a sturdy sole and not reaching above the ankle.");

        productCategoryDataStore.add(accessories);
        productCategoryDataStore.add(clothes);
        productCategoryDataStore.add(shoes);
    }
}
