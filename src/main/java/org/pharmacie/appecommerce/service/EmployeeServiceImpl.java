package org.pharmacie.appecommerce.service;

import org.pharmacie.appecommerce.dao.EmployeeRepository;
import org.pharmacie.appecommerce.entities.Employee;
import org.pharmacie.appecommerce.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;
// la logique du metier est developpée ici

@Service
public class EmployeeServiceImpl implements EmployeeServices{
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    @Override
    @Transactional
    public Employee AddEmployee(Employee employee){
        return employeeRepository.save(employee);
    }
    @Override
    @Transactional
    public List<Employee> findAllEmployee(){
        return employeeRepository.findAll();
    }
    @Override
    @Transactional
    public Employee updateEmployee (Employee employee){
        return employeeRepository.save(employee);
    }
    @Override
    @Transactional
    public Employee findEmployeeById(Long id)  {
        return employeeRepository.findEmployeeById(id).orElseThrow(()->new UserNotFoundException("User by id :"+id+"was not found"));
    }

    @Override
    @Transactional
    public void deleteEmployee (Long id){
        employeeRepository.deleteEmployeeById(id);
    }
}
