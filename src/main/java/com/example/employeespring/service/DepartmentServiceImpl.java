package com.example.employeespring.service;

import com.example.employeespring.repository.DepartmentRepository;
import com.example.employeespring.view.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    DepartmentRepository deprepo;

    @Override
    public void add(Department dep) {
        deprepo.save(dep);
    }

    @Override
    public List<Department> show() {
        return deprepo.findAll();
    }

    @Override
    public void deletedep(int id) {
        deprepo.deleteById(id);
    }

    @Override
    public Department getById(int id) {
        return deprepo.findById(id).get();
    }

    @Override
    public void update(Department dept) {
        deprepo.save(dept);
    }

}
