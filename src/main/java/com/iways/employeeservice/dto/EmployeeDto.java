package com.iways.employeeservice.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
public class EmployeeDto {
    private String name;
    private String address;
    private String phone;
    private String cnic;

}


