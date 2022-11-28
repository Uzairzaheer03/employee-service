package com.iways.employeeservice.service;

import com.iways.employeeservice.domain.Course;
import com.iways.employeeservice.domain.OperationEnum;
import com.iways.employeeservice.domain.Student;
import com.iways.employeeservice.dto.StudentDto;
import com.iways.employeeservice.employeeservice.repository.StudentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
//          }
        //---------Using forEach Stream----------//

          studentDto.getCourseDtos().stream().forEach(courseDto -> {
              Course course = new Course();
              course.setCourseName(courseDto.getCourseName());
              course.setScoreMarks(courseDto.getScoreMarks());
              courses.add(course);
         });

        //--------------------------Using Filter Stream------------------------------//

//         CourseDto obj = studentDto.getCourseDtos().stream().filter(c -> c.getCourseName().equalsIgnoreCase("java")).findFirst().get();
//        Course course = new Course();
//        course.setCourseName(obj.getCourseName());
//        course.setScoreMarks(obj.getScoreMarks());
//        courses.add(course);
          student.setCourses(courses);
          return studentRepository.save(student);
    }
    public List<Student> findAll(int scoreMarks) {
        List<Student> students   = studentRepository.findAll();

           //------------------------------Filter In Stream--------------------------------//
        students.stream().forEach(student -> {
            List<Course> filterList= student.getCourses().stream().filter(course ->  course.getScoreMarks() >= scoreMarks).collect(Collectors.toList());
            student.setCourses(filterList);
        });
        return students;
    }
    public String deleteId(int id) {

        studentRepository.deleteById(id);
        return "delete student";
    }
    public String updateStudent(int id, StudentDto studentDto) {
        Optional<Student> student = studentRepository.findById(id);
        if(student.isPresent()) {
            student.get().setName(studentDto.getName());
            student.get().setEmail(studentDto.getEmail());
            student.get().setPhone(studentDto.getPhone());
            student.get().setCity(studentDto.getCity());
            studentRepository.save(student.get());
            return "updateStudent";
        }else {
            return "update does not exist";
        }
    }
    public Student findByIdAndCity(int id, String city) {

        return studentRepository.findStudentByIdAndCity(id, city);
    }
    public Student findByNameAndEmail(String name, String email) {
        return studentRepository.findByNameAndEmail(name, email);
    }
    public Page<Student> findAll(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return studentRepository.findAll(pageable);

    }
    public String updateStatus(int id, OperationEnum operationEnum) {
        Optional<Student> student = studentRepository.findById(id);
        if(student.isPresent()) {
            student.get().setStatus(operationEnum.toString());
            studentRepository.save(student.get());
            return "update status";
        }else{
            return "update status does not exist";
        }

    }
    public List<Student> getAllStudent() {
        return studentRepository.findAll();

    }




}
