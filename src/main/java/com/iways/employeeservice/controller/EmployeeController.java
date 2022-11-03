package com.iways.employeeservice.controller;

import com.iways.employeeservice.domain.Employee;
import com.iways.employeeservice.domain.Student;
import com.iways.employeeservice.dto.EmployeeDto;
import com.iways.employeeservice.dto.StudentDto;
import com.iways.employeeservice.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
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
    @PostMapping("/createStudent")
    public String createStudent(@RequestBody StudentDto studentDto){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<StudentDto> entity = new HttpEntity<>(studentDto, headers);

        return restTemplate.exchange(
                "http://localhost:8081/create", HttpMethod.POST, entity, String.class).getBody();

    }
    @PutMapping ("/updateStudent")
    public String update(@RequestParam int id, @RequestBody StudentDto studentDto){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<StudentDto> entity = new HttpEntity<>(studentDto, headers);

        return restTemplate.exchange(
                "http://localhost:8081/update/"+id, HttpMethod.PUT, entity, String.class).getBody();
    }
    @DeleteMapping("/deleteStudent")
    public String deleteStudent(@RequestParam int id){

        RestTemplate restTemplate = new RestTemplate();
           HttpHeaders headers = new HttpHeaders();
           headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
           HttpEntity<Student> entity = new HttpEntity<Student>(headers);

        return restTemplate.exchange(
                "http://localhost:8081/delete/"+id, HttpMethod.DELETE, entity, String.class).getBody();
    }



}


