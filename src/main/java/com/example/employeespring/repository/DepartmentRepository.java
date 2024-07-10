package com.example.employeespring.repository;

import com.example.employeespring.view.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
