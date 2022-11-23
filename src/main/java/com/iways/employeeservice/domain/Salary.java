package com.iways.employeeservice.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@ToString
@Setter
@Getter
public class Salary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private int  monthly;
    private int perYearSalary;
    private int tax;

}
