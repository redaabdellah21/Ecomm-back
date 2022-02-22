package org.pharmacie.appecommerce.web;

import org.pharmacie.appecommerce.entities.Employee;
import org.pharmacie.appecommerce.entities.Product;
import org.pharmacie.appecommerce.service.EmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private final EmployeeServices employeeServices;
    public EmployeeController(EmployeeServices employeeServices) {
        this.employeeServices = employeeServices;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployees(){
        List<Employee> employees = employeeServices.findAllEmployee();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
    @GetMapping(path="/photoEmployee/{id}",produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] getPhoto (@PathVariable("id") Long id) throws Exception{
        Employee employeeById = employeeServices.findEmployeeById(id);
        return Files.readAllBytes(Paths.get(System.getProperty("user.home")+"/ECommerce/employee/"+employeeById.getPhotName()));
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id")Long id){
        Employee employee = employeeServices.findEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        Employee newEmployee = employeeServices.AddEmployee(employee);
        return new ResponseEntity<>(newEmployee, HttpStatus.CREATED );
    }

    @PutMapping("/update")
    public ResponseEntity<Employee>  updateEmployee(@RequestBody Employee employee){
        Employee newEmployee = employeeServices.updateEmployee(employee);
        return new ResponseEntity<>(newEmployee, HttpStatus.OK );
    }


    @DeleteMapping(value="/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?>  deleteEmployee(@PathVariable("id")Long id){
        employeeServices.deleteEmployee( id);
        return new ResponseEntity<>( HttpStatus.OK );
    }
}
