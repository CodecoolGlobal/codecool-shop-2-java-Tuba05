package com.codecool.shop.dao.implementation;

import com.codecool.shop.dao.DepartmentDao;
import com.codecool.shop.model.Department;
import com.codecool.shop.model.ProductCategory;

import java.util.ArrayList;
import java.util.List;

public class DepartmentDaoMem implements DepartmentDao {
    private List<Department> data = new ArrayList<>();
    private static DepartmentDaoMem instance = null;

    /* A private Constructor prevents any other class from instantiating.
     */
    private DepartmentDaoMem() {
    }

    public static DepartmentDaoMem getInstance() {
        if (instance == null) {
            instance = new DepartmentDaoMem();
        }
        return instance;
    }

    @Override
    public void add(Department department) {
        department.setId(data.size() + 1);
        data.add(department);
    }

    @Override
    public Department find(int id) {
        return data.stream().filter(t -> t.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void remove(int id) {
        data.remove(find(id));
    }

    @Override
    public List<Department> getAll() {
        return data;
    }
}
