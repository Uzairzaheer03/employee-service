package com.iways.employeeservice.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {

    private String name;
    private String email;
    private String phone;
    private String city;


    private List<CourseDto> courseDtos;
}
