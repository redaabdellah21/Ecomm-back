package org.pharmacie.appecommerce.service;

import org.pharmacie.appecommerce.entities.Employee;

import java.util.List;

public interface EmployeeServices {
    public Employee AddEmployee(Employee employee);
    public List<Employee> findAllEmployee();
    public Employee updateEmployee (Employee employee);
    public Employee findEmployeeById(Long id) ;
    public void deleteEmployee (Long id);
}
