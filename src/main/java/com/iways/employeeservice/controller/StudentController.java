package com.iways.employeeservice.controller;

import com.iways.employeeservice.domain.OperationEnum;
import com.iways.employeeservice.domain.Student;
import com.iways.employeeservice.dto.StudentDto;
import com.iways.employeeservice.service.StudentService;
import org.springframework.data.domain.Page;
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

    @GetMapping("/studentByMarks")
    public List<Student> studentByMarks(@RequestParam int scoreMarks){

        return studentService.findAll(scoreMarks);
    }
    @DeleteMapping("/deleteById")
    public String deleteById(@RequestParam int id) {

        return studentService.deleteId(id);
    }
    @PutMapping("/updateStudent")
    public String update(@RequestParam int id, @RequestBody StudentDto studentDto){
        return studentService.updateStudent(id, studentDto);
    }
    @GetMapping("/studentByIdAndCity")
    public Student studentByIdAndCity(@RequestParam int id,@RequestBody String city){
        return studentService.findByIdAndCity(id, city);
    }
    @GetMapping("/studentByNameAndEmail")
    public Student studentByNameAndEmail(@RequestBody String name,@RequestBody String email){
        return studentService.findByNameAndEmail(name, email);
    }
    @GetMapping("/studentByPageNumberAndPageSize")

    public Page<Student> studnrtByPage(@RequestParam int pageNumber, @RequestParam int pageSize){
        return studentService.findAll(pageNumber, pageSize);
    }
    @PutMapping("/performOperation")
    public String updateStatus(@RequestParam int id,@RequestParam OperationEnum operationEnum){
        return studentService.updateStatus(id, operationEnum);
    }
    @GetMapping("/getAllStudents")
    public List<Student> getStudents(){
        return studentService.getAllStudent();
    }

}
