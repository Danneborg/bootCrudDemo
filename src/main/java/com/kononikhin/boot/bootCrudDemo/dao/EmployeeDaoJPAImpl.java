package com.kononikhin.boot.bootCrudDemo.dao;

import com.kononikhin.boot.bootCrudDemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmployeeDaoJPAImpl implements EmployeeDao {

    private EntityManager entityManager;

    @Autowired
    public EmployeeDaoJPAImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> getAllEmployees() {

        Query query = entityManager.createQuery("from Employee");

        List<Employee> employeeList = query.getResultList();

        return employeeList;
    }

    @Override
    public Employee getById(int id) {

        Employee employee = entityManager.find(Employee.class, id);

        return employee;
    }

    @Override
    public void save(Employee employee) {

        Employee dbEmployee = entityManager.merge(employee);

        employee.setId(dbEmployee.getId());

    }

    @Override
    public void deleteById(int id) {
        Query query = entityManager.createQuery("delete from Employee where id=:id");

        query.setParameter("id", id);

        query.executeUpdate();

    }
}
