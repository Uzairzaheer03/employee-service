package com.iways.employeeservice.service;
import com.iways.employeeservice.domain.Employee;
import com.iways.employeeservice.employeeservice.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private EmployeeService employeeRepoitory;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;


    }

    public String createEmployee(String name, String address, String phone, String cnic) {
        Employee employee = new Employee(name, address, phone, cnic);
        employeeRepository.save(employee);
        return " saved employee";
    }

    public Optional<Employee> getEmployee(int id) {

        return employeeRepository.findById(id);
    }

    public String updatedEmployee(int id, String name, String address, String phone, String cnic) {

        Optional<Employee> optionalEmployee = getEmployee(id);
        optionalEmployee.get().setName(name);
        optionalEmployee.get().setAddress(address);
        optionalEmployee.get().setPhone(phone);
        optionalEmployee.get().setCnic(cnic);
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
}
