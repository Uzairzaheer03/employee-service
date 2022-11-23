package com.iways.employeeservice.employeeservice.repository;

import com.iways.employeeservice.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;



public interface StudentRepository extends JpaRepository<Student, Integer> {


}
