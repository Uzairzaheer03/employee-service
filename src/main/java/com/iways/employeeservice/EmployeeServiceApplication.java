package com.iways.employeeservice;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class EmployeeServiceApplication {

public static void main(String[] args) {
          SpringApplication.run(EmployeeServiceApplication.class, args);
    }
}