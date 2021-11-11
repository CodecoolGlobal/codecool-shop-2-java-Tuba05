package com.codecool.shop.dao.implementation;

import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.model.Department;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductCategoryDaoJdbc implements ProductCategoryDao {

    private final DataSource dataSource;

    public ProductCategoryDaoJdbc(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void add(ProductCategory category) {
        try (Connection conn = dataSource.getConnection()) {
            String sql = "INSERT INTO product_categories (name, department, description) VALUES (?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, category.getName());
            statement.setString(2, category.getDepartment().getName());
            statement.setString(3, category.getDescription());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ProductCategory find(int id) {
        return null;
    }

    @Override
    public ProductCategory findByName(String name) {
        try (Connection conn = dataSource.getConnection()) {
            String sql = "SELECT * FROM product_categories WHERE name = ?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, name);
            ResultSet rs = st.executeQuery();
            if (!rs.next()) {
                return null;
            }
            return new ProductCategory(rs.getString(2), new Department(rs.getString(3)), rs.getString(4));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<ProductCategory> find(String department) {
        return null;
    }

    @Override
    public void remove(int id) {

    }

    @Override
    public List<ProductCategory> getAll() {
        try (Connection conn = dataSource.getConnection()) {
            String sql = "SELECT * FROM product_categories";
            ResultSet rs = conn.createStatement().executeQuery(sql);
            List<ProductCategory> productCategories = new ArrayList<>();
            while (rs.next()){
                ProductCategory productCategory =
                        new ProductCategory(rs.getString(2), new Department(rs.getString(3)), rs.getString(4));
                productCategory.setId(rs.getInt(1));
                productCategories.add(productCategory);
            }
            return productCategories;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
