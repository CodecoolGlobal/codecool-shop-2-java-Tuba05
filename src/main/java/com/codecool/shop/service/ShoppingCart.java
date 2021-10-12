package com.codecool.shop.service;

import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.dao.ProductDao;
import java.util.HashMap;

public class ShoppingCart extends ProductService{
    private HashMap<Integer, String> productsInCart = new HashMap<>();

    public ShoppingCart(ProductDao productDao, ProductCategoryDao productCategoryDao, HashMap productsInCart) {
        super(productDao, productCategoryDao);
        this.productsInCart = productsInCart;
    }

    public HashMap<Integer, String> getProductsInCart() {
        return productsInCart;
    }

    public void setProductsInCart(HashMap<Integer, String> productsInCart) {
        this.productsInCart = productsInCart;
    }
}
