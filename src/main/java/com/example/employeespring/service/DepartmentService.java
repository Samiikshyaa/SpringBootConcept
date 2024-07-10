package com.example.employeespring.service;


import com.example.employeespring.view.Department;

import java.util.List;

public interface DepartmentService {
    void add(Department dep);
    List<Department> show();
    void deletedep(int id);
    Department getById(int id);
    void update(Department dept);

}
