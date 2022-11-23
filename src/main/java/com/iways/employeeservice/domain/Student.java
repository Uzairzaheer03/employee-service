package com.iways.employeeservice.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@ToString

public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    private String phone;
    private String city;


    @JoinColumn(name = "student_id")
    @OneToMany(cascade = CascadeType.ALL)
    private List<Course> courses;

}
