package com.iways.employeeservice.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
public class SalaryDto {
    private int  monthly;
    private int perYearSalary;
    private int tax;


}


