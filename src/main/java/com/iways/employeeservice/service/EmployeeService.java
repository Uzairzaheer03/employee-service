package com.iways.employeeservice.service;
import com.iways.employeeservice.domain.Employee;
import com.iways.employeeservice.dto.EmployeeDto;
import com.iways.employeeservice.employeeservice.repository.EmployeeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;


    }

    public String createEmployee(EmployeeDto employeeDto) {
        Employee employee = new Employee(employeeDto.getName(), employeeDto.getAddress(), employeeDto.getPhone(), employeeDto.getCnic());
        employeeRepository.save(employee);
        return " saved employee";
    }

    public Optional<Employee> getEmployee(int id) {

        return employeeRepository.findById(id);
    }

    public String updatedEmployee(int id, EmployeeDto employeeDto) {

        Optional<Employee> optionalEmployee = getEmployee(id);
        optionalEmployee.get().setName(employeeDto.getName());
        optionalEmployee.get().setAddress(employeeDto.getAddress());
        optionalEmployee.get().setPhone(employeeDto.getPhone());
        optionalEmployee.get().setCnic(employeeDto.getCnic());
        employeeRepository.save(optionalEmployee.get());
        return " update employee ";
    }

    public String deleteEmployee(int id) {
        employeeRepository.deleteById(id);
        return " delete employee";
    }

    public List<Employee> getAllEmployee() {
        List<Employee> employees = new ArrayList<Employee>();
        employeeRepository.findAll().forEach(employee -> employees.add(employee));;
        return employees;

    }
    public Page<Employee> getAllEmployee(Integer pageNumber, Integer pageSize){

        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<Employee> pageEmployee = this.employeeRepository.findAll(pageable);

        List<Employee> employees = pageEmployee.getContent();
                return pageEmployee;


    }
    public Optional<Employee> getEmployeeByAddress(String address){

        return employeeRepository.findByAddress(address);
    }

}
