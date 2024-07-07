package com.rts.rest.api.employee.dao;

import java.util.List;

import com.rts.rest.api.employee.entity.Employee;

public interface EmployeeRepository {
    List<Employee> findAll();

    Employee findById(int id);

    Employee save(Employee employee);

    void deleteById(int id);
}
