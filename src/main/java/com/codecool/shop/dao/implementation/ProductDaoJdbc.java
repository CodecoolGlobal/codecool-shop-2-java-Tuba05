package com.codecool.shop.dao.implementation;

import com.codecool.shop.dao.*;
import com.codecool.shop.model.Department;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoJdbc implements ProductDao {
    private ProductDao productDao;
    private ProductCategoryDao productCategoryDao;
    private ShoppingCartDao shoppingCartDao;
    private SupplierDao supplierDao;
    private final DataSource dataSource;

    public ProductDaoJdbc(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void add(Product product) {
        try (Connection conn = dataSource.getConnection()) {
            String sql = "INSERT INTO products (name, price, description, category, supplier) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, product.getName());
            statement.setBigDecimal(2, product.getPrice());
            statement.setString(3, product.getDescription());
            statement.setString(4, product.getProductCategory().getName());
            statement.setString(5, product.getSupplier().getName());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Product find(int id) {
        try (Connection conn = dataSource.getConnection()) {
            String sql = "SELECT * FROM products WHERE id = ?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (!rs.next()) {
                return null;
            }
            return new Product(rs.getString(2), rs.getBigDecimal(3), "USD", rs.getString(4),
                    productCategoryDao.findByName(rs.getString(4)), supplierDao.find(rs.getString(5)));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void remove(int id) {
        try (Connection conn = dataSource.getConnection()) {
            String sql = "DELETE * FROM products WHERE id = ?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, id);
            st.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Product> getAll() {
        try (Connection conn = dataSource.getConnection()) {
            String sql = "SELECT * FROM products";
            ResultSet rs = conn.createStatement().executeQuery(sql);
            return getListOfProducts(rs);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Product> getBy(Supplier supplier) {
        try (Connection conn = dataSource.getConnection()) {
            String sql = "SELECT * FROM products WHERE supplier = ?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, supplier.getName());
            ResultSet rs = st.executeQuery();
            return getListOfProducts(rs);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Product> getBySupplier(String supplier) {
        try (Connection conn = dataSource.getConnection()) {
            String sql = "SELECT * FROM products WHERE supplier = ?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, supplier);
            ResultSet rs = st.executeQuery();
            return getListOfProducts(rs);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Product> getBy(ProductCategory productCategory) {
        try (Connection conn = dataSource.getConnection()) {
            String sql = "SELECT * FROM products WHERE category = ?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, productCategory.getName());
            ResultSet rs = st.executeQuery();
            return getListOfProducts(rs);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Product> getBy(String productCategory) {
        try (Connection conn = dataSource.getConnection()) {
            String sql = "SELECT * FROM products WHERE category = ?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, productCategory);
            ResultSet rs = st.executeQuery();
            return getListOfProducts(rs);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private List<Product> getListOfProducts(ResultSet rs) throws SQLException {
        List<Product> products = new ArrayList<>();
        while (rs.next()){
            Product product =
                    new Product(rs.getString(2), rs.getBigDecimal(3), "USD", rs.getString(4),
                            productCategoryDao.findByName(rs.getString(4)), supplierDao.find(rs.getString(5)));
            product.setId(rs.getInt(1));
            products.add(product);
        }
        return products;
    }
}
