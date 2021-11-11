package com.codecool.shop.dao.implementation;

import com.codecool.shop.dao.DepartmentDao;
import com.codecool.shop.model.Department;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
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
        return null;
    }

    @Override
    public void remove(int id) {

    }

    @Override
    public List<Department> getAll() {
        return null;
    }
}
