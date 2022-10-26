package com.iways.employeeservice.employeeservice.repository;

import com.iways.employeeservice.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
