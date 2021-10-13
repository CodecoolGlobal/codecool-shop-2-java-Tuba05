package com.codecool.shop.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Department extends BaseModel {
    private transient List<ProductCategory> categories;

    public Department(String name) {
        super(name);
    }


    public void setCategories(ArrayList<ProductCategory> categories) {
        this.categories = categories;
    }

    public List<ProductCategory> getProductCategories() {
        return this.categories;
    }

    public void addProductCategory(ProductCategory category) {
        this.categories.add(category);
    }

    @Override
    public String toString() {
        return String.format(
                "id: %1$d," +
                        "name: %2$s, " +
                        this.id,
                this.name);
    }
}
