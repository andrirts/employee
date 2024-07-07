package com.rts.rest.api.employee.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rts.rest.api.employee.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

    private EntityManager entityManager;

    @Autowired
    public EmployeeRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", Employee.class);
        List<Employee> employees = theQuery.getResultList();
        return employees;
    }

    @Override
    public Employee findById(int id) {
        return entityManager.find(Employee.class, id);
    }

    @Override
    public Employee save(Employee employee) {
        Employee saveEmployee = entityManager.merge(employee);
        return saveEmployee;
    }

    @Override
    public void deleteById(int id) {
        Employee findById = this.findById(id);
        entityManager.remove(findById);
    }

}
