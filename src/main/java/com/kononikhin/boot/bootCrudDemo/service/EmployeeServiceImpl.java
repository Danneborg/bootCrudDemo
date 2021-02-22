package com.kononikhin.boot.bootCrudDemo.service;

import com.kononikhin.boot.bootCrudDemo.dao.EmployeeRepository;
import com.kononikhin.boot.bootCrudDemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getById(int id) {

        Optional<Employee> employee = employeeRepository.findById(id);

        Employee employee1 = null;

        if (employee.isPresent()) {
            employee1 = employee.get();
        } else {
            throw new RuntimeException("Employee with id =" + id + " not found");
        }

        return employee1;
    }

    @Override
    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }
}
