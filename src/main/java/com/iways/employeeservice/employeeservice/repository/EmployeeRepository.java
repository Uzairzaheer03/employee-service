package com.iways.employeeservice.employeeservice.repository;

import com.iways.employeeservice.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    Optional<Employee> findByAddress(String address);
}
