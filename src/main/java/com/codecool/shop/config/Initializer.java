package com.codecool.shop.config;

import com.codecool.shop.dao.*;
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
import java.sql.SQLException;

@WebListener
public class Initializer implements ServletContextListener {

    public boolean daoTypeIsSql;



    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ProductDao productDataStore = ProductDaoMem.getInstance();
        ProductCategoryDao productCategoryDataStore = ProductCategoryDaoMem.getInstance();
        SupplierDao supplierDataStore = SupplierDaoMem.getInstance();
        DepartmentDao departmentDataStore = DepartmentDaoMem.getInstance();
        SetUpMemOrSql setUpMemOrSql = new SetUpMemOrSql();

        DatabaseManager databaseManager = null;
        try {
            databaseManager = new DatabaseManager();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //Check connection.properties
        this.daoTypeIsSql = setUpMemOrSql.readResource();

        //setting up a new supplier
        Supplier hotStuff = new Supplier("HotStuff", "Glasses");
        Supplier flash = new Supplier("Flash", "Jewellery");
        Supplier flux = new Supplier("FluxMax", "Fluxus");

        //Save to Mem
        if (!daoTypeIsSql){
            supplierDataStore.add(hotStuff);
            supplierDataStore.add(flash);
            supplierDataStore.add(flux);
        }

        // Save to SqlDataBase
        if(daoTypeIsSql){
            if(databaseManager.getAllSupplier().size()==0){
                databaseManager.saveSupplier(hotStuff);
                databaseManager.saveSupplier(flash);
                databaseManager.saveSupplier(flux);
            }
        }



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

        // Save to Mem
        if(!daoTypeIsSql){
            productCategoryDataStore.add(glasses);
            productCategoryDataStore.add(jewelery);
            productCategoryDataStore.add(other);
            productCategoryDataStore.add(coat);
            productCategoryDataStore.add(tShirt);
            productCategoryDataStore.add(denim);
            productCategoryDataStore.add(heels);
            productCategoryDataStore.add(sneakers);
            productCategoryDataStore.add(boots);
        }

        // Save to SqlDataBase
        if (daoTypeIsSql){
            if(databaseManager.getAllProductCategory().size()==0) {
                databaseManager.saveProductCategory(glasses);
                databaseManager.saveProductCategory(jewelery);
                databaseManager.saveProductCategory(other);
                databaseManager.saveProductCategory(coat);
                databaseManager.saveProductCategory(tShirt);
                databaseManager.saveProductCategory(denim);
                databaseManager.saveProductCategory(heels);
                databaseManager.saveProductCategory(sneakers);
                databaseManager.saveProductCategory(boots);
            }
        }

        //Sava to Mem
        if (!daoTypeIsSql){
            productDataStore.add(new Product("Striped sunglasses", new BigDecimal("3"), "USD", "Super trendy party glasses.", glasses, hotStuff));
            productDataStore.add(new Product("Break sunglasses", new BigDecimal("5"), "USD", "Must-have party accessory.", glasses, hotStuff));
            productDataStore.add(new Product("Sophia Loren glasses", new BigDecimal("20"), "USD", "Classy glasses.", glasses, flash));
            productDataStore.add(new Product("Earrings", new BigDecimal("10"), "USD", "Neon earrings.", jewelery, flash));
            productDataStore.add(new Product("Bracelet", new BigDecimal("6"), "USD", "Bracelet with animal printing.", jewelery, hotStuff));
            productDataStore.add(new Product("Scrunchie", new BigDecimal("1"), "USD", "Colorful scrunchies.", jewelery, hotStuff));
            productDataStore.add(new Product("Multicolor heels", new BigDecimal("30"), "USD", "Must-have item.", heels, hotStuff));
            productDataStore.add(new Product("Rainbow heels", new BigDecimal("30"), "USD", "Party Queen heels.", heels, hotStuff));
            productDataStore.add(new Product("Classic Nike", new BigDecimal("100"), "USD", "Must-have item.", sneakers, flash));
            productDataStore.add(new Product("Reebok", new BigDecimal("70"), "USD", "Iconic sneakers.", sneakers, hotStuff));
            productDataStore.add(new Product("Red boot", new BigDecimal("40"), "USD", "Keeps you warm.", boots, flash));
            productDataStore.add(new Product("Boot with heels", new BigDecimal("50"), "USD", "Must-have item.", boots, hotStuff));
            productDataStore.add(new Product("Audio cassette", new BigDecimal("2"), "USD", "Brings you the music", other, hotStuff));
            productDataStore.add(new Product("Fluxus capacitor", new BigDecimal("1985"), "USD", "Takes you back to the future.", other, flux));
            departmentDataStore.add(accessories);
            departmentDataStore.add(clothes);
            departmentDataStore.add(shoes);
        }

        //Save to Sql
        if (daoTypeIsSql){
            if(databaseManager.getAllProducts().size()==0) {
                databaseManager.saveProduct(new Product("Striped sunglasses", new BigDecimal("3"), "USD", "Super trendy party glasses.", glasses, hotStuff));
                databaseManager.saveProduct(new Product("Break sunglasses", new BigDecimal("5"), "USD", "Must-have party accessory.", glasses, hotStuff));
                databaseManager.saveProduct(new Product("Sophia Loren glasses", new BigDecimal("20"), "USD", "Classy glasses.", glasses, flash));
                databaseManager.saveProduct(new Product("Earrings", new BigDecimal("10"), "USD", "Neon earrings.", jewelery, flash));
                databaseManager.saveProduct(new Product("Bracelet", new BigDecimal("6"), "USD", "Bracelet with animal printing.", jewelery, hotStuff));
                databaseManager.saveProduct(new Product("Scrunchie", new BigDecimal("1"), "USD", "Colorful scrunchies.", jewelery, hotStuff));
                databaseManager.saveProduct(new Product("Multicolor heels", new BigDecimal("30"), "USD", "Must-have item.", heels, hotStuff));
                databaseManager.saveProduct(new Product("Rainbow heels", new BigDecimal("30"), "USD", "Party Queen heels.", heels, hotStuff));
                databaseManager.saveProduct(new Product("Classic Nike", new BigDecimal("100"), "USD", "Must-have item.", sneakers, flash));
                databaseManager.saveProduct(new Product("Reebok", new BigDecimal("70"), "USD", "Iconic sneakers.", sneakers, hotStuff));
                databaseManager.saveProduct(new Product("Red boot", new BigDecimal("40"), "USD", "Keeps you warm.", boots, flash));
                databaseManager.saveProduct(new Product("Boot with heels", new BigDecimal("50"), "USD", "Must-have item.", boots, hotStuff));
                databaseManager.saveProduct(new Product("Audio cassette", new BigDecimal("2"), "USD", "Brings you the music", other, hotStuff));
                databaseManager.saveProduct(new Product("Fluxus capacitor", new BigDecimal("1985"), "USD", "Takes you back to the future.", other, flux));
            }
        }

    }
}
