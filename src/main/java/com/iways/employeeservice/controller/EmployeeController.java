package com.iways.employeeservice.controller;

import com.iways.employeeservice.domain.Employee;
import com.iways.employeeservice.dto.EmployeeDto;
import com.iways.employeeservice.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
@Validated
public class EmployeeController {

    private EmployeeService employeeService = null;

    public EmployeeController(EmployeeService employeeService) {

        this.employeeService = employeeService;
    }

    @GetMapping("/employee")
    public List<Employee> getAllEmployees(){
        return Arrays.asList(
                new Employee("name", "address", "phone", "cnic"),
                new Employee("Uzair Zaheer", "Lahore", "03104983997", "35000"));

    }
    @PostMapping("/create")
    public String create(@RequestBody EmployeeDto employeeDto){
        return employeeService.createEmployee(employeeDto);

    }

    @GetMapping("/getEmployeeById")
    public Optional<Employee> getEmployeeById(@RequestParam int id){
        log.info("Request received to get employee by id {}",id);
        return  employeeService.getEmployee(id);
    }
    @PutMapping("/update")
    public String update(@RequestParam int id, EmployeeDto employeeDto){
        return employeeService.updatedEmployee(id, employeeDto);
    }
    @DeleteMapping("/delete")
    public String deleteEmployee(@RequestParam int id){
        return employeeService.deleteEmployee(id);
    }

    @GetMapping("/employees")
        public List<Employee> getAllEmployee(){

        return employeeService.getAllEmployee();
        }

    @GetMapping("/employeeByPage")
        public Page<Employee> getAllEmployee(
                @RequestParam (value = "pageNumber", defaultValue = "0", required = false) Integer pageNumber,
                @RequestParam (value = "pageSize", defaultValue = "3", required = false) Integer pageSize
                ){

        return employeeService.getAllEmployee(pageNumber, pageSize);

    }

}


