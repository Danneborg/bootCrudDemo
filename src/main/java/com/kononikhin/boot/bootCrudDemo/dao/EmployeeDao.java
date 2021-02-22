package com.kononikhin.boot.bootCrudDemo.dao;

import com.kononikhin.boot.bootCrudDemo.entity.Employee;

import java.util.List;

public interface EmployeeDao {

    public List<Employee> getAllEmployees();

    public Employee getById(int id);

    public void save(Employee employee);

    public void deleteById(int id);
}
