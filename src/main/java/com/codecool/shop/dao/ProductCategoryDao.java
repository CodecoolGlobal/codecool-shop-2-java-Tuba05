package com.codecool.shop.dao;

import com.codecool.shop.model.Department;
import com.codecool.shop.model.ProductCategory;

import java.util.List;

public interface ProductCategoryDao {

    void add(ProductCategory category);
    ProductCategory find(int id);
    List <ProductCategory> find(String department);
    void remove(int id);

    List<ProductCategory> getAll();

}
