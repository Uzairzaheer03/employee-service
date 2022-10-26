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
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
  private  int id;
  private  String name;
  private  String address;
  private  String phone;
  private  String cnic;


    public Employee(String name, String address, String phone, String cnic){
        this.name=name;
        this.address=address;
        this.phone=phone;
        this.cnic=cnic;
    }

    public Employee() {

    }

    public void add(Employee employee) {
    }
}
