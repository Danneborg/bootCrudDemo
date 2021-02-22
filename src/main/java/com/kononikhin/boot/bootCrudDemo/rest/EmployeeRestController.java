package com.kononikhin.boot.bootCrudDemo.rest;

import com.kononikhin.boot.bootCrudDemo.dao.EmployeeDao;
import com.kononikhin.boot.bootCrudDemo.entity.Employee;
import com.kononikhin.boot.bootCrudDemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployee() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getSingleEmployee(@PathVariable int employeeId) {

        Employee employee = employeeService.getById(employeeId);

        if (employee == null) {
            throw new RuntimeException("Employee not found with id = " + employeeId);
        }

        return employee;
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteSingleEmployee(@PathVariable int employeeId) {

        Employee employee = employeeService.getById(employeeId);

        if (employee == null) {
            throw new RuntimeException("Employee not found with id = " + employeeId);
        }

        employeeService.deleteById(employeeId);

        return "Employee with id = " + employeeId + " has been deleted";
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {

        employee.setId(0);

        employeeService.save(employee);

        return employee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {

        employeeService.save(employee);

        return employee;
    }
}
