package com.rts.rest.api.employee.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rts.rest.api.employee.entity.Employee;
import com.rts.rest.api.employee.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee findById(@PathVariable("employeeId") int employeeId) {
        Employee findEmployee = employeeService.findById(employeeId);
        if (findEmployee == null) {
            throw new RuntimeException("Employee id not found - " + employeeId);
        }

        return findEmployee;
    }

    @PostMapping("/employees")
    public Employee save(@RequestBody Employee employee) {
        employee.setId(0);
        employee.toString();
        return employeeService.save(employee);
    }

}
