package com.rts.rest.api.employee.service;

import java.util.List;

import com.rts.rest.api.employee.entity.Employee;

public interface EmployeeService {
    List<Employee> findAll();

    Employee findById(int id);

    Employee save(Employee employee);

    void deleteById(int id);
}
