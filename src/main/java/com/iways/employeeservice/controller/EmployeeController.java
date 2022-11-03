package com.iways.employeeservice.controller;

import com.iways.employeeservice.domain.Employee;
import com.iways.employeeservice.domain.Student;
import com.iways.employeeservice.dto.EmployeeDto;
import com.iways.employeeservice.dto.StudentDto;
import com.iways.employeeservice.service.EmployeeService;
import io.swagger.models.HttpMethod;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.Service;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
@Validated
public class EmployeeController {

    private final EmployeeService employeeService;
    private RestTemplate restTemplate;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/create")
    public String create(@RequestBody EmployeeDto employeeDto){
        log.info("Request for create employeeDto {}", employeeDto);
        return employeeService.createEmployee(employeeDto);

    }

    @GetMapping("/getEmployeeById")
    public Optional<Employee> getEmployeeById(@RequestParam int id){
        log.info("Request received to get employee by id {}",id);
        return  employeeService.getEmployee(id);
    }
    @PutMapping("/update")
    public String update(@RequestParam int id, @RequestBody EmployeeDto employeeDto){
        log.info("Request recieved for update employeeDto {} for id {}", employeeDto, id );
        return employeeService.updatedEmployee(id, employeeDto);
    }
    @DeleteMapping("/delete")
    public String deleteEmployee(@RequestParam int id){
        log.info("Request recieved for delete id {}", id);
        return employeeService.deleteEmployee(id);
    }

    @GetMapping("/employees")
        public List<Employee> getAllEmployee(){
        log.info("Request recieved for get all employee {}");
        return employeeService.getAllEmployee();
        }

    @GetMapping("/employeeByPage")
        public Page<Employee> getAllEmployee(
                @RequestParam (value = "pageNumber", defaultValue = "0", required = false) Integer pageNumber,
                @RequestParam (value = "pageSize", defaultValue = "3", required = false) Integer pageSize
                ){
                    log.info("Request recieved for employee by pageNumber {} for pageSize {}", pageNumber, pageSize);
                    return employeeService.getAllEmployee(pageNumber, pageSize);

    }
    @GetMapping("/getEmployeeByAddress")
    public List<Employee> employeeByAddress(@RequestParam String address){
        log.info("Request recieved for get employee by address {}", address);
        return employeeService.getEmployeeByAddress(address);
    }
    @GetMapping("/fetchStudent")
    public List<Student> fetchStudent(){

        RestTemplate restTemplate = new RestTemplate();
            String url = "http://localhost:8081/students";
            return restTemplate.getForObject(url, List.class);


    }
    @GetMapping("/createStudent")
    public String createStudent(StudentDto studentDto){

        RestTemplate restTemplate = new RestTemplate();
          String url = "http://localhost:8081/students";
          return restTemplate.getForObject(url, String.class);

    }


}


