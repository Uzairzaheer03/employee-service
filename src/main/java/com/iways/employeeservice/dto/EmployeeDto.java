package com.iways.employeeservice.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
public class EmployeeDto {
    private int id;
    private String name;
    private String address;
    private String phone;
    private String cnic;


    public EmployeeDto(String name, String address, String phone, String cnic) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.cnic = cnic;
    }

    public EmployeeDto() {

    }


}


