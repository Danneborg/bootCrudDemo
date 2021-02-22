package com.kononikhin.boot.bootCrudDemo.service;

import com.kononikhin.boot.bootCrudDemo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmployees();

    Employee getById(int id);

    void deleteById(int id);

    void save(Employee employee);

}
