package com.rts.rest.api.employee.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rts.rest.api.employee.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
  
}
