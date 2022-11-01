package com.iways.employeeservice.employeeservice.repository;

import com.iways.employeeservice.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    List<Employee> findByAddress(String address);
}
