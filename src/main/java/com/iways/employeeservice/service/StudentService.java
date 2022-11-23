package com.iways.employeeservice.service;

import com.iways.employeeservice.domain.Course;
import com.iways.employeeservice.domain.Student;
import com.iways.employeeservice.dto.CourseDto;
import com.iways.employeeservice.dto.StudentDto;
import com.iways.employeeservice.employeeservice.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {


    private final StudentRepository studentRepository;

    public StudentService (StudentRepository studentRepository){
        this.studentRepository=studentRepository;
    }

    public Student createStudent(StudentDto studentDto){
        Student student = new Student();
        student.setName(studentDto.getName());
        student.setCity(studentDto.getCity());
        student.setEmail(studentDto.getEmail());
        student.setPhone(studentDto.getPhone());

         List<Course> courses = new ArrayList<>();
//          for(int i = 0; i<studentDto.getCourseDtos().size(); i++){
//
//              CourseDto  courseDto = studentDto.getCourseDtos().get(i);
//              Course course = new Course();
//              course.setCourseName(courseDto.getCourseName());
//              courses.add(course);
//
//          }
        //---------Using forEach Stream----------//

//          studentDto.getCourseDtos().stream().forEach(courseDto -> {
//              Course course = new Course();
//              course.setCourseName(courseDto.getCourseName());
//              courses.add(course)
//         });

        //----------------Using Filter Stream-------------------//

         CourseDto obj = studentDto.getCourseDtos().stream().filter(c -> c.getCourseName().equalsIgnoreCase("java")).findFirst().get();
        Course course = new Course();
        course.setCourseName(obj.getCourseName());
        courses.add(course);
          student.setCourses(courses);
          return studentRepository.save(student);

    }



}
