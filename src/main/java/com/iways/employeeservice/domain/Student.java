package com.iways.employeeservice.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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


    public Student(String name, String email, String phone, String city) {
        this.name=name;
        this.email=email;
        this.phone=phone;
        this.city=city;
    }
    public Student() {

    }



}
