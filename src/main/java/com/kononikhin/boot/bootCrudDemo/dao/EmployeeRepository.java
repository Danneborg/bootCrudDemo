package com.kononikhin.boot.bootCrudDemo.dao;

import com.kononikhin.boot.bootCrudDemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
