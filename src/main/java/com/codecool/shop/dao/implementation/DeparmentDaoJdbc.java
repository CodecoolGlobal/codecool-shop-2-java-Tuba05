package com.codecool.shop.dao.implementation;

import com.codecool.shop.dao.DepartmentDao;
import com.codecool.shop.model.Department;
import com.codecool.shop.model.Product;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DeparmentDaoJdbc implements DepartmentDao {
    private final DataSource dataSource;

    public DeparmentDaoJdbc(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void add(Department department) {
        try (Connection conn = dataSource.getConnection()) {
            String sql = "INSERT INTO department (name) VALUES (?)";
            PreparedStatement statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, department.getName());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Department find(int id) {
        try (Connection conn = dataSource.getConnection()) {
            String sql = "SELECT * FROM department WHERE id = ?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (!rs.next()) {
                return null;
            }
            Department department = new Department(rs.getString(2));
            department.setId(rs.getInt(1));
            return department;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void remove(int id) {
        try (Connection conn = dataSource.getConnection()) {
            String sql = "DELETE * FROM department WHERE id = ?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, id);
            st.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Department> getAll() {
        List<Department> departments = new ArrayList<>();
        try (Connection conn = dataSource.getConnection()) {
            String sql = "SELECT * FROM department";
            ResultSet rs = conn.createStatement().executeQuery(sql);
            Department department = new Department(rs.getString(2));
            department.setId(rs.getInt(1));
            departments.add(department);
            return departments;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
