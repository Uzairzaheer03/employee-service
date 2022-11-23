package com.iways.employeeservice.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@ToString
@Setter
@Getter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private String name;
    private String address;
    private String phone;
    private String cnic;

    @OneToOne(cascade = CascadeType.ALL)
    private Salary salary;
}
