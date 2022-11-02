package com.iways.employeeservice.service;
import com.iways.employeeservice.domain.Employee;
import com.iways.employeeservice.dto.EmployeeDto;
import com.iways.employeeservice.employeeservice.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;


    }

    public String createEmployee(EmployeeDto employeeDto) {
        Employee employee = new Employee(employeeDto.getName(), employeeDto.getAddress(), employeeDto.getPhone(), employeeDto.getCnic());
        employeeRepository.save(employee);
        log.info("saved employee {}", employee);
        return " saved employee";
    }

    public Optional<Employee> getEmployee(int id) {
        log.info("find by id {}", id);
        return employeeRepository.findById(id);
    }

    public String updatedEmployee(int id, EmployeeDto employeeDto) {

        Optional<Employee> optionalEmployee = getEmployee(id);
            if (optionalEmployee.isPresent()) {
               optionalEmployee.get().setName(employeeDto.getName());
               optionalEmployee.get().setAddress(employeeDto.getAddress());
               optionalEmployee.get().setPhone(employeeDto.getPhone());
               optionalEmployee.get().setCnic(employeeDto.getCnic());
               employeeRepository.save(optionalEmployee.get());
               log.info("update employeeDto {} id {}", employeeDto, id);
               return " update employee ";
            }else{
               return "employee not exist with id:"+id;
            }
    }

    public String deleteEmployee(int id) {
        employeeRepository.deleteById(id);
        log.info("delete id {}", id);
        return " delete employee";
    }

    public List<Employee> getAllEmployee() {
        log.info("find all {}" );
        return new ArrayList<>(employeeRepository.findAll());
    }
    public Page<Employee> getAllEmployee(Integer pageNumber, Integer pageSize){

        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        log.info("find all pageable {}", pageable);
        return this.employeeRepository.findAll(pageable);


    }
    public List<Employee> getEmployeeByAddress(String address){
        log.info("find by address {}", address);
        return employeeRepository.findByAddress(address);
    }

}
