package com.iways.employeeservice.employeeservice.repository;

import com.iways.employeeservice.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface StudentRepository extends JpaRepository<Student, Integer> {
    @Query(value = "SELECT * FROM student where id=:id and city=:city",
            nativeQuery = true)


    public Student findStudentByIdAndCity(int id, String city);

    @Query(value = "SELECT * FROM student where name=:name and email=:email", nativeQuery = true)
    public Student findByNameAndEmail(String name, String email);
    List<Student> getStudentByName(String name);


}
