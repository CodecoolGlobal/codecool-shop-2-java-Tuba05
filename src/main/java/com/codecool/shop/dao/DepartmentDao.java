package com.codecool.shop.dao;

import com.codecool.shop.model.Department;
import com.codecool.shop.model.Supplier;

import java.util.List;

public interface DepartmentDao {

    void add(Department department);
    Department find(int id);
    void remove(int id);

    List<Department> getAll();
}
