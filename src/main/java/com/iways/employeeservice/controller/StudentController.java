package com.iways.employeeservice.controller;

import com.iways.employeeservice.domain.Student;
import com.iways.employeeservice.dto.StudentDto;
import com.iways.employeeservice.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController{
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/create")
    public Student createStudent(@RequestBody StudentDto studentDto){
        return studentService.createStudent(studentDto);
    }
    @GetMapping("/getStudentByName")
    public Student studentByName(@RequestBody String name){
        return studentService.getStudentByName(name);
    }
}
